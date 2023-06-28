package com.example.entitylifecycle;

import com.example.entitylifecycle.models.user.Student;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.EntityEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : entity-lifecycle
 * @Package : com.example.entitylifecycle
 * @ClassName : .java
 * @createTime : 2023/6/27 10:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@SpringJUnitConfig(classes = {EntityLifecycleApplication.class})
@TestPropertySource("classpath:application.properties")
@Import(StudentsConfig.class)
public class EntityLifecycleTests {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateLifecycleUtil hibernateLifecycleUtil;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private List<Student> students;

    @BeforeEach
    void beforeEach() {
        DirtyDataRecorderInterceptor.clearDirtyEntitites();
        studentRepository.deleteAll();
        studentRepository.saveAll(students);
    }

    @Test
    void testPersist() {
        Assertions.assertTrue(DirtyDataRecorderInterceptor.getDirtyEntities().isEmpty());
        // 注意，如果通过 sessionFactory.openSession() 获取 Session 对象，将获取一个代理对象。
        // 通过 sessionFactory.withOptions().interceptor(...).openSession() 获取到的是真实的 Session 对象。
        Session session = sessionFactory.withOptions().interceptor(new DirtyDataRecorderInterceptor()).openSession();
        Transaction transaction = session.beginTransaction();
        var student = new Student("icexmoon", LocalDate.of(1990, 1, 1), Gender.MALE);
        session.persist(student);
        List<EntityEntry> managedEntities = hibernateLifecycleUtil.getManagedEntities(session);
        Assertions.assertFalse(managedEntities.isEmpty());
        Assertions.assertEquals(1, managedEntities.size());
        // 事务提交后才会插入数据库
        transaction.commit();
        session.close();
        assertStudentsCount(4);
    }

    private void assertStudentsCount(int expected) {
        long count = studentRepository.count();
        Assertions.assertEquals(expected, count);
    }

    @Test
    void testPersistWithNoSessionCommited() {
        Assertions.assertTrue(DirtyDataRecorderInterceptor.getDirtyEntities().isEmpty());
        Session session = sessionFactory.withOptions().interceptor(new DirtyDataRecorderInterceptor()).openSession();
        Transaction transaction = session.beginTransaction();
        var student = new Student("icexmoon", LocalDate.of(1990, 1, 1), Gender.MALE);
        // Session.save()方法已过期，现在只能使用 persist 方法添加实体到 Session。
        session.persist(student);
        List<EntityEntry> managedEntities = hibernateLifecycleUtil.getManagedEntities(session);
        Assertions.assertFalse(managedEntities.isEmpty());
        Assertions.assertEquals(1, managedEntities.size());
        // 这里并没有提交事务
        session.flush();
        session.close();
        // 通过 persist 添加的对象没有被插入数据库
        assertStudentsCount(3);
    }

    @Test
    void testPersistWithDetachedEntity() {
        Assertions.assertTrue(DirtyDataRecorderInterceptor.getDirtyEntities().isEmpty());
        Session session = sessionFactory.withOptions().interceptor(new DirtyDataRecorderInterceptor()).openSession();
        Transaction transaction = session.beginTransaction();
        var student = new Student("icexmoon", LocalDate.of(1990, 1, 1), Gender.MALE);
        // 添加实体，实体编程持久化的
        session.persist(student);
        // 删除实体，实体编程已分离的
        session.evict(student);
        // 尝试添加已分离的实体，会抛出一个PersistentObjectException异常
        Assertions.assertThrows(PersistentObjectException.class, () -> {
            session.persist(student);
        });
        List<EntityEntry> managedEntities = hibernateLifecycleUtil.getManagedEntities(session);
        Assertions.assertTrue(managedEntities.isEmpty());
        Assertions.assertEquals(0, managedEntities.size());
        transaction.commit();
        session.close();
        assertStudentsCount(3);
    }

    @Test
    void testMerge() {
        Session session = sessionFactory.withOptions().interceptor(new DirtyDataRecorderInterceptor()).openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createQuery("from user_student", Student.class)
                .getResultList();
        var icexmoon = students.stream().filter(student -> student.getName().equals("icexmoon"))
                .findFirst().get();
        // 分离实体，分离后可以对实体进行序列化/反序列化等操作
        session.evict(icexmoon);
        icexmoon.setBirthDay(LocalDate.of(2000, 5, 1));
        Student mergedIcexmoon = session.merge(icexmoon);
        // 合并后的 entity 与原始 entity 不是同一个对象，但内容一致
        Assertions.assertNotSame(mergedIcexmoon, icexmoon);
        Assertions.assertEquals(mergedIcexmoon, icexmoon);
        transaction.commit();
        session.close();
        List<Object> dirtyEntities = DirtyDataRecorderInterceptor.getDirtyEntities();
        Assertions.assertEquals(1, dirtyEntities.size());
        Assertions.assertEquals(icexmoon, dirtyEntities.get(0));
        // 检查是否插入数据库
        var modifiedStudents = studentRepository.findAll();
        var student = modifiedStudents.stream().filter(s -> s.getName().equals(mergedIcexmoon.getName())).findFirst().get();
        Assertions.assertEquals(mergedIcexmoon, student);
    }

    @Test
    void testMergeWithNewEntity() {
        Session session = sessionFactory.withOptions().interceptor(new DirtyDataRecorderInterceptor()).openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createQuery("from user_student", Student.class)
                .getResultList();
        // 持久实体 merge
        var icexmoon = students.stream().filter(student -> student.getName().equals("icexmoon"))
                .findFirst().get();
        icexmoon.setBirthDay(LocalDate.of(2002, 6, 1));
        var mergedIcexmoon = session.merge(icexmoon);
        // 没有任何事情发生，merge 返回的对象和被 merge 的是同一个（已经是持久实体）
        Assertions.assertSame(mergedIcexmoon, icexmoon);
        Assertions.assertEquals(mergedIcexmoon, icexmoon);
        transaction.commit();
        session.close();
        List<Object> dirtyEntities = DirtyDataRecorderInterceptor.getDirtyEntities();
        // 修改过实体，所以这里有脏数据
        Assertions.assertEquals(1, dirtyEntities.size());
        // 只存在数据修改，数据条目没有变化
        assertStudentsCount(students.size() );
    }

    @Test
    void testMergeWithPersistedEntity() {
        Session session = sessionFactory.withOptions().interceptor(new DirtyDataRecorderInterceptor()).openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createQuery("from user_student", Student.class)
                .getResultList();
        // 用一个持久度额 Entity 添加
        Student lalala = new Student("lalala", LocalDate.of(2001, 1, 1), Gender.MALE);
        Student mergedLalala = session.merge(lalala);
        // 合并后的 entity 与原始 entity 不是同一个对象，但内容一致
        Assertions.assertNotSame(mergedLalala, lalala);
        Assertions.assertEquals(mergedLalala, lalala);
        transaction.commit();
        session.close();
        List<Object> dirtyEntities = DirtyDataRecorderInterceptor.getDirtyEntities();
        Assertions.assertEquals(0, dirtyEntities.size());
        // 检查是否插入数据库
        var modifiedStudents = studentRepository.findAll();
        var student = modifiedStudents.stream().filter(s -> s.getName().equals(mergedLalala.getName())).findFirst().get();
        Assertions.assertEquals(mergedLalala, student);
        assertStudentsCount(students.size() + 1);
    }
}

package com.example.lombok;


import com.example.lombok.entity.*;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class LombokApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LombokApplication.class, args);
        testVar();
        testVal();
        testCleanUp();
//        testCleanUp2();
        testAccessor();
        testAccessor2();
        BookStore store = new BookStore();
//                .setId(1L)
//                .setName("三联书店")
//                .setAddress("南京市中山路11号");
//        System.out.printf("店名：%s，地址：%s%n", store.getName(), store.getAddress());
        BoolExample boolExample = new BoolExample();
        testToString();
        testEquals();
        testEquals2();
        testData();
        testData2();
        testValue();
        testBuilder();
        callTestThrow();
//        testSyncronize();
        testWith();
        LazyExample lazyExample = new LazyExample();
        System.out.println(lazyExample.getBigFibnacci());
    }

    private static void testWith() {
        Dog dog = new Dog("audi",11);
        Dog dog2 = dog.withAge(2);
//        Dog dog2 = new Dog(dog.getName(), 2);
        System.out.println(dog);
        System.out.println(dog2);
    }

    private static void testSyncronize() {
        var sd = new ShareData();
        new Thread(() -> sd.func1()).start();
        new Thread(() -> sd.func2()).start();
        new Thread(()-> ShareData.func3()).start();
    }

    private static void callTestThrow() {
        testThrow();
    }


    @SneakyThrows(IOException.class)
    private static void testThrow() {
        @Cleanup InputStream inputStream = new ClassPathResource("application.properties").getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

    private static void testBuilder() {
        var p = Person.builder().name("icexmoon")
                .city("NanJin")
                .job("Programmer")
                .hobbies(List.of("play games", "travel"))
                .hobbies(List.of("draw"))
                .hobby("music")
                .hobby("movie")
                .build();
        System.out.println(p);
    }

    private static void testValue() {
        BookCategory bc1 = new BookCategory(1L, "艺术", "艺术类书籍");
        System.out.println(bc1);
    }

    private static void testData2() {
        Student<String> s = Student.of(1L, "icexmoon", 20, "hello");
    }

    private static void testData() {
        Employee e = new Employee(1L, "icexmoon", false);
        System.out.println(e);
    }

    private static void testEquals2() {
        var p1 = new SpecialPublisher().admin("icexmoon")
                .name("海南出版社")
                .createDate(LocalDate.of(1991, 10, 1))
                .id(1L);
        var p2 = new SpecialPublisher().admin("icexmoon")
                .name("北京出版社")
                .createDate(LocalDate.of(2000, 10, 1))
                .id(1L);
        var p3 = new SpecialPublisher().admin("Li Lei")
                .name("江苏出版社")
                .createDate(LocalDate.of(2000, 10, 1))
                .id(1L);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }

    private static void testEquals() {
        Publisher p1 = new Publisher().id(1L)
                .createDate(LocalDate.of(1991, 10, 1))
                .name("海南出版社");
        Publisher p2 = new Publisher().id(1L)
                .createDate(LocalDate.of(1991, 10, 1))
                .name("海南出版社");
        Publisher p3 = new Publisher().id(1L)
                .createDate(LocalDate.of(2000, 10, 1))
                .name("海南出版社");
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }

    private static void testToString() {
        Publisher publisher = new SpecialPublisher()
                .admin("icexmoon")
                .name("海南出版社")
                .id(1L)
                .createDate(LocalDate.of(1991, 10, 1));
        System.out.println(publisher);
    }

    private static void testAccessor2() {
        Publisher publisher = new Publisher()
                .id(1L)
                .name("海南出版社")
                .createDate(LocalDate.of(1991, 10, 1));
        System.out.println(publisher.name());
        System.out.println(publisher);
    }

    private static void testAccessor() {
        User user = new User()
//                .setId(1L)
                .setDelFlag(false)
                .setIsAdmin(true)
                .setName("icexmoon");
        System.out.println(user.getName());
    }

    private static void testCleanUp() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application.properties");
        @Cleanup InputStream inputStream = classPathResource.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        do {
            var line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        while (true);
    }

    private static void testCleanUp2() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application.properties");
        InputStream inputStream = classPathResource.getInputStream();
        @Cleanup("destroy") MyBufferedReader bufferedReader = new MyBufferedReader(new InputStreamReader(inputStream));
        do {
            var line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        while (true);
    }

    private static void testVal() {
        val names = new ArrayList<String>();
        names.add("Li Lei");
        System.out.println(names.get(0));
        val students = new HashMap<Integer, String>();
        students.put(12, "Li Lei");
        students.put(20, "Han Meimei");
        for (var s : students.entrySet()) {
            System.out.println("number is %d, name is %s.".formatted(s.getKey(), s.getValue()));
        }
    }

    private static void testVar() {
        var names = new ArrayList<String>();
        names.add("Li Lei");
        System.out.println(names.get(0));
        var students = new HashMap<Integer, String>();
        students.put(12, "Li Lei");
        students.put(20, "Han Meimei");
        for (var s : students.entrySet()) {
            System.out.println("number is %d, name is %s.".formatted(s.getKey(), s.getValue()));
        }
        students = new HashMap<>();
    }

}

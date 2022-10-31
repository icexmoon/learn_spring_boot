package cn.icexmoon.books2.system.typehandler;

import cn.icexmoon.books2.system.IDesc;
import cn.icexmoon.books2.system.util.MyEnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system
 * @ClassName : .java
 * @createTime : 2022/10/27 10:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@MappedTypes(IDesc.class)
public class IDescEnumTypeHandler<E extends Enum<E> & IDesc<Integer>> extends BaseTypeHandler<E> {
    private Class<E> type;

    public IDescEnumTypeHandler(Class<E> type) {
        this.type = type;
    }


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setInt(i, parameter.getValue());
        } else {
            ps.setObject(i, parameter.getValue(), jdbcType.TYPE_CODE);
        }

    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        return MyEnumUtil.getIEnumInstance(type, i);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        return MyEnumUtil.getIEnumInstance(type, i);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        return MyEnumUtil.getIEnumInstance(type, i);
    }
}

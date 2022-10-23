package cn.icexmoon.books2.book.entity.typehandler;

import cn.icexmoon.books2.book.entity.enums.CouponType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

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
 * @Package : cn.icexmoon.books2.book.entity.typehandler
 * @ClassName : .java
 * @createTime : 2022/10/23 14:11
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class CouponTypeHandler extends BaseTypeHandler<CouponType> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CouponType couponType, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setInt(i, couponType.getValue());
        } else {
            ps.setObject(i, couponType.getValue(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public CouponType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return CouponType.match(value);
    }

    @Override
    public CouponType getNullableResult(ResultSet rs, int i) throws SQLException {
        int value = rs.getInt(i);
        return CouponType.match(value);
    }

    @Override
    public CouponType getNullableResult(CallableStatement cs, int i) throws SQLException {
        int value = cs.getInt(i);
        return CouponType.match(value);
    }
}

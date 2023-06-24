package com.example.cache;

import lombok.SneakyThrows;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : cache
 * @Package : com.example.cache
 * @ClassName : .java
 * @createTime : 2023/6/24 8:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MethodKey implements Serializable {
    private final Object[] params;
    private final Method method;
    // Effectively final, just re-calculated on deserialization
    private transient int hashCode;
    public static final MethodKey EMPTY = new MethodKey();


    public MethodKey(Method method, Object... params) {
        Assert.notNull(params, "params should be not null.");
        this.params = params.clone();
        this.method = method;
        this.hashCode = this.doHashCode();
    }

    @SneakyThrows
    public MethodKey() {
        this.params = new Object[0];
        this.method = this.getClass().getDeclaredMethod("hashCode");
        this.hashCode = this.doHashCode();
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MethodKey)) {
            return false;
        } else {
            MethodKey other = (MethodKey)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!Arrays.deepEquals(this.params, other.params)) {
                return false;
            } else {
                Object this$method = this.method;
                Object other$method = other.method;
                if (this$method == null) {
                    if (other$method != null) {
                        return false;
                    }
                } else if (!this$method.equals(other$method)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MethodKey;
    }

    private int doHashCode() {
        int result = 1;
        result = result * 59 + Arrays.deepHashCode(this.params);
        Object $method = this.method;
        result = result * 59 + ($method == null ? 43 : $method.hashCode());
        return result;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // Re-calculate hashCode field on deserialization
        this.hashCode = this.doHashCode();
    }
}

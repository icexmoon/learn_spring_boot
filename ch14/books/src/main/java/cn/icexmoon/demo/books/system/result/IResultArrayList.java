package cn.icexmoon.demo.books.system.result;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IResultArrayList<T> extends ArrayList<T> implements IResult {
    public <E> IResultArrayList() {
        super();
    }

    public <E> IResultArrayList(List<E> items, Function<E, T> mapFunc) {
        this();
        for (E item : items) {
            add(mapFunc.apply(item));
        }
    }
}

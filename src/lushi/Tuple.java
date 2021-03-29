package lushi;

import java.util.AbstractList;

/**
 * @author: create by hsw
 * @description: lushi
 * @date:2021/3/29
 **/
public final class Tuple<T0, T1> extends AbstractList<Object> {

    public T0 _0;
    public T1 _1;

    public Tuple(T0 _0, T1 _1) {
        this._0 = _0;
        this._1 = _1;
    }

    public T0 get_0() {
        return _0;
    }

    public void set_0(T0 val) {
        _0 = val;
    }

    public T1 get_1() {
        return _1;
    }

    public void set_1(T1 val) {
        _1 = val;
    }

    @Override
    public Object get(int index) {
        switch (index) {
            case 0:
                return _0;
            case 1:
                return _1;
            default:
                throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    @Override
    public int size() {
        return 2;
    }

}

package ru.korgov.util.func;

import ru.korgov.util.alias.Cf;

import java.util.List;

/**
 * Author: Kirill Korgov (kirill@korgov.ru)
 * Date: 01.12.12
 */
public abstract class Function<F, T> {
    public abstract T apply(final F v);

    public <N> Function<F, N> then(final Function<T, N> nextFu) {
        return new Function<F, N>() {
            @Override
            public N apply(final F v) {
                return nextFu.apply(Function.this.apply(v));
            }
        };
    }

    public List<T> map(final Iterable<? extends F> src) {
        final List<T> out = Cf.newList();
        for (final F v : src) {
            out.add(apply(v));
        }
        return out;
    }
}

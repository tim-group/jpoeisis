package com.timgroup.jpoeisis.reflection;

import com.timgroup.jpoeisis.reference.Lens;

public interface Accessor<C, V> extends Lens<C, V>, TypeBearer<V> {
    String propertyName();
    boolean isMutable();
}

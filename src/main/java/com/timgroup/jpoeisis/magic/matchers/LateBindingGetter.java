package com.timgroup.jpoeisis.magic.matchers;

import com.timgroup.jpoeisis.reference.Getter;
import com.timgroup.jpoeisis.reflection.ReflectiveAccessorFactory;

final class LateBindingGetter<T, V> implements Getter<T, V> {
    
    public static <T, V> LateBindingGetter<T, V> forPropertyNamed(String propertyName) {
        return new LateBindingGetter<T, V>(propertyName);
    }

    private final String propertyName;
    
    private LateBindingGetter(String propertyName) {
        this.propertyName = propertyName;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public V get(T instance) {
        ReflectiveAccessorFactory factory = ReflectiveAccessorFactory.forClass(instance.getClass());
        final Getter<Object, Object> getter = factory.getGetter(propertyName);
        return (V) getter.get(instance);
    }
}
package com.timgroup.jpoeisis.reflection;

import com.google.common.base.Preconditions;
import com.timgroup.jpoeisis.reference.Getter;
import com.timgroup.jpoeisis.reference.Lens;
import com.timgroup.jpoeisis.reference.Setter;

public class ReflectiveAccessorFactory<O> {
    
    private final AccessorCatalogue<O> catalogue;
    
    public static <O> ReflectiveAccessorFactory<O> forClass(Class<O> targetClass) {
        return new ReflectiveAccessorFactory<O>(targetClass);
    }
    
    private ReflectiveAccessorFactory(Class<O> targetClass) {
        catalogue = AccessorCatalogue.forClass(targetClass);
    }
    
    public <T> Lens<O, T> getLens(final String propertyName) {
        Lens<O, T> lens = catalogue.getAttribute(propertyName);
        Preconditions.checkNotNull(lens, "No writable property or field \"%s\"", propertyName);
        return lens;
    }
    
    public <T> Getter<O, T> getGetter(String propertyName) {
        Getter<O, T> getter = catalogue.getReadOnlyAttribute(propertyName);
        Preconditions.checkNotNull(getter, "No readable property or field \"%s\"", propertyName);
        return getter;
    }
    
    @SuppressWarnings("unchecked")
    public <T> Setter<O, T> getSetter(String propertyName) {
        Lens<O, T> lens = (Lens<O, T>) catalogue.allAttributes().get(propertyName);
        Preconditions.checkNotNull(lens, "No writable property or field \"%s\"", propertyName);
        return lens;
    }
}
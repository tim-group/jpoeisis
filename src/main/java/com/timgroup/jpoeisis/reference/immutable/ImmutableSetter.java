package com.timgroup.jpoeisis.reference.immutable;

public interface ImmutableSetter<O, T> {

    O set(O object, T newValue);
    
}

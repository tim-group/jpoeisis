package com.timgroup.jpoeisis.reference.immutable;

public interface ImmutableSettable<O, T> {

    O set(T newValue);
    
}

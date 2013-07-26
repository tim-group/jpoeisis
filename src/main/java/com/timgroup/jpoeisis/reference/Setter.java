package com.timgroup.jpoeisis.reference;

public interface Setter<O, T> {
    T set(O object, T newValue);
}

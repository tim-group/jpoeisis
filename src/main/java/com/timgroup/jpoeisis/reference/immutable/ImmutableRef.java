package com.timgroup.jpoeisis.reference.immutable;

import com.timgroup.jpoeisis.reference.Gettable;
import com.google.common.base.Function;

public interface ImmutableRef<O, T> extends Gettable<T>, ImmutableSettable<O, T> {
    
    O update(Function<T, T> updater);
    
}

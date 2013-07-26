package com.timgroup.jpoeisis.recording;

import com.google.common.base.Function;
import com.timgroup.jpoeisis.reflection.MethodCall;

public final class InterpretingFinalCallHandler<T> implements FinalCallHandler<T> {
    
    private final Function<Iterable<MethodCall>, T> interpreter;
    
    public InterpretingFinalCallHandler(Function<Iterable<MethodCall>, T> interpreter) {
        this.interpreter = interpreter;
    }

    @Override public T handle(MethodCall closingCall, Iterable<MethodCall> callHistory) {
        return interpreter.apply(callHistory);
    }
}
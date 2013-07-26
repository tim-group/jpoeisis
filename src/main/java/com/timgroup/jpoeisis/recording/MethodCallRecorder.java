package com.timgroup.jpoeisis.recording;

import com.google.common.collect.ImmutableList;
import com.timgroup.jpoeisis.reflection.MethodCall;

public final class MethodCallRecorder {
    
    private final ImmutableList.Builder<MethodCall> builder = ImmutableList.builder();
    
    public void record(MethodCall methodCall) {
        builder.add(methodCall);
    }
    
    public Iterable<MethodCall> callHistory() {
        return builder.build();
    }
}
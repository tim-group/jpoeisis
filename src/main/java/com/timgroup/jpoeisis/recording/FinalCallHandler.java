package com.timgroup.jpoeisis.recording;

import com.timgroup.jpoeisis.reflection.MethodCall;

public interface FinalCallHandler<T> {
    T handle(MethodCall closingCall, Iterable<MethodCall> callHistory);
}
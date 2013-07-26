package com.timgroup.jpoeisis.proxying;

import com.timgroup.jpoeisis.reflection.MethodCall;

public interface MethodCallHandler {
    Object handle(MethodCall methodCall);
}
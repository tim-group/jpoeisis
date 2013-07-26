package com.timgroup.jpoeisis.interpreters;

import com.google.common.base.Function;
import com.timgroup.jpoeisis.reflection.MethodCall;

public interface MethodCallInterpreter<T> extends Function<MethodCall, T> { }

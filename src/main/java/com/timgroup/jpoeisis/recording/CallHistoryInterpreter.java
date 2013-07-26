package com.timgroup.jpoeisis.recording;

import com.google.common.base.Function;
import com.timgroup.jpoeisis.reflection.MethodCall;

public interface CallHistoryInterpreter<T> extends Function<Iterable<MethodCall>, T> { }
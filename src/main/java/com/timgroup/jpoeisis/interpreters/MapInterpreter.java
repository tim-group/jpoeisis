package com.timgroup.jpoeisis.interpreters;

import java.util.Map;

import com.google.common.base.Function;

public interface MapInterpreter<K, V, T> extends Function<Map<K, V>, T> { }

package com.timgroup.jpoeisis.magic.matchers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hamcrest.Matcher;

import com.google.common.base.Function;
import com.timgroup.jpoeisis.reflection.MethodCall;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MatchesWith {
    Class<? extends Function<MethodCall, Matcher<?>>> value();
}

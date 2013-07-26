package com.timgroup.jpoeisis.magic.matchers;

import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;

import com.google.common.base.Predicate;
import com.timgroup.jpoeisis.recording.FinalCallHandler;
import com.timgroup.jpoeisis.recording.InterceptingMethodCallRecorder;
import com.timgroup.jpoeisis.reflection.MethodCall;

public final class MagicJavaBeanMatcher<T, I> implements Predicate<MethodCall>, FinalCallHandler<Object> {
    private final Class<T> targetClass;

    public static class MagicJavaBeanMatcherBuilder<T> {
        private Class<T> targetClass;
        private MagicJavaBeanMatcherBuilder(Class<T> targetClass) {
            this.targetClass = targetClass;
        }
        public <I> I using(Class<I> interfaceClass) {
            MagicJavaBeanMatcher<T, I> matcher = new MagicJavaBeanMatcher<T, I>(targetClass);
            return InterceptingMethodCallRecorder.proxying(interfaceClass, matcher, matcher);
        }
    }
    
    public static <T> MagicJavaBeanMatcher.MagicJavaBeanMatcherBuilder<T> matching(Class<T> targetClass) {
        return new MagicJavaBeanMatcher.MagicJavaBeanMatcherBuilder<T>(targetClass);
    }
    
    private MagicJavaBeanMatcher(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public Object handle(MethodCall closingCall,
                          Iterable<MethodCall> callHistory) {
        try {
            return closingCall.applyTo(makeMatcherFrom(callHistory));
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean apply(MethodCall methodCall) {
        return methodCall.targetClass().equals(Matcher.class) || methodCall.targetClass().equals(SelfDescribing.class);
    }
    
    private Matcher<T> makeMatcherFrom(Iterable<MethodCall> callHistory) {
        return new InstanceWithPropertiesMatcher<T>(targetClass, JavaBeanPropertyMatcherMaker.interpret(targetClass, callHistory));
    }
}
package com.timgroup.jpoeisis.multipledispatch;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.timgroup.jpoeisis.functions.KeywordFunction;
import com.timgroup.jpoeisis.keywords.KeywordArguments;

public class CandidateFunction<T> implements KeywordFunction<T> {

    private final Predicate<KeywordArguments> predicate;
    private final Function<KeywordArguments, T> function;
    
    public CandidateFunction(Predicate<KeywordArguments> predicate, Function<KeywordArguments, T> function) {
        this.predicate = predicate;
        this.function = function;
    }
    
    public boolean matches(KeywordArguments arguments) {
        return predicate.apply(arguments);
    }
    
    @Override
    public T apply(KeywordArguments arguments) {
        return function.apply(arguments);
    }
}

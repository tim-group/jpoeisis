package com.timgroup.jpoeisis.functions;

import com.google.common.base.Function;
import com.timgroup.jpoeisis.keywords.KeywordArgument;
import com.timgroup.jpoeisis.keywords.KeywordArguments;

public class Curry<T> {

    private final Function<KeywordArguments, T> function;

    public static <T> Curry<T> theFunction(Function<KeywordArguments, T> function) {
        return new Curry<T>(function);
    }
    
    private Curry(Function<KeywordArguments, T> function) {
        this.function = function;
    }
    
    public KeywordFunction<T> with(KeywordArgument...arguments) {
        return with(KeywordArguments.of(arguments));
    }
    
    public KeywordFunction<T> with(final KeywordArguments curriedArguments) {
        return new KeywordFunction<T>() {
            @Override public T apply(KeywordArguments remainingArguments) {
                return function.apply(curriedArguments.with(remainingArguments));
            }
        };
    }
}

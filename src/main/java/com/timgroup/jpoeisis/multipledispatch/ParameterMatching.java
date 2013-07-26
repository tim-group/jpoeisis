package com.timgroup.jpoeisis.multipledispatch;

import com.timgroup.jpoeisis.functions.KeywordFunction;
import com.timgroup.jpoeisis.functions.VarArgFunction;
import com.timgroup.jpoeisis.keywords.KeywordArgument;
import com.timgroup.jpoeisis.keywords.KeywordArguments;

public class ParameterMatching<T> implements KeywordFunction<T>, VarArgFunction<T> {

    private final CandidateFunctionRegistry<T> candidateRegistry = new CandidateFunctionRegistry<T>();
    
    public static <T> ParameterMatching<T> function(FunctionBundle<T> bundle) {
        return new ParameterMatching<T>(bundle);
    }
    
    private ParameterMatching(FunctionBundle<T> bundle) {
        bundle.register(candidateRegistry);
    }
    
    @Override
    public T apply(KeywordArguments parameters) {
        return candidateRegistry.findCandidateMatching(parameters).apply(parameters);
    }
    
    @Override
    public T apply(KeywordArgument...parameters) {
        return apply(KeywordArguments.of(parameters));
    }

}

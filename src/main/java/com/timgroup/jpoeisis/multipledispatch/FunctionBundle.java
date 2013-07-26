package com.timgroup.jpoeisis.multipledispatch;


public interface FunctionBundle<T> {

    void register(CandidateFunctionRegistry<T> registry);
    
}

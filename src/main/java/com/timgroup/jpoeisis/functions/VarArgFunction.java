package com.timgroup.jpoeisis.functions;

import com.timgroup.jpoeisis.keywords.KeywordArgument;


public interface VarArgFunction<T> {
    
    T apply(KeywordArgument...parameters);
    
}

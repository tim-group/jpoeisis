package com.timgroup.jpoeisis.keywords;

public interface Keyword<T> extends KeywordArgumentsLens<T> {

    KeywordArguments metadata();
    KeywordArgument of(T value);
    T from(KeywordArguments keywordArguments);
    T from(KeywordArguments keywordArguments, T defaultValue);
    
}

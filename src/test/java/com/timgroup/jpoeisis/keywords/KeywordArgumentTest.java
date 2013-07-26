package com.timgroup.jpoeisis.keywords;

import org.junit.Test;

import com.timgroup.jpoeisis.keywords.Keyword;
import com.timgroup.jpoeisis.keywords.KeywordArgument;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class KeywordArgumentTest {

    @SuppressWarnings("unchecked")
    @Test public void
    bindsAKeywordToAValue() {
        Keyword<String> name = Keywords.newKeyword();
        KeywordArgument bound = KeywordArgument.value(name, "Hello");
        assertThat((Keyword<String>) bound.keyword(), is(name));
        assertThat((String) bound.value(), is("Hello"));
    }
    
}

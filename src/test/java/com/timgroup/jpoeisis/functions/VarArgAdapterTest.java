package com.timgroup.jpoeisis.functions;

import org.junit.Test;

import com.google.common.base.Function;
import com.timgroup.jpoeisis.keywords.Keyword;
import com.timgroup.jpoeisis.keywords.KeywordArguments;
import com.timgroup.jpoeisis.keywords.Keywords;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class VarArgAdapterTest {
    
    @Test public void
    adapts_a_parameter_set_function_to_a_var_arg_function() {
        final Keyword<String> name = Keywords.newKeyword();
        
        Function<KeywordArguments, String> unadapted = new Function<KeywordArguments, String>() {
            @Override public String apply(KeywordArguments input) {
                return String.format("Hello, %s", name.from(input));
            }
        };
        
        VarArgFunction<String> adapted = VarArgAdapter.adapt(unadapted);
        
        assertThat(adapted.apply(name.of("Dominic")), is("Hello, Dominic"));
    }
    

}

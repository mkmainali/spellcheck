package com.github.mkmainali.filter.impl;

import com.github.mkmainali.filters.impl.LowercaseFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LowercaseFilterTest {

    private final LowercaseFilter filter = new LowercaseFilter();

    @Test
    public void testLowerCaseFilter() throws Exception {
        Assert.assertNull(filter.apply(null));

        List<String> tokens = Collections.singletonList("TEST");
        List<String> result = filter.apply(tokens);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("test", result.get(0));

        tokens = Arrays.asList("TEST", "TEST1");
        result = filter.apply(tokens);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("test", result.get(0));
        Assert.assertEquals("test1", result.get(1));
    }
}

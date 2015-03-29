package com.github.mkmainali.filter.impl;

import com.github.mkmainali.filters.impl.SingleCharacterFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleCharacterFilterTest {

    private final SingleCharacterFilter filter = new SingleCharacterFilter();

    @Test
    public void testSingleCharacterFilter() throws Exception {
        Assert.assertNull(filter.apply(null));

        List<String> tokens = Collections.singletonList("s");
        List<String> result = filter.apply(tokens);

        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());

        tokens = Arrays.asList("s", "test");
        result = filter.apply(tokens);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }
}

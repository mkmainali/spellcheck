package com.github.mkmainali;

import com.github.mkmainali.reader.Reader;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class SpellCheckTest {

    @Test
    public void testSpellcheck() throws Exception {
        SpellCheck checker = new SpellCheckBuilder().withReader(new Reader() {
            @Override
            public Iterator<String> getTrainingData() throws SpellcheckException {
                return Arrays.asList("correction", "spelling", "coding").iterator();
            }
        }).build();

        String result = checker.correct("corection");
        Assert.assertNotNull(result);
        Assert.assertEquals("correction", result);

        result = checker.correct("speing");
        Assert.assertNotNull(result);
        Assert.assertEquals("spelling", result);
    }
}

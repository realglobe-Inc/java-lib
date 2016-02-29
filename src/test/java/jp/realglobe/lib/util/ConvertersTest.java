package jp.realglobe.lib.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * Converters のテスト。
 */
public class ConvertersTest {

    /**
     * 空の変換。
     */
    @Test
    public void testConvertEmpty() {
        final Collection<String> befores = Collections.emptyList();
        Assert.assertEquals(Collections.EMPTY_LIST, Converters.convert(befores, str -> str.toLowerCase()));
    }

    /**
     * 変換する。
     */
    @Test
    public void testConvert() {
        final Collection<String> befores = Arrays.asList("A", "B");
        Assert.assertEquals(Arrays.asList("a", "b"), Converters.convert(befores, str -> str.toLowerCase()));
    }

    /**
     * 空の変換。
     */
    @Test
    public void testNullOrConvertEmpty() {
        final Collection<String> befores = Collections.emptyList();
        Assert.assertNull(Converters.nullOrConvert(befores, str -> str.toLowerCase()));
    }

    /**
     * 変換する。
     */
    @Test
    public void testNullOrConvert() {
        final Collection<String> befores = Arrays.asList("A", "B");
        Assert.assertEquals(Arrays.asList("a", "b"), Converters.nullOrConvert(befores, str -> str.toLowerCase()));
    }

}

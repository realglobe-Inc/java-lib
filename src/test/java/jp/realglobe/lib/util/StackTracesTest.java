package jp.realglobe.lib.util;

import jp.realglobe.lib.util.StackTraces;

import org.junit.Assert;
import org.junit.Test;

/**
 * StackTraces のテスト。
 */
public class StackTracesTest {

    /**
     * ちゃんと動くこと。
     */
    @Test
    public void testGetString() {
        Assert.assertTrue(StackTraces.getString(new Exception()).length() > 0);
    }

}

package jp.realglobe.lib.container;

import jp.realglobe.lib.container.Pair;

import org.junit.Assert;
import org.junit.Test;

/**
 * Pair のテスト。
 */
public class PairTest {

    /**
     * 1 つ目を取得する。
     */
    @Test
    public void testGetFirst() {
        Assert.assertEquals("A", (new Pair<>("A", "B")).getFirst());
    }

    /**
     * 2 つ目を取得する。
     */
    @Test
    public void testGetSecond() {
        Assert.assertEquals("B", (new Pair<>("A", "B")).getSecond());
    }

}

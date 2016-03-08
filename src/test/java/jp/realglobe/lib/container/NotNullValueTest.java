package jp.realglobe.lib.container;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * NotNullValue のテスト。
 */
public class NotNullValueTest {

    /**
     * 初期化間違い。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInitWithNull() {
        Assert.assertNotNull(new NotNullValue<>(null));
    }

    /**
     * 値を取得する。
     */
    @Test
    public void testGet() {
        Assert.assertEquals("A", (new NotNullValue<>("A")).get());
    }

    /**
     * ハッシュ値が計算できること。
     */
    @Test
    public void testHashCode() {
        final Set<NotNullValue<?>> set = new HashSet<>();
        final NotNullValue<?> pair = new NotNullValue<>("A");
        set.add(pair);
        Assert.assertTrue(set.contains(pair));
    }

    /**
     * 自分自身と等しいこと。
     */
    @Test
    public void testEqualsSelf() {
        final NotNullValue<?> pair = new NotNullValue<>("A");
        Assert.assertEquals(pair, pair);
    }

    /**
     * 同じ値と等しいこと。
     */
    @Test
    public void testEquals() {
        Assert.assertEquals(new NotNullValue<>("A"), new NotNullValue<>("A"));
    }

    /**
     * null と等しくないこと。
     */
    @Test
    public void testNotEqualsNotNullNotNullValue() {
        Assert.assertNotEquals(new NotNullValue<>("A"), null);
    }

    /**
     * NotNullValue 以外とは等しくないこと。
     */
    @Test
    public void testNotEqualsNotNotNullValue() {
        Assert.assertNotEquals(new NotNullValue<>("A"), "A");
    }

}

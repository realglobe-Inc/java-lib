package jp.realglobe.lib.container;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Value のテスト。
 */
public class ValueTest {

    /**
     * 値を取得する。
     */
    @Test
    public void testGet() {
        Assert.assertEquals("A", (new Value<>("A")).get());
    }

    /**
     * ハッシュ値が計算できること。
     */
    @Test
    public void testHashCode() {
        final Set<Value<?>> set = new HashSet<>();
        final Value<?> pair = new Value<>("A");
        set.add(pair);
        Assert.assertTrue(set.contains(pair));
    }

    /**
     * ハッシュ値が計算できること。
     */
    @Test
    public void testHashCodeWithNull() {
        final Set<Value<?>> set = new HashSet<>();
        final Value<?> pair = new Value<>(null);
        set.add(pair);
        Assert.assertTrue(set.contains(pair));
    }

    /**
     * 自分自身と等しいこと。
     */
    @Test
    public void testEqualsSelf() {
        final Value<?> pair = new Value<>("A");
        Assert.assertEquals(pair, pair);
    }

    /**
     * 同じ値と等しいこと。
     */
    @Test
    public void testEquals() {
        Assert.assertEquals(new Value<>("A"), new Value<>("A"));
    }

    /**
     * null と等しくないこと。
     */
    @Test
    public void testNotEqualsNull() {
        Assert.assertNotEquals(new Value<>("A"), null);
    }

    /**
     * null と等しくないこと。
     */
    @Test
    public void testNotEqualsNullValue() {
        Assert.assertNotEquals(new Value<>("A"), new Value<>(null));
    }

    /**
     * null でないのと等しくないこと。
     */
    @Test
    public void testNotEqualsNotNullValue() {
        Assert.assertNotEquals(new Value<>(null), new Value<>("A"));
    }

    /**
     * null と等しいこと。
     */
    @Test
    public void testEqualsNullValue() {
        Assert.assertEquals(new Value<>(null), new Value<>(null));
    }

    /**
     * Value 以外とは等しくないこと。
     */
    @Test
    public void testNotEqualsNotValue() {
        Assert.assertNotEquals(new Value<>("A"), "A");
    }

}

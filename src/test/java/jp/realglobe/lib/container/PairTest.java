/*----------------------------------------------------------------------
 * Copyright 2017 realglobe Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *----------------------------------------------------------------------*/

package jp.realglobe.lib.container;

import java.util.HashSet;
import java.util.Set;

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
        Assert.assertEquals("A", (new Pair<>("A", 1)).getFirst());
    }

    /**
     * 2 つ目を取得する。
     */
    @Test
    public void testGetSecond() {
        Assert.assertEquals((Integer) 1, (new Pair<>("A", 1)).getSecond());
    }

    /**
     * ハッシュ値が計算できること。
     */
    @Test
    public void testHashCode() {
        final Set<Pair<?, ?>> set = new HashSet<>();
        final Pair<?, ?> pair = new Pair<>("A", 1);
        set.add(pair);
        Assert.assertTrue(set.contains(pair));
    }

    /**
     * ハッシュ値が計算できること。
     */
    @Test
    public void testHashCodeWithNullFirst() {
        final Set<Pair<?, ?>> set = new HashSet<>();
        final Pair<?, ?> pair = new Pair<>(null, 1);
        set.add(pair);
        Assert.assertTrue(set.contains(pair));
    }

    /**
     * ハッシュ値が計算できること。
     */
    @Test
    public void testHashCodeWithNullSecond() {
        final Set<Pair<?, ?>> set = new HashSet<>();
        final Pair<?, ?> pair = new Pair<>("A", null);
        set.add(pair);
        Assert.assertTrue(set.contains(pair));
    }

    /**
     * 自分自身と等しいこと。
     */
    @Test
    public void testEqualsSelf() {
        final Pair<?, ?> pair = new Pair<>("A", 1);
        Assert.assertEquals(pair, pair);
    }

    /**
     * 同じ値と等しいこと。
     */
    @Test
    public void testEquals() {
        Assert.assertEquals(new Pair<>("A", 1), new Pair<>("A", 1));
    }

    /**
     * null と等しくないこと。
     */
    @Test
    public void testNotEqualsNull() {
        Assert.assertNotEquals(new Pair<>("A", 1), null);
    }

    /**
     * null と等しくないこと。
     */
    @Test
    public void testNotEqualsNullFirst() {
        Assert.assertNotEquals(new Pair<>("A", 1), new Pair<>(null, 1));
    }

    /**
     * null と等しくないこと。
     */
    @Test
    public void testNotEqualsNullSecond() {
        Assert.assertNotEquals(new Pair<>("A", 1), new Pair<>("A", null));
    }

    /**
     * null でないのと等しくないこと。
     */
    @Test
    public void testNotEqualsNotNullFirst() {
        Assert.assertNotEquals(new Pair<>(null, 1), new Pair<>("A", 1));
    }

    /**
     * null でないのと等しくないこと。
     */
    @Test
    public void testNotEqualsNotNullSecond() {
        Assert.assertNotEquals(new Pair<>("A", null), new Pair<>("A", 1));
    }

    /**
     * null と等しいこと。
     */
    @Test
    public void testEqualsNull() {
        Assert.assertEquals(new Pair<>(null, null), new Pair<>(null, null));
    }

    /**
     * Pair 以外とは等しくないこと。
     */
    @Test
    public void testNotEqualsNotPair() {
        Assert.assertNotEquals(new Pair<>("A", 1), "A");
    }

}

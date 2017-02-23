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

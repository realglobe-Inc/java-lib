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

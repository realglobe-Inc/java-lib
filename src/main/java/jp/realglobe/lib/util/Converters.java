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

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 変換関数。
 */
public final class Converters {

    private Converters() {}

    /**
     * リストに変換する。
     * @param <T> 変換前のクラス。
     * @param <R> 変換後のクラス。
     * @param befores 変換前。
     * @param converter 変換器。
     * @return 変換後。
     */
    public static <T, R> List<R> convert(final Collection<? extends T> befores, final Function<? super T, ? extends R> converter) {
        return befores.stream().map(converter).collect(Collectors.toList());
    }

    /**
     * リストに変換する。
     * 空なら null を返す。
     * @param <T> 変換前のクラス。
     * @param <R> 変換後のクラス。
     * @param befores 変換前。
     * @param converter 変換器。
     * @return 変換後。空なら null。
     */
    public static <T, R> List<R> nullOrConvert(final Collection<? extends T> befores, final Function<? super T, ? extends R> converter) {
        if (befores.isEmpty()) {
            return null;
        }
        return convert(befores, converter);
    }

}

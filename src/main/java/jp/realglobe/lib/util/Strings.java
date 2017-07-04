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

/**
 * 文字列周りの便利関数
 */
public final class Strings {

    private Strings() {}

    /**
     * @param s 調べる文字列
     * @return s が null か空文字列なら true
     */
    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.isEmpty();
    }

}

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

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * スタックトレース周りの便利関数。
 */
public final class StackTraces {

    private StackTraces() {}

    /**
     * エラーのスタックトレースを表示用文字列にする。
     * @param throwable エラー。
     * @return スタックトレースの文字列。
     */
    public static String getString(final Throwable throwable) {
        final StringWriter sink = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sink, true));
        return sink.toString();
    }

}

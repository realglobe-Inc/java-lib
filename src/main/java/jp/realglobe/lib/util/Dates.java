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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日時に関する便利関数。
 * Created by fukuchidaisuke on 17/03/30.
 */
public final class Dates {

    /**
     * @param date 日時
     * @return RFC3339 形式の日時表記
     */
    public static String getRfc3339(final Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ", Locale.US)).format(date);
    }

    /**
     * @param date 日時
     * @return yyyy-MM-dd 形式の日時表記
     */
    public static String getSimpleDayString(final Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(date);
    }

    /**
     * @param date 日時
     * @return HH:mm:ss 形式の日時表記
     */
    public static String getSimpleTimeString(final Date date) {
        return (new SimpleDateFormat("HH:mm:ss", Locale.US)).format(date);
    }

}

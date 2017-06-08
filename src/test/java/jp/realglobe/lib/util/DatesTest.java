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

import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Dates のテスト
 */
public class DatesTest {

    private int timeDiff;

    /**
     * 簡単な日付のテスト
     */
    @Before
    public void before() {
        final TimeZone hereTimeZone = TimeZone.getDefault();
        this.timeDiff = hereTimeZone.getRawOffset();
    }

    /**
     * RFC3339 表記のテスト
     */
    @Test
    public void testGetRfc3339() {
        final String sign = this.timeDiff >= 0 ? "+" : "-";
        final int hours = Math.abs(this.timeDiff) / 1_000 / 60 / 60;
        final int minutes = (Math.abs(this.timeDiff) / 1_000 / 60) % 60;
        final String timeDiffLabel = String.format("%s%02d%02d", sign, hours, minutes);

        Assert.assertEquals("1970-01-01T00:00:00.000" + timeDiffLabel, Dates.getRfc3339(new Date(-this.timeDiff)));
    }

    /**
     * 日付のテスト
     */
    @Test
    public void testGetSimpleTodayString() {
        Assert.assertNotEquals("1970-01-01", Dates.getSimpleDayString(new Date(-this.timeDiff - 1)));
        Assert.assertEquals("1970-01-01", Dates.getSimpleDayString(new Date(-this.timeDiff)));
        Assert.assertEquals("1970-01-01", Dates.getSimpleDayString(new Date(-this.timeDiff + 24 * 3600 * 1000L - 1)));
        Assert.assertNotEquals("1970-01-01", Dates.getSimpleDayString(new Date(-this.timeDiff + 24 * 3600 * 1000L)));
    }

}

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

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

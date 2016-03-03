package jp.realglobe.lib.container;

/**
 * 2 つの値。
 * @param <T1> 1 つ目のクラス。
 * @param <T2> 2 つ目のクラス。
 */
public class Pair<T1, T2> {

    private final T1 first;
    private final T2 second;

    /**
     * 作成。
     * @param first 1 つ目の値。
     * @param second 2 つ目の値。
     */
    public Pair(final T1 first, final T2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 1 つ目の値を返す。
     * @return 1 つ目の値。
     */
    public T1 getFirst() {
        return this.first;
    }

    /**
     * 2 つ目の値を返す。
     * @return 2 つ目の値。
     */
    public T2 getSecond() {
        return this.second;
    }

}

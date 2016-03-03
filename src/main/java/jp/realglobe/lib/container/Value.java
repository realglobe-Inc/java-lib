package jp.realglobe.lib.container;

/**
 * 1 つの値。
 * @param <T> 値のクラス。
 */
public class Value<T> {

    private final T value;

    /**
     * 作成。
     * @param value 値。
     */
    public Value(final T value) {
        this.value = value;
    }

    /**
     * 値を返す。
     * @return 値。
     */
    public T get() {
        return this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
        result = prime * result + getClass().getName().hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        final Value<?> other = (Value<?>) obj;
        if (this.value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!this.value.equals(other.value)) {
            return false;
        }
        return true;
    }

}

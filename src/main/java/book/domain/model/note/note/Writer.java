package book.domain.model.note.note;

/**
 * メモ書いた人
 */
public class Writer {
    private String value;

    public Writer(String value) {
        assert value.length() <= 100;
        this.value = value;
    }

    @Deprecated
    Writer() {
    }

    public static Writer empty() {
        return new Writer();
    }

    public String value() {
        return value;
    }
}


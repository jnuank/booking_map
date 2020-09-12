package book.domain.model.note.note.NoteNumber;

/**
 * 読書メモ番号
 */
public class NoteNumber {
    int value;

    public NoteNumber(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

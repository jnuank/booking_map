package book.domain.model.note.note;

/**
 * メモ
 */
public class Note {

    private String value;

    public Note(String value){
        assert value.length() <= 140;
        this.value = value;
    }
}
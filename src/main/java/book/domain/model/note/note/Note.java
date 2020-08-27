package book.domain.model.note.note;

import javax.validation.constraints.NotNull;

/**
 * メモ
 */
public class Note {

    @NotNull(message = "メモを入力してください。")
    private String value;

    public Note(String value){
        assert value.length() <= 140;
        this.value = value;
    }

    @Deprecated
    Note(){
    }

    public static Note empty() { return  new Note(); }

    public String value() {
        return value;
    }
}
package book.domain.model.book.book;

import javax.validation.constraints.NotNull;

/**
 * 本のタイトル
 */
public class BookTitle {
    @NotNull(message = "本のタイトルを入力してください。")
    private String value;

    public BookTitle(String value){
        this.value = value;
    }

    @Deprecated
    BookTitle(){

    }

    public String value() {
        return value;
    }

    public static BookTitle empty() { return  new BookTitle(); }



}


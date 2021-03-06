package book.domain.model.book.book;

import book.domain.model.link.link.LinkObject;

import javax.validation.constraints.NotNull;

/**
 * 本のタイトル
 */
public class BookTitle implements LinkObject {
    @NotNull(message = "本のタイトルを入力してください。")
    private String value;
    private String linkId;

    public BookTitle(String value) {
        this.value = value;
    }

    @Deprecated
    BookTitle() {

    }

    public String value() {
        return value;
    }

    public static BookTitle empty() {
        return new BookTitle();
    }


    @Override
    public String getLinkId() {
        return linkId;
    }
}


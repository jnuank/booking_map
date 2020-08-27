package book.domain.model.note.note;


import book.domain.model.book.book.BookTitle;

import javax.validation.Valid;

/**
 * 読書メモ依頼
 */
public class NoteRequest {
    @Valid
    Note note;

    @Valid
    BookTitle bookTitle;

    public NoteRequest(@Valid Note note, @Valid BookTitle bookTitle) {
        this.note = note;
        this.bookTitle = bookTitle;
    }

    @Deprecated
    NoteRequest() {
    }

    public Note note() {
        return note;
    }

    public BookTitle bookTitle() {
        return bookTitle;
    }

    public static NoteRequest empty() { return new NoteRequest(); }

    @Override
    public String toString(){
        return "NoteRequestForm{" +
                "bookTitle=" + bookTitle +
                ", note" + note +
                "}";
    }

}


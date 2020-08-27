package book.domain.model.note.note;

import book.domain.model.book.book.BookTitle;

/**
 * 読書メモ
 */
public class ReadingNote {
    private Note note;
    private BookTitle title;

    public ReadingNote(Note note, BookTitle title){
        this.note = note;
        this.title = title;
    }
}
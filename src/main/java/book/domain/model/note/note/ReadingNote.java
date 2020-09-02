package book.domain.model.note.note;

import book.domain.model.book.book.BookTitle;
import book.domain.model.note.note.NoteNumber.NoteNumber;

/**
 * 読書メモ
 */
public class ReadingNote {
    private NoteNumber noteNumber;
    private Note note;
    private BookTitle title;

    public ReadingNote(Note note, BookTitle title){
        this.note = note;
        this.title = title;
    }
}
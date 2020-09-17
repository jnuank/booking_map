package book.domain.model.note.note;

import book.domain.model.book.book.BookTitle;
import book.domain.model.link.link.LinkObject;
import book.domain.model.note.note.NoteNumber.NoteNumber;

import java.util.List;

/**
 * 読書メモ
 */
public class ReadingNote {
    private NoteNumber noteNumber;
    private Note note;
    private BookTitle title;
    private Writer writer;
    private NoteCategory category;
    private List<LinkObject> links;

    public ReadingNote(Note note, BookTitle title, Writer writer, NoteCategory category) {
        this.note = note;
        this.title = title;
        this.writer = writer;
        this.category = category;
    }

    public ReadingNote addLink(LinkObject linkObject) {
        return null;
    }
}
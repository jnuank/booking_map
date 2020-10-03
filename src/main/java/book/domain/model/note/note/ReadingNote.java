package book.domain.model.note.note;

import book.domain.model.link.link.LinkObject;

/**
 * 読書メモ
 */
public class ReadingNote {
    //    private NoteNumber noteNumber;
//    private Note note;
//    private BookTitle title;
    private String note;
    private String title;
//    private Writer writer;
//    private NoteCategory category;
//    private List<LinkObject> links;
//
//    public ReadingNote(Note note, BookTitle title, Writer writer, NoteCategory category) {
//        this.note = note;
//        this.title = title;
//        this.writer = writer;
//        this.category = category;
//    }

    public ReadingNote(String note, String title) {
        this.note = note;
        this.title = title;
    }

    public ReadingNote addLink(LinkObject linkObject) {
        return null;
    }

    //    public NoteNumber noteNumber() { return noteNumber; }
    public String note() {
        return note;
    }

    public String bookTitle() {
        return title;
    }
//    public Writer writer() { return writer; }
//    public NoteCategory noteCategory() { return category; }

}
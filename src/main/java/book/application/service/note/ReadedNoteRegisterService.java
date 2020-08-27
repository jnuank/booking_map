package book.application.service.note;

import book.domain.model.book.book.BookTitle;
import book.domain.model.note.note.Note;
import book.domain.model.note.note.NoteRequest;
import book.domain.model.note.note.ReadingNote;
import org.springframework.stereotype.Service;

/**
 * 読書メモ記録サービス
 */
@Service
public class ReadedNoteRegisterService {
    // なにかレポジトリが必要

    /**
     * 読書メモを書く
     */
    public void wrote(NoteRequest noteRequest) {

        var readedNote = new ReadingNote(noteRequest.note(), noteRequest.bookTitle());


    }
}

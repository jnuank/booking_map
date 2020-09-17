package book.application.repository;

import book.domain.model.note.note.NoteRequest;
import book.domain.model.note.note.ReadingNote;

import java.util.List;

public interface NoteRepository {

    void wrote(NoteRequest noteRequest);

    List<ReadingNote> showAll();

}

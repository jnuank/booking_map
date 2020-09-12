package book.application.repository;

import book.domain.model.note.note.NoteRequest;

public interface NoteRepository {

    void wrote(NoteRequest noteRequest);

}

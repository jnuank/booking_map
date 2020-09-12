package book.application.service.note;

import book.application.repository.NoteRepository;
import book.domain.model.note.note.NoteRequest;
import org.springframework.stereotype.Service;

/**
 * 読書メモ記録サービス
 */
@Service
public class ReadedNoteRegisterService {
    NoteRepository repository;

    ReadedNoteRegisterService(NoteRepository repository) {
        this.repository = repository;
    }

    /**
     * 読書メモを書く
     */
    public void wrote(NoteRequest noteRequest) {
        this.repository.wrote(noteRequest);
    }
}

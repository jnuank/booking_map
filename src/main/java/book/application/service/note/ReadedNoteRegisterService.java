package book.application.service.note;

import book.application.repository.NoteRepository;
import book.domain.model.note.note.NoteRequest;
import book.domain.model.note.note.ReadingNote;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 読書メモを閲覧する
     */
    public List<ReadingNote> showAll() {
        return this.repository.showAll();
    }

}


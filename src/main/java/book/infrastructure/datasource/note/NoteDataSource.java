package book.infrastructure.datasource.note;

import book.application.repository.NoteRepository;
import book.domain.model.note.note.NoteNumber.NoteNumber;
import book.domain.model.note.note.NoteRequest;
import book.domain.model.note.note.ReadingNote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NoteDataSource implements NoteRepository {
    NoteMapper noteMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public NoteDataSource(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }


    @Override
    @Transactional
    public void wrote(NoteRequest noteRequest) {
        NoteNumber noteNumber = new NoteNumber(1);

        noteMapper.insertNote(noteNumber.value(), noteRequest.bookTitle(), noteRequest.note());
    }

    @Override
    public List<ReadingNote> showAll() {
        return noteMapper.selectAll();
    }


}

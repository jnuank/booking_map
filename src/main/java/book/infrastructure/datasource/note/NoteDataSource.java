package book.infrastructure.datasource.note;

import book.application.repository.NoteRepository;
import book.domain.model.note.note.NoteNumber.NoteNumber;
import book.domain.model.note.note.NoteRequest;
import book.domain.model.note.note.ReadingNote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

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
        Random rnd = new Random();
        NoteNumber noteNumber = new NoteNumber((int) (rnd.nextDouble() * 10000.0));

        noteMapper.insertNote(noteNumber.value(), noteRequest.bookTitle(), noteRequest.note());
    }

    @Override
    public List<ReadingNote> showAll() {
        return noteMapper.selectAll();
    }


}

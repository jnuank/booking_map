package book.infrastructure.datasource.note;

import book.domain.model.book.book.BookTitle;
import book.domain.model.note.note.Note;
import book.domain.model.note.note.NoteNumber.NoteNumber;
import book.domain.model.note.note.ReadingNote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoteMapper {
    int newNoteNumber();

    List<ReadingNote> selectByNoteNumber(@Param("noteNumber")NoteNumber noteNumber);

    void insertNote(
            @Param("noteNumber") int noteNumber,
            @Param("bookTitle")BookTitle bookTitle,
            @Param("note")Note note);

    List<ReadingNote> selectByNumber(@Param("noteNumber") NoteNumber noteNumber);

    List<ReadingNote> selectAll();
}

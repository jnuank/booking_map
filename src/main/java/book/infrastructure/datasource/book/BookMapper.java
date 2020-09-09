package book.infrastructure.datasource.book;

import book.domain.model.item.bibliography.Book;
import book.domain.model.item.bibliography.BookNumber;
import book.domain.model.item.bibliography.Keyword;
import book.domain.model.reservation.availability.BookAvailability;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookAvailability> searchBooks(
            @Param("keyword") Keyword keyword,
            @Param("limit") int limit
    );

    Book findBook(@Param("bookNumber") BookNumber bookNumber);
}

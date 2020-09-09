package book.application.repository;

import book.domain.model.item.bibliography.Book;
import book.domain.model.item.bibliography.BookNumber;
import book.domain.model.item.bibliography.Keyword;
import book.domain.model.reservation.availability.BookAvailabilities;

/**
 * 本リポジトリ
 */
public interface BookRepository {

    BookAvailabilities search(Keyword keyword);

    Book findBook(BookNumber bookNumber);
}

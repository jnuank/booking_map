package book.application.service.book;

import book.application.repository.BookRepository;
import book.domain.model.item.bibliography.Book;
import book.domain.model.item.bibliography.BookNumber;
import book.domain.model.item.bibliography.Keyword;
import book.domain.model.reservation.availability.BookAvailabilities;
import org.springframework.stereotype.Service;

/**
 * 本参照サービス
 */
@Service
public class BookQueryService {
    BookRepository bookRepository;

    BookQueryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 書籍番号で本を見つける
     */
    public Book findBook(BookNumber bookNumber) {
        return bookRepository.findBook(bookNumber);
    }

    /**
     * キーワードで本を探す
     */
    public BookAvailabilities search(Keyword keyword) {
        return bookRepository.search(keyword);
    }
}

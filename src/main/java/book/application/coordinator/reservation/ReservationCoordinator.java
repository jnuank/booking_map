package book.application.coordinator.reservation;

import book.application.service.book.BookQueryService;
import book.application.service.member.MemberQueryService;
import book.application.service.reservation.ReservationRecordService;
import book.domain.model.item.bibliography.Book;
import book.domain.model.item.bibliography.BookNumber;
import book.domain.model.item.bibliography.Keyword;
import book.domain.model.member.Member;
import book.domain.model.member.MemberNumber;
import book.domain.model.member.MemberStatus;
import book.domain.model.reservation.availability.BookAvailabilities;
import book.domain.model.reservation.request.Reservation;
import org.springframework.stereotype.Service;

/**
 * 予約コーディネータ
 */
@Service
public class ReservationCoordinator {
    ReservationRecordService reservationRecordService;
    MemberQueryService memberQueryService;
    BookQueryService bookQueryService;

    public ReservationCoordinator(ReservationRecordService reservationRecordService, MemberQueryService memberQueryService, BookQueryService bookQueryService) {
        this.reservationRecordService = reservationRecordService;
        this.memberQueryService = memberQueryService;
        this.bookQueryService = bookQueryService;
    }

    /**
     * 本を探す
     */
    public BookAvailabilities search(Keyword keyword) {
        return bookQueryService.search(keyword);
    }


    /**
     * 本を見つける
     */
    public Book findBook(BookNumber bookNumber) {
        return bookQueryService.findBook(bookNumber);
    }

    /**
     * 会員番号の有効性を確認する
     */
    public MemberStatus memberStatus(MemberNumber memberNumber) {
        return memberQueryService.status(memberNumber);
    }

    /**
     * 予約を記録する
     */
    public void reserve(Book book, MemberNumber memberNumber) {
        Member member = memberQueryService.findMember(memberNumber);
        Reservation reservation = Reservation.of(member, book);
        reservationRecordService.reserve(reservation);
    }
}

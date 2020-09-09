package book.domain.model.reservation.retention;

import book.domain.model.item.ItemNumber;
import book.domain.model.loan.loan.LoanDate;
import book.domain.model.loan.loan.LoanRequest;
import book.domain.model.member.MemberNumber;
import book.domain.model.reservation.request.Reservation;
import book.domain.model.reservation.request.ReservationNumber;

/**
 * 準備完了
 */
public class Retained {
    Reservation reservation;
    RetainedDate retainedDate;
    ItemNumber itemNumber;

    public boolean isExpired() {
        ExpireDate expireDate = ExpireDate.of(retainedDate);
        return expireDate.isExpired();
    }

    public ReservationNumber reservationNumber() {
        return reservation.number();
    }

    public String showExpireDate() {
        return ExpireDate.of(retainedDate).show();
    }

    public String showBook() {
        return reservation.showBook();
    }

    public ItemNumber itemNumber() {
        return itemNumber;
    }

    public MemberNumber memberNumber() {
        return reservation.memberNumber();
    }

    public LoanRequest toLoanRequest() {
        return new LoanRequest(reservation.memberNumber(), itemNumber, LoanDate.from(retainedDate.value));
    }

    @Override
    public String toString() {
        return "Retained{" +
                ", reservation=" + reservation +
                ", retainedDate=" + retainedDate +
                ", itemNumber=" + itemNumber +
                '}';
    }
}

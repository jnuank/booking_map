package book.application.service.reservation;

import book.application.repository.ReservationRepository;
import book.domain.model.reservation.request.Reservation;
import book.domain.model.reservation.request.ReservationNumber;
import book.domain.model.reservation.request.Reservations;
import org.springframework.stereotype.Service;

/**
 * 貸出予約参照サービス
 */
@Service
public class ReservationQueryService {
    ReservationRepository reservationRepository;

    ReservationQueryService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * 未準備の予約を一覧する
     */
    public Reservations reservations() {
        return reservationRepository.reservations();
    }

    /**
     * 予約を見つける
     */
    public Reservation reservationOf(ReservationNumber reservationNumber) {
        return reservationRepository.findBy(reservationNumber);
    }
}

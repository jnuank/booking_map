package book.application.repository;

import book.domain.model.reservation.request.Reservation;
import book.domain.model.reservation.request.ReservationNumber;
import book.domain.model.reservation.request.Reservations;

/**
 * 予約リポジトリ
 */
public interface ReservationRepository {
    void reserve(Reservation tryingToReserveBook);

    Reservations reservations();

    Reservation findBy(ReservationNumber reservationNumber);

    void cancel(Reservation reservation);
}

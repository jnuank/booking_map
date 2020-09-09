package book.application.repository;

import book.domain.model.reservation.request.Reservation;
import book.domain.model.reservation.retention.Retained;

public interface RetentionNotification {
    void retained(Retained retained);

    void notAvailable(Reservation reservation);
}

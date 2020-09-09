package book.presentation.retention;

import book.application.coordinator.retention.RetentionCoordinator;
import book.domain.model.reservation.request.Reservation;
import book.domain.model.reservation.request.ReservationNumber;
import book.domain.model.reservation.request.Reservations;
import book.domain.model.reservation.retention.Retention;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 予約の管理画面
 */
@Controller("予約の管理")
@RequestMapping("retentions/requests")
public class ReservationController {
    RetentionCoordinator retentionCoordinator;

    public ReservationController(RetentionCoordinator retentionCoordinator) {
        this.retentionCoordinator = retentionCoordinator;
    }

    @GetMapping
    String requests(Model model) {
        Reservations reservations = retentionCoordinator.reservations();
        model.addAttribute("reservations", reservations);
        return "retention/requests";
    }

    @GetMapping("{reservationNumber}")
    String retentionForm(
            @PathVariable("reservationNumber") ReservationNumber reservationNumber,
            Model model) {
        Reservation reservation = retentionCoordinator.reservationOf(reservationNumber);
        model.addAttribute("reservation", reservation);
        model.addAttribute("retention", new Retention());
        return "retention/form";
    }

    @PostMapping("canceled")
    String cancel(@RequestParam("notAvailable") ReservationNumber reservationNumber) {
        retentionCoordinator.cancel(reservationNumber);
        return "redirect:/retentions/requests";
    }
}

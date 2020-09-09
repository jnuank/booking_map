package book.infrastructure.datasource.retention;

import book.domain.model.item.ItemNumber;
import book.domain.model.reservation.request.ReservationNumber;
import book.domain.model.reservation.retention.Retained;
import book.domain.model.reservation.retention.RetainedDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RetentionMapper {

    void insert未準備(ReservationNumber reservationNumber);

    void delete未準備(ReservationNumber reservationNumber);

    void insert取置履歴(
            @Param("reservationNumber") ReservationNumber reservationNumber,
            @Param("itemNumber") ItemNumber itemNumber,
            @Param("retainedDate") RetainedDate retainedDate);

    void insert準備完了(
            @Param("reservationNumber") ReservationNumber reservationNumber,
            @Param("itemNumber") ItemNumber itemNumber,
            @Param("retainedDate") RetainedDate retainedDate);

    List<Retained> selectAll準備完了();

    Retained select準備完了(ItemNumber itemNumber);

    void delete準備完了(ItemNumber itemNumber);

    void insert取置解放履歴(
            @Param("reservationNumber") ReservationNumber reservationNumber,
            @Param("itemNumber") ItemNumber itemNumber);

    void insert取置期限切れ履歴(ReservationNumber reservationNumber);
}

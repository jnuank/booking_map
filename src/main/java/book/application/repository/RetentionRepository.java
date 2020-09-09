package book.application.repository;

import book.domain.model.item.ItemNumber;
import book.domain.model.reservation.retention.Retained;
import book.domain.model.reservation.retention.RetainedList;
import book.domain.model.reservation.retention.Retention;

/**
 * 取置リポジトリ
 */
public interface RetentionRepository {

    void retained(Retention retention);

    void released(Retained retained);

    void expired(Retained retained);


    RetainedList retentions();

    Retained findBy(ItemNumber itemNumber);
}

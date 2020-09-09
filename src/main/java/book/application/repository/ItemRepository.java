package book.application.repository;

import book.domain.model.item.Item;
import book.domain.model.item.ItemNumber;
import book.domain.model.item.ItemStatus;

/**
 * 蔵書リポジトリ
 */
public interface ItemRepository {
    ItemStatus status(ItemNumber itemNumber);

    Item findBy(ItemNumber itemNumber);
}

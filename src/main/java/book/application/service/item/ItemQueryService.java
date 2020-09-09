package book.application.service.item;

import book.application.repository.ItemRepository;
import book.domain.model.item.Item;
import book.domain.model.item.ItemNumber;
import book.domain.model.item.ItemStatus;
import org.springframework.stereotype.Service;

/**
 * 蔵書検索サービス
 */
@Service
public class ItemQueryService {
    ItemRepository itemRepository;

    public ItemQueryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * 蔵書の状態を調べる
     */
    public ItemStatus status(ItemNumber itemNumber) {
        return itemRepository.status(itemNumber);
    }

    /**
     * 蔵書を見つける
     */
    public Item findBy(ItemNumber itemNumber) {
        return itemRepository.findBy(itemNumber);
    }
}

package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //JPA가 트랜잭션을 읽는 기능만 수행
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemrepository;

    @Transactional
    public void saveItem(Item item){
        itemrepository.save(item);
    }

    /**
     * 영속성 컨텍스트가 자동 생성
     * 변경 감지 메서드
     */
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity){
        Item item = itemrepository.findOne(itemId); //영속성 엔티티

        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems(){
        return itemrepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemrepository.findOne(itemId);
    }
}

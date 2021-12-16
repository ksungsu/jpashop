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

    public List<Item> findItems(){
        return itemrepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemrepository.findOne(itemId);
    }
}

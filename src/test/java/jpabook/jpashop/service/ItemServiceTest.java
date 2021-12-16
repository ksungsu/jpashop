package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 임의의 Item Test code 작성..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 아이템_등록() throws Exception
    {
        //given
        Book book = new Book();
        book.setName("kimsungsu");
        book.setPrice(15000);
        book.addStock(1);

        //when
        itemService.saveItem(book);
        Item findOneBook = itemService.findOne(book.getId());
        List<Item> bookItems = itemService.findItems();

        //then
        Assertions.assertThat(book).isEqualTo(findOneBook);
    }

}
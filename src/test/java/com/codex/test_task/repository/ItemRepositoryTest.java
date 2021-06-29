package com.codex.test_task.repository;

import com.codex.test_task.entity.Item;
import com.codex.test_task.exception.DBNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    @Test
//    public void findAll_test() {
//        List<Item> items = itemRepository.findAll();
//        assertEquals(5, items.size());
//    }
//
//    @Test
//    public void findById_test() {
//        UUID uuid = UUID.fromString("602f347c-a79e-11eb-bcbc-0242ac130001");
//        Item item = itemRepository.getById(uuid);
//        assertNotNull(item);
//        assertThrows(DBNotFoundException.class, () -> itemRepository.getById(uuid));
//    }
}

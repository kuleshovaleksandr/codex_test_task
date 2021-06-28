package com.codex.test_task.service;

import com.codex.test_task.entity.Cart;
import com.codex.test_task.exception.DBExecutionException;
import com.codex.test_task.exception.DBNotFoundException;
import com.codex.test_task.repository.CartRepository;
import com.codex.test_task.repository.ItemRepository;
import com.codex.test_task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final String NOT_FOUND_MESSAGE = "There is no such element";
    private final String EXECUTE_FAIL = "Fail to update or delete";

    @PersistenceContext
    private final EntityManager entityManager;

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean addToCart(UUID itemId) {
        return false;
    }

    @Override
    public boolean deleteFromCart(UUID itemId) {

        if(!itemRepository.existsById(itemId)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }

        Optional<Cart> cart= cartRepository.findByItems(itemId);

        if(!cart.isPresent()) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        } else {
            cartRepository.deleteFromCart(itemId);
            return true;
        }
        //        int rows = entityManager.createQuery("delete from cart_item where item_id = :item_id")
//                .setParameter("item_id", itemId)
//                .executeUpdate();
//        if(rows >= 1) {
//            return true;
//        } else {
//            throw new DBExecutionException(EXECUTE_FAIL);
//        }
    }
}

package com.codex.test_task.service;

import com.codex.test_task.entity.Cart;
import com.codex.test_task.entity.User;
import com.codex.test_task.exception.DBNotFoundException;
import com.codex.test_task.repository.CartRepository;
import com.codex.test_task.repository.ItemRepository;
import com.codex.test_task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService {

    private final String NOT_FOUND_MESSAGE = "There is no such element";

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean addToCart(UUID itemId, String username) {
        return false;
    }

    @Override
    public boolean deleteFromCart(UUID itemId, String userEmail) {

        if(!itemRepository.existsById(itemId)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }

        User user = userRepository.findUserByEmail(userEmail)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        Cart cart = cartRepository.findCartByUserId(user.getId())
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        cartRepository.removeFromCart(itemId, cart.getId());
        return true;
    }
}

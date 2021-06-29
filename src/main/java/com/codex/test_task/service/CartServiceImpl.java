package com.codex.test_task.service;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.entity.Cart;
import com.codex.test_task.entity.Item;
import com.codex.test_task.entity.User;
import com.codex.test_task.exception.DBNotFoundException;
import com.codex.test_task.mapper.ItemMapper;
import com.codex.test_task.repository.CartRepository;
import com.codex.test_task.repository.ItemRepository;
import com.codex.test_task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService {

    private final String NOT_FOUND_MESSAGE = "There is no such element";

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
//    private final MailSender mailSender;

    @Override
    public List<ItemDto> buyItems(String userEmail) {
        User user = userRepository.findUserByEmail(userEmail)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        Cart cart = cartRepository.findCartByUserId(user.getId())
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        List<Item> items = itemRepository.findItemsByCartId(cart.getId());

//        mailSender.sendEmailAfterBuying(user.getEmail(), items);

        cartRepository.delete(cart);
        return itemMapper.toDto(items);
    }

    @Override
    public boolean addToCart(UUID itemId, String userEmail) {

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        User user = userRepository.findUserByEmail(userEmail)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        Optional<Cart> optionalCart = cartRepository.findCartByUserId(user.getId());

        if(!optionalCart.isPresent()) {
            Set<Item> items = new HashSet<>();
            items.add(item);
            cartRepository.save(new Cart(user, items));
        } else {
            Cart cart = optionalCart.get();
            cartRepository.saveInCart(itemId, cart.getId());
        }
        return true;
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

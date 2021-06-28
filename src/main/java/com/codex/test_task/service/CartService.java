package com.codex.test_task.service;

import com.codex.test_task.dto.ItemDto;

import java.util.List;
import java.util.UUID;

public interface CartService {

    List<ItemDto> buyItems(String username);

    boolean addToCart(UUID itemId, String username);

    boolean deleteFromCart(UUID itemId, String username);
}

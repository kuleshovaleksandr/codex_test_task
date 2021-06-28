package com.codex.test_task.service;

import java.util.UUID;

public interface CartService {

    boolean addToCart(UUID itemId, String username);

    boolean deleteFromCart(UUID itemId, String username);
}

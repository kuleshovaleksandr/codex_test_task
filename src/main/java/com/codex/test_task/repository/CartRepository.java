package com.codex.test_task.repository;

import com.codex.test_task.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByItems(UUID itemId);

    @Transactional
    @Modifying
    @Query(value="delete from cart_item where item_id = :itemId", nativeQuery = true)
    void deleteFromCart(UUID itemId);
}

package com.codex.test_task.repository;

import com.codex.test_task.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Transactional
    @Modifying
    @Query(value="select * from item where id in (select item_id from cart_item where cart_id = :cartId)", nativeQuery = true)
    List<Item> findItemsByCartId(UUID cartId);

    @Transactional
    @Modifying
    @Query(value="select * from item where id in (select item_id from cart_item where item_id = :itemId)", nativeQuery = true)
    List<Item> findItemsInCartsByItemId(UUID itemId);
}

package com.codex.test_task.repository;

import com.codex.test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String userEmail);

    @Transactional
    @Modifying
    @Query(value="select * from users where id in (select user_id from cart where id in (select cart_id from cart_item where item_id = :itemId))", nativeQuery = true)
    List<User> findUsersByItemIdInCart(UUID itemId);
}

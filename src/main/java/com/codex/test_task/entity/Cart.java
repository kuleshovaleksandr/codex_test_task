package com.codex.test_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cart extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name="cart_item",
            joinColumns = @JoinColumn(name="cart_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
    private Set<Item> items;
}

package com.codex.test_task.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="item")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Item extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="item_tag",
            joinColumns = @JoinColumn(name="item_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id"))
    private List<Tag> tags;

    @ManyToMany
    @JoinTable(name="cart_item",
            joinColumns = @JoinColumn(name="item_id"),
            inverseJoinColumns = @JoinColumn(name="cart_id"))
    private List<Cart> carts;
}

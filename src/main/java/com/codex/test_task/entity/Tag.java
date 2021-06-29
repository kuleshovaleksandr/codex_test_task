package com.codex.test_task.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tag")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Tag extends AbstractEntity{

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="item_tag",
            joinColumns = @JoinColumn(name="tag_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item> items;
}

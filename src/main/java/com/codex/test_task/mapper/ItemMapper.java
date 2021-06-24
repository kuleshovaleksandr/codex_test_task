package com.codex.test_task.mapper;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper extends AbstractMapper<Item, ItemDto> {

    public ItemMapper() {
        super(Item.class, ItemDto.class);
    }
}

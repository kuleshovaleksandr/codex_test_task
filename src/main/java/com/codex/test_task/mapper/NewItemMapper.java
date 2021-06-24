package com.codex.test_task.mapper;

import com.codex.test_task.dto.NewItemDto;
import com.codex.test_task.entity.Item;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NewItemMapper extends AbstractMapper<Item, NewItemDto> {

    public NewItemMapper() {
        super(Item.class, NewItemDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(NewItemDto.class, Item.class)
                .addMappings(m -> m.skip(Item::setId))
                .setPostConverter(toEntityConverter());
    }
}

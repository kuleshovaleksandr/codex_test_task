package com.codex.test_task.service;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.dto.NewItemDto;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    List<ItemDto> getAllItems();

    ItemDto getItemById(UUID id);

    ItemDto saveItem(NewItemDto newItemDto);

    ItemDto updateItem(UUID id, NewItemDto newItemDto);

    ItemDto forceUpdateItem(UUID id, NewItemDto newItemDto);

    boolean deleteItem(UUID id);
}

package com.codex.test_task.service;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.entity.Item;
import com.codex.test_task.mapper.ItemMapper;
import com.codex.test_task.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.toDto(items);
    }
}

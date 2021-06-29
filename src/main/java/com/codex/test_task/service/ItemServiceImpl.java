package com.codex.test_task.service;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.dto.NewItemDto;
import com.codex.test_task.entity.Item;
import com.codex.test_task.exception.DBNotFoundException;
import com.codex.test_task.exception.ItemExistsInCartException;
import com.codex.test_task.mapper.ItemMapper;
import com.codex.test_task.mapper.NewItemMapper;
import com.codex.test_task.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService {

    private final String NOT_FOUND_MESSAGE = "There is no such element";
    private final String ITEM_IN_CART_MESSAGE = "You can't change/update the item because it is in the user's shopping cart";

    private final ItemMapper itemMapper;
    private final NewItemMapper newItemMapper;

    private final ItemRepository itemRepository;

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.toDto(items);
    }

    @Override
    public ItemDto getItemById(UUID id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        return itemMapper.toDto(item);
    }

    @Override
    public ItemDto saveItem(NewItemDto newItemDto) {
        Item item = itemRepository.save(newItemMapper.toEntity(newItemDto));
        return itemMapper.toDto(item);
    }

    @Override
    public ItemDto updateItem(UUID itemId, NewItemDto newItemDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        List<Item> items = itemRepository.findItemsInCartsByItemId(itemId);

        if(items == null || items.size() == 0) {
            item.setName(newItemDto.getName());
            item.setDescription(newItemDto.getDescription());
            Item updatedItem = itemRepository.save(item);
            return itemMapper.toDto(updatedItem);
        } else {
            throw new ItemExistsInCartException(ITEM_IN_CART_MESSAGE);
        }
    }

    @Override
    public boolean deleteItem(UUID id) {
        if(!itemRepository.existsById(id)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }
        itemRepository.deleteById(id);
        return true;
    }
}

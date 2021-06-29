package com.codex.test_task.controller;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.dto.NewItemDto;
import com.codex.test_task.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags="Controller for items")
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @ApiOperation("Method to get all items with filter")
    @GetMapping("/")
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<List<ItemDto>> getItemsWithFilter(@RequestParam(value = "tag", required = false) String tag,
                                                            @RequestParam(value = "description", required = false) String description) {
        if(tag != null && description == null) {
            return new ResponseEntity<>(itemService.getAllItemsByTagName(tag), HttpStatus.OK);
        } else if(description != null && tag == null) {
            return new ResponseEntity<>(itemService.getAllItemsByDescription(description), HttpStatus.OK);
        } else if(tag != null && description != null) {
            return new ResponseEntity<>(itemService.getAllItemsWithFilter(tag, description), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
        }
    }

    @ApiOperation("Method to get item by Id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<ItemDto> getItem(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @ApiOperation("Method to create item")
    @PostMapping
    @PreAuthorize("hasAuthority('item:write')")
    public ResponseEntity<ItemDto> createItem(@RequestBody NewItemDto newItemDto) {
        return new ResponseEntity<>(itemService.saveItem(newItemDto), HttpStatus.CREATED);
    }

    @ApiOperation("Method to update an item")
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('item:write')")
    public ResponseEntity<ItemDto> editItem(@PathVariable("id") UUID id,
                                                            @RequestBody NewItemDto newItemDto) {
        return new ResponseEntity<>(itemService.updateItem(id, newItemDto), HttpStatus.OK);
    }

    @ApiOperation("Method to delete item")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('item:write')")
    public ResponseEntity<?> deleteItem(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);
    }

    @ApiOperation("Method to force update an item if it is in user's cart")
    @PutMapping("/forceUpdate/{id}")
    @PreAuthorize("hasAuthority('item:write')")
    public ResponseEntity<ItemDto> forceUpdateItem(@PathVariable("id") UUID id,
                                            @RequestBody NewItemDto newItemDto) {
        return new ResponseEntity<>(itemService.forceUpdateItem(id, newItemDto), HttpStatus.OK);
    }
}

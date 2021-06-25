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

    @ApiOperation("Method to get all items")
    @GetMapping
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<List<ItemDto>> getItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
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
}

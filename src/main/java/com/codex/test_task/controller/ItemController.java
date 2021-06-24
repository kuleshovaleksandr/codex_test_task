package com.codex.test_task.controller;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="Controller for items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @ApiOperation("Method to get all items")
    public ResponseEntity<List<ItemDto>> getItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }
}

package com.codex.test_task.controller;

import com.codex.test_task.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Api(tags="Controller for cart")
@RequiredArgsConstructor
@RequestMapping("/items/cart")
public class CartController {

    private final CartService cartService;

    @ApiOperation("Method to save an item in cart")
    @PostMapping("/{itemId}")
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<?> addToCart(@PathVariable("itemId") UUID itemId) {
        return new ResponseEntity<>(cartService.addToCart(itemId), HttpStatus.CREATED);
    }

    @ApiOperation("Method to delete an item in cart")
    @DeleteMapping("/{itemId}")
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<?> deleteFromCart(@PathVariable("itemId") UUID itemId) {
        return new ResponseEntity<>(cartService.deleteFromCart(itemId), HttpStatus.OK);
    }
}

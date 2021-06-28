package com.codex.test_task.controller;

import com.codex.test_task.dto.ItemDto;
import com.codex.test_task.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags="Controller for cart")
@RequiredArgsConstructor
@RequestMapping("/items/cart")
public class CartController {

    private final CartService cartService;

    @ApiOperation("Method to buy items")
    @DeleteMapping
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<List<ItemDto>> buyItems(Authentication auth) {
        String username = auth.getName();
        return new ResponseEntity<>(cartService.buyItems(username), HttpStatus.OK);
    }

    @ApiOperation("Method to save an item in cart")
    @PostMapping("/{itemId}")
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<?> addToCart(@PathVariable("itemId") UUID itemId, Authentication auth) {
        String username = auth.getName();
        return new ResponseEntity<>(cartService.addToCart(itemId, username), HttpStatus.CREATED);
    }

    @ApiOperation("Method to delete an item in cart")
    @DeleteMapping("/{itemId}")
    @PreAuthorize("hasAuthority('item:read')")
    public ResponseEntity<?> deleteFromCart(@PathVariable("itemId") UUID itemId, Authentication auth) {
        String username = auth.getName();
        return new ResponseEntity<>(cartService.deleteFromCart(itemId, username), HttpStatus.OK);
    }
}

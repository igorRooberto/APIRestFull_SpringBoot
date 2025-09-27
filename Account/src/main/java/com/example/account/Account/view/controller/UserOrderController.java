package com.example.account.Account.view.controller;

import com.example.account.Account.services.UserOrderServices;
import com.example.account.Account.view.dto.UserOrderCreateDto;
import com.example.account.Account.view.dto.UserOrderResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users/orders")
public class UserOrderController {

    private final UserOrderServices userOrdersServices;

    public UserOrderController(UserOrderServices userOrdersServices){
        this.userOrdersServices = userOrdersServices;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<UserOrderResponseDto> createOrder(@PathVariable UUID userId, @RequestBody UserOrderCreateDto dto){
        return new ResponseEntity<>(userOrdersServices.createOrder(userId,dto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserOrderResponseDto>> getAllOrdersByUser(@PathVariable UUID userId){
        return new ResponseEntity<>(userOrdersServices.getOrdersByUser(userId), HttpStatus.OK);
    }
}

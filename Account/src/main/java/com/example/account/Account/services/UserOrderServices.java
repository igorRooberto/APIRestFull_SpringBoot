package com.example.account.Account.services;

import com.example.account.Account.entities.User;
import com.example.account.Account.entities.UserOrders;
import com.example.account.Account.mapper.UserOrderMapper;
import com.example.account.Account.repository.UserOrderRepository;
import com.example.account.Account.repository.UserRepository;
import com.example.account.Account.view.dto.UserOrderCreateDto;
import com.example.account.Account.view.dto.UserOrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserOrderServices {

    private final UserOrderRepository userOrdersRepository;
    private final UserRepository userRepository;
    private final UserOrderMapper userOrderMapper;

    public UserOrderServices(UserOrderRepository userOrdersRepository, UserRepository userRepository, UserOrderMapper userOrderMapper){
        this.userOrdersRepository = userOrdersRepository;
        this.userRepository = userRepository;
        this.userOrderMapper = userOrderMapper;
    }

    public UserOrderResponseDto createOrder(UUID userId, UserOrderCreateDto dto){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        UserOrders order = userOrderMapper.toEntity(dto);
        order.setUser(user);
        UserOrders savedOrder = userOrdersRepository.save(order);

        return userOrderMapper.toResponse(savedOrder);
    }

    public List<UserOrderResponseDto> getOrdersByUser(UUID id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return user.getUserOrders()
                .stream()
                .map(userOrderMapper::toResponse)
                .collect(Collectors.toList());
    }
}

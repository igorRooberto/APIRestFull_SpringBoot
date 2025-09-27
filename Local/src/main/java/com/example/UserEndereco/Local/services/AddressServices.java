package com.example.UserEndereco.Local.services;

import com.example.UserEndereco.Local.entities.Address;
import com.example.UserEndereco.Local.entities.User;
import com.example.UserEndereco.Local.handler.exception.ResourceNotFoundException;
import com.example.UserEndereco.Local.mapper.AddressMapper;
import com.example.UserEndereco.Local.repository.AddressRepository;
import com.example.UserEndereco.Local.repository.UserRepository;
import com.example.UserEndereco.Local.view.dto.AddressCreateDto;
import com.example.UserEndereco.Local.view.dto.AddressResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServices {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    public AddressServices(AddressRepository addressRepository, AddressMapper addressMapper,UserRepository userRepository){
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.userRepository = userRepository;
    }

    public AddressResponseDto cadastrarEndereco(Long user_id, AddressCreateDto dto){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id: " + user_id));

        Address address = addressMapper.toEntityAddress(dto);
        address.setUser(user);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toResponseAddress(savedAddress);
    }

    public void DeletarEndereco(Long id){
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        addressRepository.deleteById(id);

    }

    public AddressResponseDto obterPorId(Long id){
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        return addressMapper.toResponseAddress(address.get());
    }

}

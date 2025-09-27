package com.example.UserEndereco.Local.view.controller;

import com.example.UserEndereco.Local.entities.Address;
import com.example.UserEndereco.Local.mapper.AddressMapper;
import com.example.UserEndereco.Local.services.AddressServices;
import com.example.UserEndereco.Local.view.dto.AddressCreateDto;
import com.example.UserEndereco.Local.view.dto.AddressResponseDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/address")
public class AddressController {

    private final AddressServices addressServices;
    private final AddressMapper addressMapper;

    public AddressController(AddressMapper addressMapper, AddressServices addressServices) {
        this.addressMapper = addressMapper;
        this.addressServices = addressServices;
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<AddressResponseDto> cadastrar(@RequestBody AddressCreateDto dto, @PathVariable Long user_id){
        addressServices.cadastrarEndereco(user_id, dto);
        Address address = addressMapper.toEntityAddress(dto);

        return new ResponseEntity<>(addressMapper.toResponseAddress(address), HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<AddressResponseDto> obterPorId(@PathVariable Long user_id){
        return new ResponseEntity<>(addressServices.obterPorId(user_id), HttpStatus.OK);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<AddressResponseDto> deletarPorid(@PathVariable Long user_id){
        addressServices.DeletarEndereco(user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

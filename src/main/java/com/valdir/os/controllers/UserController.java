package com.valdir.os.controllers;

import com.valdir.os.domain.User;
import com.valdir.os.domain.dtos.UserDTO;
import com.valdir.os.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * This method will find a User by id and case the
     * User not exists return a personalized error
     * @return User
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * This method will find all Users or return a void
     * @return List of Users
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    /**
     * This method will insert a new User
     * @return a User and a URI to access
     * the new User by id
     */
    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDTO) {
        User newObj = service.insert(objDTO);
        objDTO = service.fromDTO(newObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/delete={id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * This method will update a new User by id
     * @return a UserDTO updated
     */
    @PutMapping(value = "/update={id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO objDTO) {
        User newObj = service.update(id, objDTO);
        objDTO = service.fromDTO(newObj);
        return ResponseEntity.ok().body(objDTO);
    }
}

package com.valdir.os.controllers;

import com.valdir.os.domain.Client;
import com.valdir.os.domain.dtos.ClientDTO;
import com.valdir.os.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    /**
     * This method will find a Client by id and case the
     * client not exists return a personalized error
     * @return Client
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) {
        Client obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * This method will find all Clients or return a void
     * @return List of Clients
     */
    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> list = service.findAll();
        List<ClientDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    /**
     * This method will insert a new Client
     * @return a Client
     */
    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO objDTO) {
        Client newObj = service.insert(objDTO);
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
     * This method will update a new Client by id
     * @return a ClientDTO updated
     */
    @PutMapping(value = "/update={id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @RequestBody ClientDTO objDTO) {
        Client newObj = service.update(id, objDTO);
        objDTO = service.fromDTO(newObj);
        return ResponseEntity.ok().body(objDTO);
    }
}

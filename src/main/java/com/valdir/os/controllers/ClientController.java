package com.valdir.os.controllers;

import com.valdir.os.domain.Client;
import com.valdir.os.domain.dtos.ClientDTO;
import com.valdir.os.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<ClientDTO> insert(ClientDTO objDTO) {
        Client newObj = service.insert(objDTO);
        objDTO = service.fromDTO(newObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(objDTO);
    }
}

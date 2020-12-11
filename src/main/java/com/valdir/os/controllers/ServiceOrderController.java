package com.valdir.os.controllers;

import com.valdir.os.domain.ServiceOrder;
import com.valdir.os.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/so")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService service;

    /**
     * This method will find a Service Order by id
     * @return a Service Order or null
     * */
    @GetMapping(value = "/find={id}")
    public ResponseEntity<ServiceOrder> findByID(@PathVariable Integer id) {
        ServiceOrder obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * This method will create a Service Order
     * @return a Service Order and a URI
     * */
    @PostMapping(value = "/create")
    public ResponseEntity<ServiceOrder> insert(@RequestBody ServiceOrder obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/find={id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}

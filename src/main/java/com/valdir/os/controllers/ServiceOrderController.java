package com.valdir.os.controllers;

import com.valdir.os.domain.ServiceOrder;
import com.valdir.os.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

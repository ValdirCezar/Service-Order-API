package com.valdir.os.services;

import com.valdir.os.domain.ServiceOrder;
import com.valdir.os.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository repository;

    /**
     * This method will find a Service Order by id
     * @return a Service Order or null
     * */
    public ServiceOrder findById(Integer id) {
        Optional<ServiceOrder> obj = repository.findById(id);
        return obj.orElse(null);
    }
}

package com.valdir.os.services;

import com.valdir.os.domain.ServiceOrder;
import com.valdir.os.enums.Status;
import com.valdir.os.repositories.ClientRepository;
import com.valdir.os.repositories.ServiceOrderRepository;
import com.valdir.os.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;

    /**
     * This method will find a Service Order by id
     * @return a Service Order or null
     * */
    public ServiceOrder findById(Integer id) {
        Optional<ServiceOrder> obj = repository.findById(id);
        return obj.orElse(null);
    }

    /**
     * This method will create a Service Order
     * @return a Service Order
     * */
    @Transactional
    public ServiceOrder insert(ServiceOrder obj) {
        obj.setId(null);
        obj.setStartDate(LocalDateTime.now());
        obj.setStatus(Status.OPEN);
        obj.setUser(userService.findById(obj.getUser().getId()));
        obj.setClient(clientService.findById(obj.getClient().getId()));
        return repository.save(obj);
    }
}

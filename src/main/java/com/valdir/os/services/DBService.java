package com.valdir.os.services;

import com.valdir.os.domain.Client;
import com.valdir.os.domain.ServiceOrder;
import com.valdir.os.domain.User;
import com.valdir.os.enums.Status;
import com.valdir.os.repositories.ClientRepository;
import com.valdir.os.repositories.ServiceOrderRepository;
import com.valdir.os.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public void instantiateDataBase() {

        User u1 = new User(null, "Valdir Cezar", "valdir", "123", true);
        Client c1 = new Client(null, "Albert Einstein", "43984526396", true);
        ServiceOrder so1 = new ServiceOrder(null, null, Status.OPEN, 125.5, "Troca de fonte", u1, c1);

        u1.getServices().addAll(Arrays.asList(so1));
        c1.getServices().addAll(Arrays.asList(so1));

        userRepository.saveAll(Arrays.asList(u1));
        clientRepository.saveAll(Arrays.asList(c1));
        serviceOrderRepository.saveAll(Arrays.asList(so1));
    }
}

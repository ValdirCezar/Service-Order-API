package com.valdir.os.services;

import com.valdir.os.domain.Client;
import com.valdir.os.domain.dtos.ClientDTO;
import com.valdir.os.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    /**
     * This method will find a Client by id and case the
     * client not exists return a personalized error
     * @return Client
     */
    public Client findById(Integer id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElse(null);
    }


    /**
     * Method created to convert a Client to DTO
     * @return ClientDTO
     */
    public ClientDTO fromDTO(Client obj) {
        return new ClientDTO(obj);
    }
}

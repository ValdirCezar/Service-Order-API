package com.valdir.os.services;

import com.valdir.os.domain.Client;
import com.valdir.os.domain.dtos.ClientDTO;
import com.valdir.os.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        // Implementar mensagem de objeto não encontrado
    }

    /**
     * This method will find all Clients or return a void
     * @return List of Clients
     */
    public List<Client> findAll() {
        return repository.findAll();
    }

    /**
     * This method will insert a new Client
     * @return a Client
     */
    public Client insert(ClientDTO objDTO) {
        Client newObj = new Client(null, objDTO.getName(), objDTO.getPhone(), objDTO.getActive());
        return repository.save(newObj);
    }

    /**
     * This method will delete a Client by id
     * @return void
     */
    public void deleteById(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    /**
     * This method will update a new Client by id
     * @return a Client updated
     */
    public Client update(Integer id, ClientDTO objDTO) {
        objDTO.setId(id);
        Client newObj = new Client(objDTO.getId(), objDTO.getName(), objDTO.getPhone(), objDTO.getActive());
        return repository.save(newObj);
    }

    /**
     * Method created to convert a Client to DTO
     * @return ClientDTO
     */
    public ClientDTO fromDTO(Client obj) {
        return new ClientDTO(obj);
    }
}

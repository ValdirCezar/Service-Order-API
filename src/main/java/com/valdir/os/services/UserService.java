package com.valdir.os.services;

import com.valdir.os.domain.User;
import com.valdir.os.domain.dtos.UserDTO;
import com.valdir.os.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
        // Implementar not found personalizado
    }

    /**
     * This method will find all Users or return a void
     * @return List of Users
     */
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * This method will insert a new User
     * @return a User
     */
    public User insert(UserDTO objDTO) {
        User newObj = new User(null, objDTO.getName(), objDTO.getLogin(), objDTO.getPassword(), objDTO.getActive());
        return repository.save(newObj);
    }

    /**
     * This method will inactivate a User by id
     * @return void
     */
    public void deleteById(Integer id) {
        User obj = findById(id);
        obj.setActive(false);
        repository.save(obj);
    }

    /**
     * This method will update a new User by id
     * @return a User updated
     */
    public User update(Integer id, UserDTO objDTO) {
        objDTO.setId(id);
        User newObj = new User(null, objDTO.getName(), objDTO.getLogin(), objDTO.getPassword(), objDTO.getActive());
        return repository.save(newObj);
    }

    /**
     * Method created to convert a User to DTO
     * @return UserDTO
     */
    public UserDTO fromDTO(User obj) {
        return new UserDTO(obj);
    }
}

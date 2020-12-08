package com.valdir.os.dtos;

import com.valdir.os.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String login;
    private String password;

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.login = obj.getLogin();
        this.password = obj.getPassword();
    }
}

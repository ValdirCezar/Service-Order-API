package com.valdir.os.domain.dtos;

import com.valdir.os.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @Column(nullable = false)
    @Size(min = 3, max = 100, message = "Field name should have min 3 and max 100 characters")
    private String name;

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 100, message = "Field name login have min 3 and max 100 characters")
    private String login;

    @Column(nullable = false)
    @Size(min = 3, max = 100, message = "Field name password have min 3 and max 100 characters")
    private String password;

    private Boolean active = true;

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.login = obj.getLogin();
        this.password = obj.getPassword();
        this.active = obj.getActive();
    }
}

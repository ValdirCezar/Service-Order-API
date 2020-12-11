package com.valdir.os.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String login;
    private String password;
    private Boolean active = true;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<ServiceOrder> services = new ArrayList<ServiceOrder>();

    public User(Integer id, String name, String login, String password, Boolean active) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.active = active;
    }
}

package com.valdir.os.domain;

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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private Boolean active;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ServiceOrder> services = new ArrayList<>();

    public Client(Integer id, String name, String phone, Boolean active) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.active = active;
    }
}

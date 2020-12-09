package com.valdir.os.domain.dtos;

import com.valdir.os.domain.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
public class ClientDTO {

    private Integer id;

    @Column(nullable = false)
    @Size(min = 3, max = 100, message = "Field name should have min 3 and max 100 characters")
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean active;

    public ClientDTO(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.phone = obj.getPhone();
        this.active = obj.getActive();
    }
}

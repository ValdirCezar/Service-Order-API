package com.valdir.os.domain.dtos;

import com.valdir.os.domain.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClientDTO {

    private Integer id;
    private String name;
    private String phone;
    private Boolean active;

    public ClientDTO(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.phone = obj.getPhone();
        this.active = obj.getActive();
    }
}

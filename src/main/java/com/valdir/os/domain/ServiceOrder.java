package com.valdir.os.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdir.os.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class ServiceOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Integer status;
    private Double price;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Client client;

    public ServiceOrder(Integer id,
                        LocalDateTime startDate,
                        LocalDateTime finishDate,
                        Status status,
                        Double price,
                        String description,
                        User user,
                        Client client) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.status = (status == null) ? null : status.getCode();
        this.price = price;
        this.description = description;
        this.user = user;
        this.client = client;
    }

    public Status getStatus() {
        return Status.toEnum(status);
    }

    public void setStatus(Status status) {
        this.status = status.getCode();
    }
}

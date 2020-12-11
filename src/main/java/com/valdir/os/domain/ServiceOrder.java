package com.valdir.os.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.valdir.os.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
public class ServiceOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime finishDate;

    private Integer status;

    @NotNull(message = "Field price is mandatory")
    private Double price;

    @NotNull(message = "Field description is mandatory")
    @Column(length = 2048)
    private String description;

    @ManyToOne
    @JoinColumn
    @NotNull(message = "Field user is mandatory")
    private User user;

    @ManyToOne
    @JoinColumn
    @NotNull(message = "Field client is mandatory")
    private Client client;

    public ServiceOrder(Integer id,
                        LocalDateTime finishDate,
                        Status status,
                        Double price,
                        String description,
                        User user,
                        Client client) {
        this.id = id;
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

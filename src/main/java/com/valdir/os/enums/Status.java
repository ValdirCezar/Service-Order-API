package com.valdir.os.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum Status {

    OPEN(1, "Open"),
    IN_PROGRESS(2, "In Progress"),
    CLOSED(3, "Closed");

    private Integer code;
    private String prefix;

    public static Status toEnum(Integer code) {
        if(code.equals(null))
            return null;

        for(Status x : Status.values()) {
            if(code.equals(x.getCode()))
                return x;
        }

        throw new IllegalArgumentException("Inválid Id: " + code);
    }
}

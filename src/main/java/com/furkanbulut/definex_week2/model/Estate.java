package com.furkanbulut.definex_week2.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Estate {

    // ev tipi enum türünde olduğu belirtildi.
    @Enumerated(EnumType.STRING)
    private EstateType estateType;

    private Integer numberOfRooms;
    private Integer numberOfHalls;
    private Integer squareMeters;
    private BigDecimal price;

}
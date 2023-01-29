package com.furkanbulut.definex_week2;

import com.furkanbulut.definex_week2.model.Estate;
import com.furkanbulut.definex_week2.model.EstateType;
import com.furkanbulut.definex_week2.service.EstateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DefinexWeek2Application {

    public static void main(String[] args) {
        SpringApplication.run(DefinexWeek2Application.class, args);
        EstateService estateService = new EstateService();
        Estate house1 = Estate.builder()
                .numberOfRooms(3).numberOfHalls(1)
                .price(BigDecimal.valueOf(233000))
                .estateType(EstateType.valueOf("HOUSE"))
                .squareMeters(125)
                .build();
        Estate house2 = Estate.builder()
                .numberOfRooms(2).numberOfHalls(1)
                .price(BigDecimal.valueOf(159000))
                .squareMeters(134)
                .estateType(EstateType.valueOf("HOUSE"))
                .build();
        Estate house3 = Estate.builder()
                .numberOfHalls(1).numberOfRooms(1)
                .estateType(EstateType.valueOf("HOUSE"))
                .squareMeters(100)
                .price(BigDecimal.valueOf(145000))
                .build();
        Estate villa1=Estate.builder()
                .numberOfRooms(4).numberOfHalls(1)
                .squareMeters(155)
                .estateType(EstateType.valueOf("VILLA"))
                .price(BigDecimal.valueOf(400000))
                .build();
        Estate villa2=Estate.builder()
                .numberOfRooms(4).numberOfHalls(2)
                .squareMeters(160)
                .estateType(EstateType.valueOf("VILLA"))
                .price(BigDecimal.valueOf(500000))
                .build();
        Estate villa3=Estate.builder()
                .numberOfRooms(6).numberOfHalls(3)
                .squareMeters(250)
                .estateType(EstateType.VILLA)
                .price(BigDecimal.valueOf(800000))
                .build();
        Estate summerHoues1=Estate.builder()
                .numberOfRooms(4).numberOfHalls(1)
                .squareMeters(150)
                .estateType(EstateType.valueOf("SUMMERHOUSE"))
                .price(BigDecimal.valueOf(1000000))
                .build();
        Estate summerHouse2=Estate.builder()
                .numberOfRooms(3).numberOfHalls(1)
                .squareMeters(120)
                .estateType(EstateType.valueOf("SUMMERHOUSE"))
                .price(BigDecimal.valueOf(700000))
                .build();
        Estate summerHouse3=Estate.builder()
                .numberOfRooms(1).numberOfHalls(1)
                .squareMeters(180)
                .estateType(EstateType.valueOf("SUMMERHOUSE"))
                .price(BigDecimal.valueOf(600000))
                .build();

        // create house
        System.out.println("---------------------------------------------------------");
        System.out.println(estateService.createEstate(house1));
        System.out.println(estateService.createEstate(house2));
        System.out.println((estateService.createEstate(house3)));
       // create villa
        System.out.println("---------------------------------------------------------");
        System.out.println((estateService.createEstate(villa1)));
        System.out.println((estateService.createEstate(villa2)));
        System.out.println((estateService.createEstate(villa3)));
        // create summerHouse
        System.out.println("---------------------------------------------------------");
        System.out.println((estateService.createEstate(summerHoues1)));
        System.out.println((estateService.createEstate(summerHouse2)));
        System.out.println((estateService.createEstate(summerHouse3)));

        //total price
        System.out.println("---------------------------------------------------------");
        System.out.println("Total price of all types of houses = "+estateService.getTotalPriceEstates());
        System.out.println("Total Price Of Houses = "+estateService.getTotalPriceHouses());
        System.out.println("Total Price Of SummerHouses = "+estateService.getTotalPriceSummerHouses());
        System.out.println("Total Price Of Villas = "+estateService.getTotalPriceVillas());
        System.out.println("---------------------------------------------------------");
        // average squareMeters
        System.out.println("Average square meter of houses of all types = "+estateService.getAvgSquareEstates());
        System.out.println("Average square meter of houses = "+estateService.getAvgSquareHouses());
        System.out.println("Average square meter of Summerhouses = "+estateService.getAvgSquareSummerHouses());
        System.out.println("Average square meter of Villa = "+estateService.getAvgSquareVillas());
        System.out.println("---------------------------------------------------------");
        //filter numberOfRooms and numberOfHalls
        System.out.println(estateService.getNumberOfRoom(3,1));


    }

}

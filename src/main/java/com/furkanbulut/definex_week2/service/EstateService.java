package com.furkanbulut.definex_week2.service;

import com.furkanbulut.definex_week2.model.Estate;
import com.furkanbulut.definex_week2.model.EstateType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class EstateService {
    List<Estate> estateList = new ArrayList<>();

    public Estate createEstate(Estate estate){
        estateList.add(estate);
        return estate;
    }

    public List<Estate> getAllEstates(){
        return estateList;
    }
    public BigDecimal getTotalPriceSummerHouses(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.SUMMERHOUSE))
                .map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal getTotalPriceHouses() {
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.HOUSE))
                .map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal getTotalPriceVillas(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.VILLA))
                .map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal getTotalPriceEstates(){
        return estateList.stream().map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public Double getAvgSquareSummerHouses(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.SUMMERHOUSE))
                .mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    public Double getAvgSquareVillas(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.VILLA))
                .mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    public Double getAvgSquareHouses(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.HOUSE))
                .mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    public Double getAvgSquareEstates(){
        return estateList.stream().mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    public List<Estate> getNumberOfRoom(Integer numberOfRooms,Integer numberOfHalls){
        return estateList.stream()
                .filter(estate -> estate.getNumberOfRooms().equals(numberOfRooms))
                .filter(estate -> estate.getNumberOfHalls().equals(numberOfHalls))
                .toList();

    }




}

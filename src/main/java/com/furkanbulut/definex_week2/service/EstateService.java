package com.furkanbulut.definex_week2.service;

import com.furkanbulut.definex_week2.model.Estate;
import com.furkanbulut.definex_week2.model.EstateType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class EstateService {
    List<Estate> estateList = new ArrayList<>();

    // herhangi türde bir ev ekleme fonksiyonu
    public Estate createEstate(Estate estate){
        estateList.add(estate);
        return estate;
    }
    // kayıtlı bütün evlerin dönderildiği fonksiyon
    public List<Estate> getAllEstates(){
        return estateList;
    }

    //tüm yazlıkların toplam fiyatlarını dönen fonksiyon
    public BigDecimal getTotalPriceSummerHouses(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.SUMMERHOUSE))
                .map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    //tüm evlerin toplam fiyatlarını dönen fonksiyon
    public BigDecimal getTotalPriceHouses() {
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.HOUSE))
                .map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    //tüm villaların toplam fiyatlarını dönen fonksiyon
    public BigDecimal getTotalPriceVillas(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.VILLA))
                .map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    // tüm emlakların toplam fiyatlarını dönen fonksiyon
    public BigDecimal getTotalPriceEstates(){
        return estateList.stream().map(Estate::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    // yazlık evlerin ortalama metrekaresini dönen method
    public Double getAvgSquareSummerHouses(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.SUMMERHOUSE))
                .mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    //villaların ortalama metrekaresini dönen method
    public Double getAvgSquareVillas(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.VILLA))
                .mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
  //  evlerin ortalama metrekaresini dönen method
    public Double getAvgSquareHouses(){
        return estateList.stream()
                .filter(estate -> estate.getEstateType()
                        .equals(EstateType.HOUSE))
                .mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    // tüm emlakların ortalama metrekaresini dönen method
    public Double getAvgSquareEstates(){
        return estateList.stream().mapToDouble(Estate::getSquareMeters)
                .average().orElse(0);
    }
    // istenilen oda sayısı ve salon sayısına göre kayıtlı emlakları dönderen method
    public List<Estate> getNumberOfRoom(Integer numberOfRooms,Integer numberOfHalls){
        return estateList.stream()
                .filter(estate -> estate.getNumberOfRooms().equals(numberOfRooms))
                .filter(estate -> estate.getNumberOfHalls().equals(numberOfHalls))
                .toList();

    }




}

package com.filadacreche.demo;

import com.filadacreche.demo.enums.Degree;
import com.filadacreche.demo.enums.DisabilityType;

import java.time.LocalDate;
import java.util.List;

public class teste {

    public static void main(String[] args) {

        String registrationNumber = "1232285225";

        String lima = registrationNumber.replaceAll("[^0-9]" , "");
        System.out.println(lima);


        String disabilityType = "NOTE";

        Degree[] degrees = Degree.values();
        for (Degree degree : degrees) {

            System.out.println(degree.toString().equals(disabilityType));
        }


    }
}
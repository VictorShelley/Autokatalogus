/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONArray;

/**
 *
 * @author PC
 */
public class convert {
    
    public static JSONArray StringToCar(String szoveg) {
        String szetszedve[] = szoveg.split("-",14);
        
        String brand = szetszedve[0];
        String modell = szetszedve[1];
        String kivitel = szetszedve[2];
        Integer evjarat = Integer.valueOf(szetszedve[3]);
        String alvaz = szetszedve[4];
        Integer motor = Integer.valueOf(szetszedve[5]);
        String uzemanyag = szetszedve[6];
        String szin = szetszedve[7];
        carEnum meghajtas = carEnum.valueOf(szetszedve[8]);
        String teljesitmeny = szetszedve[9];
        String henger = szetszedve[10];
        String fogyasztas = szetszedve[11];
        Integer ajtok = Integer.valueOf(szetszedve[12]);
        Integer ules = Integer.valueOf(szetszedve[13]);
        
        car temp = new car(brand,modell,kivitel,evjarat,alvaz,motor,uzemanyag,szin,meghajtas,teljesitmeny,henger,fogyasztas,ajtok,ules);
        JSONArray test = temp.toJsonArray();
        
        return test;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class car { //El kéne dönteni hogy akkor a van egy alap katalogus, és abből lehet kiválasztani
    //a kocsit, mert attól függ getter setter, szóval azt még nem raktam bele
    //Márka,Modell,Kivitel,Évjárat,Alvázszám,Motorszám,Üzemanyag,Szín,Meghajtás,Teljesítmény,Hengerűrtartalom,Fogyasztás,Ajtók száma, Ülések száma
    private String brand;
    private String modell;
    private String kivitel;
    private Integer evjarat;
    private Integer alvaz; //Check, hogy 17 jegyű?
    private Integer motor;
    private String uzemanyag;
    private String szin;
    private carEnum meghajtas;
    private String teljesitmeny;
    private String henger;
    private String fogyasztas;
    private Integer ajtok;
    private Integer ules;

    public car(String brand, String modell, String kivitel, Integer evjarat, Integer alvaz, Integer motor, String uzemanyag, String szin, carEnum meghajtas, String teljesitmeny, String henger, String fogyasztas, Integer ajtok, Integer ules) {
        this.brand = brand;
        this.modell = modell;
        this.kivitel = kivitel;
        this.evjarat = evjarat;
        this.alvaz = alvaz;
        this.motor = motor;
        this.uzemanyag = uzemanyag;
        this.szin = szin;
        this.meghajtas = meghajtas;
        this.teljesitmeny = teljesitmeny;
        this.henger = henger;
        this.fogyasztas = fogyasztas;
        this.ajtok = ajtok;
        this.ules = ules;
    }

    public String getBrand() {
        return brand;
    }

    public String getModell() {
        return modell;
    }

    public String getKivitel() {
        return kivitel;
    }

    public Integer getEvjarat() {
        return evjarat;
    }

    public Integer getAlvaz() {
        return alvaz;
    }

    public Integer getMotor() {
        return motor;
    }

    public String getUzemanyag() {
        return uzemanyag;
    }

    public String getSzin() {
        return szin;
    }

    public carEnum getMeghajtas() {
        return meghajtas;
    }

    public String getTeljesitmeny() {
        return teljesitmeny;
    }

    public String getHenger() {
        return henger;
    }

    public String getFogyasztas() {
        return fogyasztas;
    }

    public Integer getAjtok() {
        return ajtok;
    }

    public Integer getUles() {
        return ules;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }
    
}

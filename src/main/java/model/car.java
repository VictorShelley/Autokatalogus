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
    private String motor; //Integer? Check alvazzal?
    private String uzemanyag; //Enum?
    private String szin; //Enum?
    private String meghajtas; //Enum?
    private String teljesitmeny;
    private String henger;
    private String fogyasztas;
    private Integer ajtok;
    private Integer ules;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class user{//Mindenre állítottam getter, setter minden kivéve Szem szám, Szül idő (Gondolom ez a kettő változhat)
    //Név,Szemszám,Telefonszám,Email,Lakcím,Szül.idő
    private String name; //egybe/külön?
    private String id; //Személyi //Check(1./1,2,3,4 11.=(1.*1+2.*2...10.*10)/11)?
    private String phone; //check mennyi számjegy?
    private String email; //check @?
    private String cim; //Lakcím
    private Date szul;//Szül idő (int year,int month,int day)

    public user (String name, String id, String phone, String email, String cim, Date szul){
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.cim = cim;
        this.szul = szul;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCim() {
        return cim;
    }

    public Date getSzul() {
        return szul;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }
    
}

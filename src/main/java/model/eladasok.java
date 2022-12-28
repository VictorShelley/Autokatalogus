/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class eladasok {
    private Integer szem;
    private Integer alvaz;
    private Integer motor;

    public eladasok(Integer szem, Integer alvaz, Integer motor) {
        this.szem = szem;
        this.alvaz = alvaz;
        this.motor = motor;
    }

    public Integer getSzem() {
        return szem;
    }

    public Integer getAlvaz() {
        return alvaz;
    }

    public Integer getMotor() {
        return motor;
    }

    public void setSzem(Integer szem) {
        this.szem = szem;
    }

    public void setAlvaz(Integer alvaz) {
        this.alvaz = alvaz;
    }

    public void setMotor(Integer motor) {
        this.motor = motor;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author gabriel
 */
public class dtoHyS {
    
    @NotBlank
    private String name;
    @NotBlank
    private int percent;

    // constructor
    public dtoHyS() {
    }

    public dtoHyS(String name, int percent) {
        this.name = name;
        this.percent = percent;
    }
    
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    
    
}

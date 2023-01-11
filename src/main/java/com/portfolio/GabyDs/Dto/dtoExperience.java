/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperience {
    
    @NotBlank
    private String nameW;
    @NotBlank
    private String descriptionW;
    
    // Constructor

    public dtoExperience() {
    }

    public dtoExperience(String nameW, String descriptionW) {
        this.nameW = nameW;
        this.descriptionW = descriptionW;
    }
    
    // Getters and Setters

    public String getNameW() {
        return nameW;
    }

    public void setNameW(String nameW) {
        this.nameW = nameW;
    }

    public String getDescriptionW() {
        return descriptionW;
    }

    public void setDescriptionW(String descriptionW) {
        this.descriptionW = descriptionW;
    }
    
    
}

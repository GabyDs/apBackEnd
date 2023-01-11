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
public class dtoEducation {
    
    @NotBlank
    private String nameE;
    @NotBlank
    private String descriptionE;
    
    // Constructor

    public dtoEducation() {
    }

    public dtoEducation(String nameE, String descriptionE) {
        this.nameE = nameE;
        this.descriptionE = descriptionE;
    }
    
    // Getters and Setters

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
}

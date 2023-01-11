package com.portfolio.GabyDs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
    
    // table Experience
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameW;
    private String descriptionW;

    // Constructor
    public Experience() {
    }

    public Experience(String nameW, String descriptionW) {
        this.nameW = nameW;
        this.descriptionW = descriptionW;
    }
    
    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

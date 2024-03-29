package com.portfolio.GabyDs.Security.Entity;

import com.portfolio.GabyDs.Security.Enums.RolName;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;

    // constructor

    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolName = rolName;
    }
    
    // Getters Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolNombre() {
        return rolName;
    }

    public void setRolNombre(RolName rolName) {
        this.rolName = rolName;
    }
    
    
}

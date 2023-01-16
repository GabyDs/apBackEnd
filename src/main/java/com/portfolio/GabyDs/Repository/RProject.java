/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.GabyDs.Repository;

import com.portfolio.GabyDs.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */
@Repository
public interface RProject extends JpaRepository<Project, Integer> {
    public Optional<Project> findByName(String name);
    public boolean existsByName(String name);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.GabyDs.Repository;

import com.portfolio.GabyDs.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperience extends JpaRepository<Experience, Integer> {
    
    public Optional<Experience> findByNameW(String nameW);
    public boolean existsByNameW(String nameW);
    
}

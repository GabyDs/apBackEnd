/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Service;

import com.portfolio.GabyDs.Entity.Education;
import com.portfolio.GabyDs.Repository.REducation;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */

@Service
@Transactional
public class SEducation {
    
    @Autowired
    REducation rEducation;
    
    // create list with all experiences
    public List<Education> list(){
        return rEducation.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return rEducation.findById(id);
    }
    
    public Optional<Education> getByNameW(String nameE){
        return rEducation.findByNameE(nameE);
    }
    
    public void save(Education exp){
        rEducation.save(exp);
    }
    
    public void deleteById(int id){
        rEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    
    public boolean existsByNameE(String nameE){
        return rEducation.existsByNameE(nameE);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Service;

import com.portfolio.GabyDs.Entity.Experience;
import com.portfolio.GabyDs.Repository.RExperience;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperience {
    
    @Autowired
    RExperience rExperience;
    
    // create list with all experiences
    public List<Experience> list(){
        return rExperience.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return rExperience.findById(id);
    }
    
    public Optional<Experience> getByNameW(String nameW){
        return rExperience.findByNameW(nameW);
    }
    
    public void save(Experience exp){
        rExperience.save(exp);
    }
    
    public void deleteById(int id){
        rExperience.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperience.existsById(id);
    }
    
    public boolean existsByNameW(String nameW){
        return rExperience.existsByNameW(nameW);
    }
}

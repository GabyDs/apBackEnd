/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Service;

import com.portfolio.GabyDs.Entity.Project;
import com.portfolio.GabyDs.Repository.RProject;
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
public class SProject {
    @Autowired
    RProject rProject;
    
    // create list with all experiences
    public List<Project> list(){
        return rProject.findAll();
    }
    
    public Optional<Project> getOne(int id){
        return rProject.findById(id);
    }
    
    public Optional<Project> getByName(String name){
        return rProject.findByName(name);
    }
    
    public void save(Project person){
        rProject.save(person);
    }
    
    public void deleteById(int id){
        rProject.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProject.existsById(id);
    }
    
    public boolean existsByName(String name){
        return rProject.existsByName(name);
    }
}

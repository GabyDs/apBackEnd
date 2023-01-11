/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Controller;

import com.portfolio.GabyDs.Dto.dtoEducation;
import com.portfolio.GabyDs.Entity.Education;
import com.portfolio.GabyDs.Security.Controller.Mensaje;
import com.portfolio.GabyDs.Service.SEducation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducation {
    
    @Autowired
    SEducation sEducation;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        // valida si existe el id
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        
        sEducation.deleteById(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoedu){
        if(StringUtils.isBlank(dtoedu.getNameE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducation.existsByNameE(dtoedu.getNameE())){
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        }
        
        Education experience = new Education(dtoedu.getNameE(), dtoedu.getDescriptionE());
        sEducation.save(experience);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoedu){
        // valida si existe el id
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        // compara el nombre de la experiencia con una que ya existe
        if(sEducation.existsByNameE(dtoedu.getNameE()) && sEducation.getByNameW(dtoedu.getNameE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        // si no agrega nombre
        if(StringUtils.isBlank(dtoedu.getNameE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Education education = sEducation.getOne(id).get();
        education.setNameE(dtoedu.getNameE());
        education.setDescriptionE(dtoedu.getDescriptionE());
        
        sEducation.save(education);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
}

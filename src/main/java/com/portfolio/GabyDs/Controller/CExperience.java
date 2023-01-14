/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Controller;

import com.portfolio.GabyDs.Dto.dtoExperience;
import com.portfolio.GabyDs.Entity.Experience;
import com.portfolio.GabyDs.Security.Controller.Mensaje;
import com.portfolio.GabyDs.Service.SExperience;
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

@RestController
@RequestMapping("workExp")
@CrossOrigin(origins = "https://portfoliogabyds.web.app")
public class CExperience {
    
    @Autowired
    SExperience sExperience;
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!sExperience.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        
        Experience experience = sExperience.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = sExperience.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperience dtoexp){
        if(StringUtils.isBlank(dtoexp.getNameW())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sExperience.existsByNameW(dtoexp.getNameW())){
            return new ResponseEntity(new Mensaje("Esa experience existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = new Experience(dtoexp.getNameW(), dtoexp.getDescriptionW());
        sExperience.save(experience);
        
        return new ResponseEntity(new Mensaje("Exprience agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperience dtoexp){
        // valida si existe el id
        if(!sExperience.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        // compara el nombre de la experiencia con una que ya existe
        if(sExperience.existsByNameW(dtoexp.getNameW()) && sExperience.getByNameW(dtoexp.getNameW()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        // si no agrega nombre
        if(StringUtils.isBlank(dtoexp.getNameW())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = sExperience.getOne(id).get();
        experience.setNameW(dtoexp.getNameW());
        experience.setDescriptionW(dtoexp.getDescriptionW());
        
        sExperience.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        // valida si existe el id
        if(!sExperience.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sExperience.deleteById(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}

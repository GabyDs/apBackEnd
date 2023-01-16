/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GabyDs.Controller;

import com.portfolio.GabyDs.Dto.dtoProject;
import com.portfolio.GabyDs.Entity.Project;
import com.portfolio.GabyDs.Security.Controller.Mensaje;
import com.portfolio.GabyDs.Service.SProject;
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
// error CORS policy
@RequestMapping("/project")
@CrossOrigin(origins = {"https://portfoliogabyds01.web.app", "http://localhost:4200"})
public class CProject {
    @Autowired
    SProject sProject;
    
    @GetMapping("/list")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id){
        if(!sProject.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        
        Project project = sProject.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProject dtopro){
        if(StringUtils.isBlank(dtopro.getName())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProject.existsByName(dtopro.getName())){
            return new ResponseEntity(new Mensaje("Esa experience existe"), HttpStatus.BAD_REQUEST);
        }
        
        Project project = new Project(dtopro.getName(), dtopro.getDescription(), dtopro.getImg());
        sProject.save(project);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProject dtopro){
        // valida si existe el id
        if(!sProject.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        // compara el nombre de la experiencia con una que ya existe
        if(sProject.existsByName(dtopro.getName()) && sProject.getByName(dtopro.getName()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        // si no agrega nombre
        if(StringUtils.isBlank(dtopro.getName())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Project project = sProject.getOne(id).get();
        
        project.setName(dtopro.getName());
        project.setDescription(dtopro.getDescription());
        project.setImg(dtopro.getImg());
        
        sProject.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        // valida si existe el id
        if(!sProject.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sProject.deleteById(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}

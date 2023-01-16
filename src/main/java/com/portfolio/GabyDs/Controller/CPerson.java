package com.portfolio.GabyDs.Controller;

import com.portfolio.GabyDs.Dto.dtoPerson;
import com.portfolio.GabyDs.Entity.Person;
import com.portfolio.GabyDs.Security.Controller.Mensaje;
import com.portfolio.GabyDs.Service.SPerson;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// error CORS policy
@RequestMapping("/person")
@CrossOrigin(origins = {"https://portfoliogabyds01.web.app", "http://localhost:4200"})
public class CPerson {
    @Autowired 
    SPerson personService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list(){
        List<Person> list = personService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        if(!personService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        
        Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerson dtoper){
        // valida si existe el id
        if(!personService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        // compara el nombre de la experiencia con una que ya existe
        if(personService.existsByName(dtoper.getName()) && personService.getByName(dtoper.getName()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        // si no agrega nombre
        if(StringUtils.isBlank(dtoper.getName())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getOne(id).get();
        
        person.setName(dtoper.getName());
        person.setLastName(dtoper.getLastName());
        person.setDescription(dtoper.getDescription());
        person.setImg(dtoper.getImg());
        
        personService.save(person);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
}

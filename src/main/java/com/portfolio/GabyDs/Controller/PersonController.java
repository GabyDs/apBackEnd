package com.portfolio.GabyDs.Controller;

import com.portfolio.GabyDs.Entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.GabyDs.Interface.IPersonService;

@RestController
// error CORS policy
@CrossOrigin(origins = "https://portfoliogabyds.web.app")
public class PersonController {
    @Autowired IPersonService ipersonService;
    
    // ROL USUARIO
    @GetMapping("personas/traer")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPerson(@RequestBody Person person){
        ipersonService.savePerson(person);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePerson(@PathVariable Long id){
        ipersonService.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }
    
    // URL:PORT/personas/editar/id/nombre/apellido/img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Person editPerson(@PathVariable Long id,
                                @RequestParam("name") String newName,
                                @RequestParam("lastname") String newLastName,
                                @RequestParam("img") String newImg){
        Person person = ipersonService.findPerson(id);
        
        person.setName(newName);
        person.setLastName(newLastName);
        person.setImg(newImg);
        
        ipersonService.savePerson(person);
        
        return person;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Person findPerson(){
        return ipersonService.findPerson((long)1);
    }
    
}

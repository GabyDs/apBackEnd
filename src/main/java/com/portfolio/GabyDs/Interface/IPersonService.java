package com.portfolio.GabyDs.Interface;

import com.portfolio.GabyDs.Entity.Person;
import java.util.List;


public interface IPersonService {
    // Para traer una lista de personas
    public List<Person> getPerson();
    
    // Para guardar un objeto de tipo persona
    public void savePerson(Person person);
    
    // Eliminar un usuario buscando por ID
    public void deletePerson(Long id);
    
    // Buscar una persona por ID
    public Person findPerson(Long id);
}

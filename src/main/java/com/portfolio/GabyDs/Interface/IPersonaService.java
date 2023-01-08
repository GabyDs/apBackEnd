package com.portfolio.GabyDs.Interface;

import com.portfolio.GabyDs.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    // Para traer una lista de personas
    public List<Persona> getPersona();
    
    // Para guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    // Eliminar un usuario buscando por ID
    public void deletePersona(Long id);
    
    // Buscar una persona por ID
    public Persona findPersona(Long id);
}

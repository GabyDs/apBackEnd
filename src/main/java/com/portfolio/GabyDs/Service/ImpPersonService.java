package com.portfolio.GabyDs.Service;

import com.portfolio.GabyDs.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.portfolio.GabyDs.Repository.RPerson;

@Service
@Transactional
public class ImpPersonService {

    @Autowired RPerson ipersonRepository;
    
    // create list with all experiences
    public List<Person> list(){
        return ipersonRepository.findAll();
    }
    
    public Optional<Person> getOne(int id){
        return ipersonRepository.findById(id);
    }
    
    public Optional<Person> getByName(String name){
        return ipersonRepository.findByName(name);
    }
    
    public void save(Person person){
        ipersonRepository.save(person);
    }
    
    public void deleteById(int id){
        ipersonRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ipersonRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return ipersonRepository.existsByName(name);
    }
}

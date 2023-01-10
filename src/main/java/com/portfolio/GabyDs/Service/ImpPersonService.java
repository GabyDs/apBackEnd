package com.portfolio.GabyDs.Service;

import com.portfolio.GabyDs.Entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.GabyDs.Interface.IPersonService;
import com.portfolio.GabyDs.Repository.IPersonRepository;

@Service
public class ImpPersonService implements IPersonService{

    @Autowired IPersonRepository ipersonRepository;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = ipersonRepository.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = ipersonRepository.findById(id).orElse(null);
        return person;
    }
    
}

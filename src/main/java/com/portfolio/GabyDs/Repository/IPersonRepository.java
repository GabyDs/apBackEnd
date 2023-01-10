package com.portfolio.GabyDs.Repository;

import com.portfolio.GabyDs.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    
}

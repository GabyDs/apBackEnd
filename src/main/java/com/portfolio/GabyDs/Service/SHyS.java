package com.portfolio.GabyDs.Service;

import com.portfolio.GabyDs.Entity.HyS;
import com.portfolio.GabyDs.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */

@Transactional
@Service
public class SHyS {
    @Autowired
    RHyS rHyS;
    
    public List<HyS> list(){
        return rHyS.findAll();
    }
    
    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }
    
    public Optional<HyS> getByName(String name){
        return rHyS.findByName(name);
    }
    
    public void save(HyS skill){
        rHyS.save(skill);
    }
    
    public void delete(int id){
        rHyS.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHyS.existsById(id);
    }
    
    public boolean existsByName(String name){
        return rHyS.existsByName(name);
    }
}

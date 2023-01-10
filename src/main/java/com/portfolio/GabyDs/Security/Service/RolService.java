package com.portfolio.GabyDs.Security.Service;

import com.portfolio.GabyDs.Security.Entity.Rol;
import com.portfolio.GabyDs.Security.Enums.RolName;
import com.portfolio.GabyDs.Security.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository irolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return irolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}

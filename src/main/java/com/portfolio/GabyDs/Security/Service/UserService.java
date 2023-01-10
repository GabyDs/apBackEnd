package com.portfolio.GabyDs.Security.Service;

import com.portfolio.GabyDs.Security.Entity.User;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.GabyDs.Security.Repository.iUserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional<User> getByUserName(String userName){
        return iuserRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return iuserRepository.existsByUserName(userName);
    }
    
    public boolean existsByEmail(String email){
        return iuserRepository.existsByEmail(email);
    }
    
    public void save(User user){
        iuserRepository.save(user);
    }
}

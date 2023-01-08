package com.portfolio.GabyDs.Security.Repository;

import com.portfolio.GabyDs.Security.Entity.Rol;
import com.portfolio.GabyDs.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rol);
}

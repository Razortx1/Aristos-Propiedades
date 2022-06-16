package com.aristos_propiedades.aristos_propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristos_propiedades.aristos_propiedades.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
}

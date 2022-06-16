package com.aristos_propiedades.aristos_propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristos_propiedades.aristos_propiedades.model.Propiedades;

@Repository
public interface propiedadRepository extends JpaRepository<Propiedades, Integer>{
    
}

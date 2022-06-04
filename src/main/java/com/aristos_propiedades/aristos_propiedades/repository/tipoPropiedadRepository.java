package com.aristos_propiedades.aristos_propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aristos_propiedades.aristos_propiedades.model.TipoPropiedad;

public interface tipoPropiedadRepository extends JpaRepository<TipoPropiedad, Integer> {
    
}

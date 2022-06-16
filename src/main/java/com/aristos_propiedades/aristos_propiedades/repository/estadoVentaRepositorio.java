package com.aristos_propiedades.aristos_propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;

@Repository
public interface estadoVentaRepositorio extends JpaRepository<EstadoVentaArriendo, Integer>{
    
}

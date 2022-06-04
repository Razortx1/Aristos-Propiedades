package com.aristos_propiedades.aristos_propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aristos_propiedades.aristos_propiedades.model.EstadoVentaArriendo;

public interface estadoVentaRepositorio extends JpaRepository<EstadoVentaArriendo, Integer>{
    
}

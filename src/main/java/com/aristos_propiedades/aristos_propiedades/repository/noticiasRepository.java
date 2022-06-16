package com.aristos_propiedades.aristos_propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristos_propiedades.aristos_propiedades.model.Noticias;

@Repository
public interface noticiasRepository extends JpaRepository<Noticias, Integer>{
    
}

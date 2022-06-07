package com.aristos_propiedades.aristos_propiedades.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristos_propiedades.aristos_propiedades.model.Usuario;
@Repository
public interface IUsuarioJpaRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByNombre(String nombre);
    
}

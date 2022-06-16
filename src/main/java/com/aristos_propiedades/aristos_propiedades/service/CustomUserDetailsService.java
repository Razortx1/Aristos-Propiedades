package com.aristos_propiedades.aristos_propiedades.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aristos_propiedades.aristos_propiedades.model.CustomUsuarioDetails;
import com.aristos_propiedades.aristos_propiedades.model.Usuario;
import com.aristos_propiedades.aristos_propiedades.repository.IUsuarioJpaRepository;

public class CustomUserDetailsService  implements UserDetailsService{
    @Autowired
    private IUsuarioJpaRepository _Repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user = this._Repository.findByCorreo(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");

        }
        return new CustomUsuarioDetails(user);
    }
}

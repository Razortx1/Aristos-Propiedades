package com.aristos_propiedades.aristos_propiedades.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aristos_propiedades.aristos_propiedades.model.Usuario;
import com.aristos_propiedades.aristos_propiedades.repository.IUsuarioJpaRepository;

@Service
public class UsuarioService {
    @Autowired
    private IUsuarioJpaRepository _IUserJpaRepository;

    public Usuario createUser(Usuario user){
        return this._IUserJpaRepository.save(user);
    }

    public Usuario editUser(Integer id, Usuario user) throws Exception{
        Usuario u = this._IUserJpaRepository.findById(id).get();
        if(u == null){
            throw new Exception("El usuario no existe.");
        }
        u.setNombre(user.getNombre());
        u.setApellido(user.getApellido());
        return this._IUserJpaRepository.save(u);
    }

    public void deleteUser(Integer id){
        this._IUserJpaRepository.deleteById(id);
    }

    public Usuario getById(Integer id){
        return this._IUserJpaRepository.findById(id).get();
    }

    public Usuario getByEmail(String correo){
        return this._IUserJpaRepository.findByCorreo(correo);
    }

    public List<Usuario> getUsersByFilter(String filter){
        return this._IUserJpaRepository.findByCorreoOrNombreOrApellido(filter, filter, filter);

    }

    public List<Usuario> getAllUsers(){
        return this._IUserJpaRepository.findAll();
    }
}

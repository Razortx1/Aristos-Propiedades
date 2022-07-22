package com.aristos_propiedades.aristos_propiedades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.aristos_propiedades.aristos_propiedades.model.Propiedades;
import com.aristos_propiedades.aristos_propiedades.repository.propiedadRepository;

@Service
public class AristosService {
    @Autowired
    private propiedadRepository _PropiedadRepository;

    public Page<Propiedades> getPropiedadesByTipo(Integer filter){
        Page<Propiedades> page = new PageImpl<>(this._PropiedadRepository.findByIdtipopropiedad(filter));
        return page;
    }
}

package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.modelos.Personas;
import hn.unah.backend.repositorios.PersonasRepository;
import hn.unah.backend.servicios.PersonasService;

@Service

public class PersonasServiceImpl implements PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public Personas create(Personas personas) {
        //TODO: set rol
        return this.personasRepository.save(personas);
    }

    @Override
    public Personas get(int idPersona) {
        return this.personasRepository.findById(idPersona).get();
    }

    @Override
    public Personas update(int idPersona, Personas personas) {
        Personas personActualizar = this.personasRepository.findById(idPersona).get();
        if(personActualizar != null){
            personActualizar.setNombre(personas.getNombre());
            personActualizar.setApellido(personas.getApellido());
            personActualizar.setFoto(personas.getFoto());

            return this.personasRepository.save(personActualizar);
        }
        return null;
    }


    @Override
    public boolean delete(int idPersona) {
        Personas persona = this.personasRepository.findById(idPersona).get();
        if (persona != null) {
            this.personasRepository.delete(persona);
            return true;
        }
        return false; 
    }
    

    @Override
    public List<Personas> getAll() {
        return this.personasRepository.findAll();
    }
    
}

package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.repositorios.EquiposRepository;
import hn.unah.backend.servicios.EquiposService;

@Service
public class EquiposServiceImpl implements EquiposService{

    @Autowired
    private EquiposRepository equiposRepository;

    @Override
    public Equipos create(Equipos equipo) {
        return this.equiposRepository.save(equipo);
    }

    @Override
    public Equipos get(int idEquipo) {
        return this.equiposRepository.findById(idEquipo).get();
    }

    @Override
    public Equipos update(int idEquipo, Equipos equipo) {
        Equipos equipoActualizar = this.equiposRepository.findById(idEquipo).get();
        if(equipoActualizar != null){
            equipoActualizar.setNombre(equipo.getNombre());
            equipoActualizar.setAnioFundacion(equipo.getAnioFundacion());
            equipoActualizar.setPais(equipo.getPais());
            equipoActualizar.setUrllogo(equipo.getUrllogo());

            return this.equiposRepository.save(equipoActualizar);
        }
        return null;
    }

    @Override
    public boolean delete(int idEquipo) {
        Equipos equipoEliminar = this.equiposRepository.findById(idEquipo).get();
        if(equipoEliminar != null){
            this.equiposRepository.delete(equipoEliminar);
            return true;
        }
        return false;
    }

    @Override
    public List<Equipos> getAll() {
        return this.equiposRepository.findAll();
    }
    
}

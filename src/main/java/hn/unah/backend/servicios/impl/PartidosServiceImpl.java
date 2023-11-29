package hn.unah.backend.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Personas;
import hn.unah.backend.repositorios.PartidosRepository;
import hn.unah.backend.servicios.PartidosService;

@Service
public class PartidosServiceImpl  implements PartidosService{

    @Autowired
    private PartidosRepository partidosRepository;


    @Override
    public Partidos create(Partidos partidos) {
        return this.partidosRepository.save(partidos);
    }

    @Override
    public Partidos jugar(Equipos equipo1, Equipos equipo2) {
         throw new UnsupportedOperationException("Unimplemented method 'goles'");
    }

    @Override
    public Partidos goles(Equipos equipo, Personas persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goles'");
    }
    
}

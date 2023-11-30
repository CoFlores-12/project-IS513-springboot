package hn.unah.backend.servicios;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Partidos;



public interface PartidosService {
    
    public Partidos create( Partidos partidos);
    public Partidos jugar( Equipos equipo1 , Equipos equipo2);
    
    
}

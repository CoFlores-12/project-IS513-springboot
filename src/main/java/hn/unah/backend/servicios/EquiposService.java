package hn.unah.backend.servicios;

import java.util.List;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.FichajeJugador;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Torneos;

public interface EquiposService {
    
    public Equipos create(Equipos equipo, int id);

    public Equipos get(int idEquipo);

    public Equipos update(int idEquipo, Equipos equipo);

    public boolean delete(int idEquipo);

    public List<Equipos> getAll();

    public int getCount();

    public List<Partidos> getPartidos(int idEquipo);

    public List<FichajeJugador> getFichajes(int idEquipo);

    public Torneos getByEquipo(int idEquipo);
}   

package hn.unah.backend.servicios;

import java.util.List;

import hn.unah.backend.modelos.Equipos;

public interface EquiposService {
    
    public Equipos create(Equipos equipo);

    public Equipos get(int idEquipo);

    public Equipos update(int idEquipo, Equipos equipo);

    public boolean delete(int idEquipo);

    public List<Equipos> getAll();

}   

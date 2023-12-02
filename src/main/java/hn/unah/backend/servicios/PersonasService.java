package hn.unah.backend.servicios;

import java.util.List;

import hn.unah.backend.modelos.FichajeJugador;
import hn.unah.backend.modelos.Goles;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Personas;
import hn.unah.backend.modelos.PersonasDTO;
import hn.unah.backend.modelos.Rols;
import hn.unah.backend.modelos.TransfersDTO;

public interface PersonasService {
    public Personas create(PersonasDTO personas);
    public Personas get(int idPersona);
    public Personas update(int idPersona, Personas personas);
    public boolean delete(int idPersona);
    public List<Personas> getAll();
    public List<Personas> getByEquipo(int idEquipo);
    public int getCount();
    public List<Goles> getGoles(int id);
    public List<Partidos> getPartidos(int id);
    public List<FichajeJugador> getFichajes(int id);
    public List<Rols> getRoles();
    public FichajeJugador transferir(TransfersDTO trasnferir);
}
 
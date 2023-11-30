package hn.unah.backend.servicios;

import java.util.List;

import hn.unah.backend.modelos.Personas;
import hn.unah.backend.modelos.Rols;

public interface PersonasService {
    public Personas create(Personas personas, int rols);
    public Personas get(int idPersona);
    public Personas update(int idPersona, Personas personas);
    public boolean delete(int idPersona);
    public List<Personas> getAll();
    public List<Personas> getByEquipo(int idEquipo);
    public int getCount();
}
 
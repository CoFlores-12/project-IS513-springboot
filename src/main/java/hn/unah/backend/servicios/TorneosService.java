package hn.unah.backend.servicios;

import java.util.List;

import hn.unah.backend.modelos.Clasificatoria;
import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Torneos;

public interface TorneosService {
    public List<Torneos> getAll();
    public Torneos get(int id);
    public Torneos create(Torneos torneo);
    public Torneos update(Torneos torneo);
    public Boolean delete(int id);
    public List<Clasificatoria> equiposClasificatoria(int id);
    public List<Partidos> getPartidos(int id);
    public List<Equipos> getEquipos(int id);
    public Equipos jugar(int idtorneo);
}

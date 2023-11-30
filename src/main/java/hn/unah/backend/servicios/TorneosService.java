package hn.unah.backend.servicios;

import java.util.List;

import hn.unah.backend.modelos.Torneos;

public interface TorneosService {
    public List<Torneos> getAll();
    public Torneos get(int id);
    public Torneos create(Torneos torneo);
    public Torneos update(Torneos torneo);
    public Boolean delete(int id);
    
    public Torneos jugar(int idtorneo);
}

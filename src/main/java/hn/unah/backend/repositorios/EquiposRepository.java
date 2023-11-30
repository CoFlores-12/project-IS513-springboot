package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hn.unah.backend.modelos.Equipos;


public interface EquiposRepository extends JpaRepository<Equipos, Integer>{
    @Query //TODO: query custom
    public Equipos findByGrupoYTorneo(int idTorneo,String grupo);
}

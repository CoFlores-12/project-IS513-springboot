package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Torneos;

import java.util.List;


public interface PartidosRepository  extends JpaRepository<Partidos, Integer>{
    List<Partidos> findByEquipo1OrEquipo2(Equipos equipo1, Equipos equipo2);
    List<Partidos> findByTorneo(Torneos torneo);
}

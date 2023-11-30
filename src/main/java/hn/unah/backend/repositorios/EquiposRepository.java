package hn.unah.backend.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Torneos;


public interface EquiposRepository extends JpaRepository<Equipos, Integer>{
    List<Equipos> findByTorneo(Torneos torneo);
}

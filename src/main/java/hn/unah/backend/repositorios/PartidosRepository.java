package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Partidos;

public interface PartidosRepository  extends JpaRepository<Partidos, Integer>{
    
}

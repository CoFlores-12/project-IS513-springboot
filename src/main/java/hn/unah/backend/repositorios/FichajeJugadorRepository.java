package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.FichajeJugador;

public interface FichajeJugadorRepository extends JpaRepository <FichajeJugador, Integer> {
    
}

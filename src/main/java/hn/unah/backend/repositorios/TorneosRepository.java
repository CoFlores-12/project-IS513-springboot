package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Torneos;

public interface TorneosRepository extends JpaRepository<Torneos, Integer> {
    
}

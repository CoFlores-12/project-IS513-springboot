package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Goles;

public interface Golesrepository extends JpaRepository<Goles, Integer> {
    
}

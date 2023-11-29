package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Personas;

public interface PersonasRepository extends JpaRepository <Personas, Integer> {

    

    
}

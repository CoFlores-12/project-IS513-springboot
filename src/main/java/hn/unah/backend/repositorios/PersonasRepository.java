package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Personas;
import java.util.List;


public interface PersonasRepository extends JpaRepository <Personas, Integer> {
    //List<Personas> findByIdequipo(int idequipo);
    

    
}

 
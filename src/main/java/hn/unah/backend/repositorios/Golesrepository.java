package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Goles;
import hn.unah.backend.modelos.Personas;

import java.util.List;


public interface Golesrepository extends JpaRepository<Goles, Integer> {
    List<Goles> findByPersona(Personas persona);
}

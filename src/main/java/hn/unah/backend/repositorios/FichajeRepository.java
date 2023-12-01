package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.FichajeJugador;
import java.util.List;


public interface FichajeRepository extends JpaRepository<FichajeJugador, Integer> {
    List<FichajeJugador> findByIdequipoinOrIdequipoout(Equipos idequipoin, Equipos idequipoout);
}

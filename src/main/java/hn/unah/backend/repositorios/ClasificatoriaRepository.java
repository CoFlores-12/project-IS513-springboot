package hn.unah.backend.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Clasificatoria;

public interface ClasificatoriaRepository extends JpaRepository<Clasificatoria, Integer> {
    List<Clasificatoria> findByIdtorneo(int idtorneo);
}

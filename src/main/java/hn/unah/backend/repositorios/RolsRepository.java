package hn.unah.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.backend.modelos.Rols;

public interface RolsRepository extends JpaRepository<Rols, Integer> {
    
}

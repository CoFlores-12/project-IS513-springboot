package hn.unah.backend.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Rols {
    @Id
    private int id;

    private String descripcion;
//@OneToMany
//private list<personas> personas;
}
//relaciones en los modelos
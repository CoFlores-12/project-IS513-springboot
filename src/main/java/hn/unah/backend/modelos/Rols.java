package hn.unah.backend.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrol")
    private int idrol;

    private String descripcion;
    
    @OneToMany(mappedBy ="idpersona")
    private List<Personas> idpersona;

 
}
//relaciones en los modelos
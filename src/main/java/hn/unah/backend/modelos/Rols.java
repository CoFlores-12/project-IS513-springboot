package hn.unah.backend.modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rols")
@Entity
public class Rols {
    @Id
    @Column(name="idrol")
    private int idrol;

    private String descripcion;

}

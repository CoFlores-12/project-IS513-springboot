package hn.unah.backend.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="personas")
public class Personas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idpersona")
    private int idpersona;

    private String nombre;
    
    private String apellido;
    
    private String foto;

    private String fecha;
    //@ManyToOne(mappedBy = "personas")
    //TODO relationship between personas and rols
    private int idrol;

    //TODO relationship between personas and transfers
    
    private int idequipo;
    
}

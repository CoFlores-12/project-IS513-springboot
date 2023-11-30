package hn.unah.backend.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name="idrol")
    private Rols idrol;
    
}

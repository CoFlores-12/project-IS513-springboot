package hn.unah.backend.modelos;



import com.fasterxml.jackson.annotation.JsonIgnore;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="personas")
@Entity
public class Personas {
    
    @Id
    @Column(name="idpersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;
    
    private String nombre;
    private String apellido;

    private String foto;

@JsonIgnore
    @ManyToOne
    @JoinColumn(name="idrol",referencedColumnName = "idRol")
    private Rols idrol;


}

package hn.unah.backend.modelos;

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
    //@column(name=id)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nombre;
    
    private String apellido;
    
    private String foto;
    //@ManyToOne(mappedBy = "personas")
    private int idRol;
    
    
}

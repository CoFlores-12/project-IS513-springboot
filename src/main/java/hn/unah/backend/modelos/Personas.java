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
public class Personas {
    @Id
    private int id;

    private String nombre;
    
    private String apellido;
    
    private String foto;
    
    private int idRol;
    
    
}

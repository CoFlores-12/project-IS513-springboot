package hn.unah.backend.modelos;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="torneos")
public class Torneos {
    @Id
    private int idtorneo;

    private String nombre;

    private String informacion;

    private int estado;

    private String fecha;

    private String logo;

    @OneToMany
    private List<Equipos> equipos;
    


    
}

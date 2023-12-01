package hn.unah.backend.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Clasificatoria {
     @Id
     private int id;

     private int  idtorneo;

     private int posicion;

     @OneToOne
     @JoinColumn(name = "idequipo", referencedColumnName = "idequipo")
     private Equipos equipo;
     

}

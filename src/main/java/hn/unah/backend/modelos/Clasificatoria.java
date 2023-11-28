package hn.unah.backend.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
     
     private int grupo;


}

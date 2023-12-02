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
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Goles {
    @Id
    private int id;
    
    @OneToOne
    @JoinColumn(name = "idpartido", referencedColumnName = "idpartido")
    private Partidos partido;

    @OneToOne
    @JoinColumn(name = "idequipo", referencedColumnName = "idequipo")
    private Equipos equipo;


    @OneToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private Personas persona;

    
}

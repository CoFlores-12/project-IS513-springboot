package hn.unah.backend.modelos;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

@Entity
@Table(name="equiposdeltorneo")
public class EquiposdelTorneo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private int puntos;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idtorneo", referencedColumnName="idtorneo")
    private Torneos torneo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idequipo", referencedColumnName="idequipos")
    private Equipos equipo;

}

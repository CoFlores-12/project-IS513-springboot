package hn.unah.backend.modelos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@AllArgsConstructor
@NoArgsConstructor

@Table(name="partidos")
@Entity
public class Partidos {
    
    @Id
    @Column(name="idpartido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpartido;

    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fecha;

    
    private int golesequipo1;
    
    private int golesequipo2;


    @ManyToOne
    @JoinColumn(name="idtorneo", referencedColumnName="idtorneo")
    private Torneos torneo;

    @ManyToOne
    @JoinColumn(name="idequipo1", referencedColumnName="idequipo")
    private Equipos equipo1;

    
    @ManyToOne
    @JoinColumn(name="idequipo2", referencedColumnName="idequipo")
    private Equipos equipo2;
    
     @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ganador", referencedColumnName="idequipo")
    private Equipos ganador;
    

}

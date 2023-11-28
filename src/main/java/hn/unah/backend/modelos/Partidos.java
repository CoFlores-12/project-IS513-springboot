package hn.unah.backend.modelos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private int idaprtido;

    
    @JoinColumn(name="idtorneo")
    private int idtorneo;

    @JsonFormat(pattern="YYYY-MM-DD")
    private Date fecha;

    @JoinColumn(name="idequipo1")
    private int idequipo1;
    
    @JoinColumn(name="idequipo2")
    private int idequipo2;
    

    private int golesequipo1;
    
    private int golesequipo2;

    private int ganador;

}

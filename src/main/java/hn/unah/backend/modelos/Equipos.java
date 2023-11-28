package hn.unah.backend.modelos;

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

@Entity
@Table(name="equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipos {
    
    @Id
    @Column(name="idequipos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipo;

    private String nombre;

    @Column(name="aniofundacion")
    private String anioFundacion;

    private String pais;

    private String escudo;

    @ManyToOne
    @JoinColumn(name="idtorneo")
    private Torneos torneos;

    

}

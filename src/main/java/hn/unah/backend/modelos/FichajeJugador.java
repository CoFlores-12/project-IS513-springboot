package hn.unah.backend.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="fichajejugador")
@Entity
public class FichajeJugador {
    @Id
    @Column(name="idfichaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfichaje;
    

    @OneToOne
    @JoinColumn(name="idpersona")
    private Personas idpPersonas;

    @OneToOne
    @JoinColumn(name="idequipoin")
    private Equipos idequipoin;
    
    @OneToOne
    @JoinColumn(name="idequipoout")
    private Equipos idequipoout;


}

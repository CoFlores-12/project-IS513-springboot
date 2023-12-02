package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.repositorios.ClasificatoriaRepository;
import hn.unah.backend.repositorios.EquiposRepository;
import hn.unah.backend.repositorios.Golesrepository;
import hn.unah.backend.repositorios.TorneosRepository;
import hn.unah.backend.modelos.Clasificatoria;
import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Goles;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Personas;
import hn.unah.backend.modelos.Torneos;
import hn.unah.backend.servicios.TorneosService;

@Service
public class TorneosServiceImpl implements TorneosService {
    
    @Autowired
    private TorneosRepository torneosRepository;
    
    // @Autowired
     //private PersonasRepository personasRepository;

     @Autowired
     private Golesrepository golesrepository;
    @Autowired
    private EquiposRepository equiposRepository;

    @Autowired
    private ClasificatoriaRepository clasificatoriaRepository;


    @Override
    public List<Torneos> getAll() {
        return this.torneosRepository.findAll();
    }

    @Override
    public Torneos create(Torneos torneo) {
        return this.torneosRepository.save(torneo);
    }

    @Override
    public Torneos get(int id) {
        return this.torneosRepository.findById(id).get();
    }

    @Override
    public Boolean delete(int id) {
        Torneos torneo = this.torneosRepository.findById(id).get();
        if (torneo != null) {
            this.torneosRepository.delete(torneo);
            return true;
        }
        return false;
    }

    @Override
    public Torneos update(Torneos torneo) {
        this.torneosRepository.save(torneo);
        return torneo;
    }


   
   

    @Override
    public Torneos jugar(int idtorneo) {
        Torneos torneo = this.torneosRepository.findById(idtorneo).get();
        List<Equipos> equipos = this.equiposRepository.findByTorneo(torneo);

        Equipos equipoGrupoA1 = null;
        Equipos equipoGrupoA2 = null;

        Equipos equipoGrupoB1 = null;
        Equipos equipoGrupoB2 = null;

        Equipos equipoGrupoC1 = null;
        Equipos equipoGrupoC2 = null;

        Equipos equipoGrupoD1 = null;
        Equipos equipoGrupoD2 = null;
       
        
       for (Equipos equipo : equipos) {
        switch (equipo.getGrupo()) {
            case "A1" :
                equipoGrupoA1 = equipo;
                break;
            case "A2" :
                equipoGrupoA2 = equipo;
                break;
            case "B1" :
                equipoGrupoB1 = equipo;
                break;
            case "B2" :
                equipoGrupoB2 = equipo;
                break;
            case "C1" :
                equipoGrupoC1 = equipo;
                break;
            case "C2" :
                equipoGrupoC2 = equipo;
                break;
            case "D1" :
                equipoGrupoD1 = equipo;
                break;
            case "D2" :
                equipoGrupoD2 = equipo;
                break;
        
            default:
                break;
        }
       }

       if (equipoGrupoA1 != null && equipoGrupoA2 != null) {
        int golesA1 = (int) (Math.random()*7);
        int golesA2 = (int) (Math.random()*7);
        while (golesA1 == golesA2) {
            golesA2 = (int) (Math.random()*7);
        }
        Partidos partidosA1A2 = new Partidos();
        Clasificatoria clasificatoria = new Clasificatoria();
        //TODO set torneo to clasificatoria
        partidosA1A2.setEquipo1(equipoGrupoA1);
        partidosA1A2.setEquipo2(equipoGrupoA2);
        partidosA1A2.setGolesequipo1(golesA1);
        partidosA1A2.setGolesequipo2(golesA2);
        partidosA1A2.setTorneo(torneo);
        if (golesA1 > golesA2) {
            partidosA1A2.setGanador(equipoGrupoA1);
            equipoGrupoA1.setPuntos(equipoGrupoA1.getPuntos()+3);
            //TODO get all jugadores del equipo
           List<Personas> jugadores = null;
            for (int index = 0; index < golesA1; index++) {
                Goles gol = new Goles();
                //gol.setIdequipo1(equipoGrupoA1);
                //gol.setIdpartido(partidosA1A2);
                //gol.setIdpersona(jugadores.get((int) Math.random(jugadores.size()-1)));
                //TODO save Gol
            }
            this.equiposRepository.save(equipoGrupoA1);
            //TODO set equipo to clasificatoria and position to 9
        }else{ 
            partidosA1A2.setGanador(equipoGrupoA2);
            equipoGrupoA2.setPuntos(equipoGrupoA2.getPuntos()+3);
            this.equiposRepository.save(equipoGrupoA2);
            //TODO get players
           List<Personas> jugadores = null;
            for (int index = 0; index < golesA2; index++) {
                Goles gol = new Goles();
               // gol.setIdequipo1(equipoGrupoA2);
                //gol.setIdpartido(partidosA1A2);
                //gol.setIdpersona(jugadores.get((int) Math.random(jugadores.size()-1)));
                //TODO save gol
            }
            //TODO set equipo to clasificatoria and position to 9
        }

        //TODO: clasisificatoria save
        //TODO: save partidoA1A2
       }
       if (equipoGrupoA1 == null && equipoGrupoA2 != null) {
            //TODO clasificatoria donde A2 pasa a posicion 9 and increment points 
       }if (equipoGrupoA2 == null && equipoGrupoA1 != null) {
            //TODO clasificatoria donde A1 pasa a posicion 9 and increment points 
       }if (equipoGrupoA1 == null && equipoGrupoA2 == null) {
            //TODO clasificatoria posicion 9 is null
       }

        return torneo;
    }

    @Override
    public List<Clasificatoria> equiposClasificatoria(int id) {
        List<Clasificatoria> clasificatorias = this.clasificatoriaRepository.findByIdtorneo(id);

        return clasificatorias;
    }
    
}

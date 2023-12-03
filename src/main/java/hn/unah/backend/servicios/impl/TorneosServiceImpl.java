package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.repositorios.ClasificatoriaRepository;
import hn.unah.backend.repositorios.EquiposRepository;
import hn.unah.backend.repositorios.Golesrepository;
import hn.unah.backend.repositorios.PartidosRepository;
import hn.unah.backend.repositorios.PersonasRepository;
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
    
    @Autowired
    private PersonasRepository personasRepository;

     @Autowired
     private Golesrepository golesrepository;
    @Autowired
    private EquiposRepository equiposRepository;

    @Autowired
    private ClasificatoriaRepository clasificatoriaRepository;

    @Autowired
    private PartidosRepository partidosRepository;


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
    public Equipos jugar(int idtorneo) {
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

       Equipos sm1 = this.getWinner(equipoGrupoA1, equipoGrupoA2, torneo, 9);
       Equipos sm2 = this.getWinner(equipoGrupoB1, equipoGrupoB2, torneo, 10);
       Equipos sm3 = this.getWinner(equipoGrupoC1, equipoGrupoC2, torneo, 11);
       Equipos sm4 = this.getWinner(equipoGrupoD1, equipoGrupoD2, torneo, 12);

       Equipos f1 = this.getWinner(sm1, sm2, torneo, 13);
       Equipos f2 = this.getWinner(sm3, sm4, torneo, 14);

       torneo.setEstado(0);
       this.torneosRepository.save(torneo);
        return this.getWinner(f1, f2, torneo, 15);
    }

    private Equipos getWinner(Equipos equipo1, Equipos equipo2, Torneos torneo, int posicion){
        Clasificatoria clasificatoria = new Clasificatoria();
        Equipos winner = null;
        if (equipo1 != null && equipo2 != null) {
            Partidos partidosA1A2 = new Partidos();
            int golesA2 = (int) (Math.random()*7);
            int golesA1 = (int) (Math.random()*7);
            while (golesA1 == golesA2) {
                golesA1 = (int) (Math.random()*7);
                golesA2 = (int) (Math.random()*7);
            }
            partidosA1A2.setEquipo1(equipo1);
            partidosA1A2.setEquipo2(equipo2);
            partidosA1A2.setGolesequipo1(golesA1);
            partidosA1A2.setGolesequipo2(golesA2);
            partidosA1A2.setTorneo(torneo);
            if (golesA1 > golesA2) {
                partidosA1A2.setGanador(equipo1);
                equipo1.setPuntos(equipo1.getPuntos()+3);
                
                this.equiposRepository.save(equipo1);
                clasificatoria.setEquipo(equipo1);
                winner =equipo1;
            }else{ 
                partidosA1A2.setGanador(equipo2);
                equipo2.setPuntos(equipo2.getPuntos()+3);
                
                this.equiposRepository.save(equipo2);
                clasificatoria.setEquipo(equipo2);
                winner = equipo2;
            }

            clasificatoria.setIdtorneo(torneo.getIdtorneo());
            clasificatoria.setPosicion(posicion);
            this.clasificatoriaRepository.save(clasificatoria);
            this.partidosRepository.save(partidosA1A2);
            List<Personas> jugadores = this.personasRepository.findByIdequipo(equipo2);
                for (int index = 0; index < golesA2; index++) {
                    Goles gol = null;
                    gol = new Goles();
                    gol.setEquipo(equipo2);
                    gol.setPartido(partidosA1A2);
                    gol.setPersona(jugadores.get((int)(Math.random()*(jugadores.size()-1))));
                    this.golesrepository.save(gol);
                }
            jugadores = this.personasRepository.findByIdequipo(equipo1);
            for (int index = 0; index < golesA1; index++) {
                    Goles gol2 = null;
                    gol2 = new Goles();
                    gol2.setEquipo(equipo1);
                    gol2.setPartido(partidosA1A2);
                    gol2.setPersona(jugadores.get((int)(Math.random()*(jugadores.size()-1))));
                    this.golesrepository.save(gol2);
                }
            return winner;
        }
        if (equipo1 == null && equipo2 != null) {
                clasificatoria.setEquipo(equipo2);
                clasificatoria.setIdtorneo(torneo.getIdtorneo());
                clasificatoria.setPosicion(posicion);
                this.clasificatoriaRepository.save(clasificatoria);
                winner = equipo2;
                return winner;
        }if (equipo1 == null && equipo2 != null) {
                clasificatoria.setEquipo(equipo1);
                clasificatoria.setIdtorneo(torneo.getIdtorneo());
                clasificatoria.setPosicion(posicion);
                this.clasificatoriaRepository.save(clasificatoria);
                winner = equipo1;
                return winner;
        }if (equipo1 == null && equipo2 == null) {
                return winner;
        }
        return winner;
    }

    @Override
    public List<Clasificatoria> equiposClasificatoria(int id) {
        List<Clasificatoria> clasificatorias = this.clasificatoriaRepository.findByIdtorneo(id);

        return clasificatorias;
    }

    @Override
    public List<Partidos> getPartidos(int id) {
        Torneos torneo = this.torneosRepository.findById(id).get();
        return this.partidosRepository.findByTorneo(torneo);
    }

    @Override
    public List<Equipos> getEquipos(int id) {
        Torneos torneo = this.torneosRepository.findById(id).get();
        return this.equiposRepository.findByTorneoOrderByPuntosDesc(torneo);
    }
    
}

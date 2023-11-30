package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.repositorios.EquiposRepository;
import hn.unah.backend.repositorios.EquiposdelTorneoRepository;
import hn.unah.backend.repositorios.TorneosRepository;
import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.EquiposdelTorneo;
import hn.unah.backend.modelos.EquiposdelTorneoDTO;
import hn.unah.backend.modelos.Torneos;
import hn.unah.backend.servicios.TorneosService;

@Service
public class TorneosServiceImpl implements TorneosService {
    
    @Autowired
    private TorneosRepository torneosRepository;
    
    @Autowired
    private EquiposdelTorneoRepository equiposdelTorneoRepository;
    
    @Autowired
    private EquiposRepository equiposRepository;


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
    public EquiposdelTorneo add(EquiposdelTorneoDTO equiposdelTorneoDTO) {
        Equipos equipo= this.equiposRepository.findById(equiposdelTorneoDTO.idequipo).get();
        Torneos torneo= this.torneosRepository.findById(equiposdelTorneoDTO.idtorneo).get();
        if(equipo==null && torneo==null){
            return null;
        }
        EquiposdelTorneo equiposdelTorneo = new EquiposdelTorneo();
        equiposdelTorneo.setPuntos(0);
        equiposdelTorneo.setEquipo(equipo);
        equiposdelTorneo.setTorneo(torneo);

        return this.equiposdelTorneoRepository.save(equiposdelTorneo);
        
    }

    @Override
    public Torneos jugar(int idtorneo) {

        Equipos equipoGrupoA1 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "A1");
        Equipos equipoGrupoA2 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "A2");

        Equipos equipoGrupoB1 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "B1");
        Equipos equipoGrupoB2 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "B2");

        Equipos equipoGrupoC1 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "C1");
        Equipos equipoGrupoC2 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "C2");
        Equipos equipoGrupoD1 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "D1");
        Equipos equipoGrupoD2 = this.equiposRepository.findByGrupoYTorneo(idtorneo, "D2");



        return this.torneosRepository.findById(idtorneo).get();
    }
    
}

/*
 * 
  public String reservar(ReservaDTO reserva) {
 *      Cliente cliente = this.clienteRepository.findById(equiposdelTorneo.getidCliente()).get();
        Vehiculo vehiculo = this.vehiculoRepository.findById(reserva.getidVehiculo()).get();
        if (cliente == null) {
            return "Cliente no existe";
        }
        if (vehiculo == null) {
            return "vehiculo no existe";
        }

        reservaDB.setIdcliente(clirnte.getidCliente());
        reservaDB.setIdvehiculo(vehiculo.getidVehiculo());
        reservaDB.setDias(reserva.getDias());
        reservaDB.setTotal((reserva.getDias() * vehiculo.getIdTipoVehiculo().getPrecioXHora()));
        this.reservaRepository.save(reservaDB);


        return "Reserva Realizada";
 */
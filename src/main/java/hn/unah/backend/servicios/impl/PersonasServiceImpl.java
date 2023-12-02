package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.FichajeJugador;
import hn.unah.backend.modelos.Goles;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Personas;
import hn.unah.backend.modelos.PersonasDTO;
import hn.unah.backend.modelos.Rols;
import hn.unah.backend.modelos.TransfersDTO;
import hn.unah.backend.repositorios.EquiposRepository;
import hn.unah.backend.repositorios.FichajeRepository;
import hn.unah.backend.repositorios.Golesrepository;
import hn.unah.backend.repositorios.PartidosRepository;
import hn.unah.backend.repositorios.PersonasRepository;
import hn.unah.backend.repositorios.RolsRepository;
import hn.unah.backend.servicios.PersonasService;

@Service
public class PersonasServiceImpl implements PersonasService {

    @Autowired
    private PersonasRepository personasRepository;
    @Autowired
    private RolsRepository rolsRepository;
    @Autowired
    private EquiposRepository equiposRepository;
    @Autowired
    private Golesrepository golesrepository;
    @Autowired
    private PartidosRepository partidosRepository;
    @Autowired
    private FichajeRepository fichajeJugador;

    @Override
    public Personas create(PersonasDTO personas) {
        Personas personaSave = new Personas();
        Equipos equipo = this.equiposRepository.findById(personas.idequipo).get();
        Rols rol = this.rolsRepository.findById(personas.idrol).get();
        personaSave.setNombre(personas.nombre);
        personaSave.setApellido(personas.apellido);
        personaSave.setFecha(personas.fecha);
        personaSave.setFoto(personas.foto);
        personaSave.setIdequipo(equipo);
        personaSave.setIdrol(rol);
        return this.personasRepository.save(personaSave);
    }

    @Override
    public Personas get(int idPersona) {
        return this.personasRepository.findById(idPersona).get();
    }

    @Override
    public Personas update(int idPersona, Personas personas) {
        Personas personActualizar = this.personasRepository.findById(idPersona).get();
        if(personActualizar != null){
            personActualizar.setNombre(personas.getNombre());
            personActualizar.setApellido(personas.getApellido());
            personActualizar.setFoto(personas.getFoto());

            return this.personasRepository.save(personActualizar);
        }
        return null;
    }


    @Override
    public boolean delete(int idPersona) {
        Personas persona = this.personasRepository.findById(idPersona).get();
        if (persona != null) {
            this.personasRepository.delete(persona);
            return true;
        }
        return false; 
    }
    

    @Override
    public List<Personas> getAll() {
        return this.personasRepository.findAll();
    }

    @Override
    public int getCount() {
        List<Personas> people = this.personasRepository.findAll();
        return people.size();
    }

    @Override
    public List<Personas> getByEquipo(int idEquipo) {
        Equipos equipo = this.equiposRepository.findById(idEquipo).get();
        return this.personasRepository.findByIdequipo(equipo);
    }

    @Override
    public List<Goles> getGoles(int id) {
        Personas persona = this.personasRepository.findById(id).get();
        return this.golesrepository.findByPersona(persona);
    }

    @Override
    public List<Partidos> getPartidos(int id) {
        Personas persona = this.personasRepository.findById(id).get();
        Equipos equipo = this.equiposRepository.findById(persona.getIdequipo().getIdEquipo()).get();
        return this.partidosRepository.findByEquipo1OrEquipo2(equipo, equipo);
    }

    @Override
    public List<FichajeJugador> getFichajes(int id) {
        Personas persona = this.personasRepository.findById(id).get();
        return this.fichajeJugador.findByIdpersona(persona);
    }

    @Override
    public List<Rols> getRoles() {
        return this.rolsRepository.findAll();
    }

    @Override
    public FichajeJugador transferir(TransfersDTO trasnferir) {
        Personas persona = this.personasRepository.findById(trasnferir.idpersona).get();
        Equipos equipo = this.equiposRepository.findById(trasnferir.idequipoout).get();
        Equipos equipo2 = this.equiposRepository.findById(trasnferir.idequipoin).get();
        persona.setIdequipo(equipo2);
        this.personasRepository.save(persona);
        FichajeJugador fichaje = new FichajeJugador();
        fichaje.setIdequipoin(equipo2);
        fichaje.setIdequipoout(equipo);
        fichaje.setIdpersona(persona);
        fichaje.setPrecio(trasnferir.precio);
        this.fichajeJugador.save(fichaje);
        return fichaje;
    }
    
}

 
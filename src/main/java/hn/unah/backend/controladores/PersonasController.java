package hn.unah.backend.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.backend.modelos.FichajeJugador;
import hn.unah.backend.modelos.Goles;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Personas;
import hn.unah.backend.modelos.PersonasDTO;
import hn.unah.backend.modelos.Rols;
import hn.unah.backend.modelos.TransfersDTO;
import hn.unah.backend.servicios.impl.PersonasServiceImpl;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {
    @Autowired
    private PersonasServiceImpl personasServiceImpl;
    

    @GetMapping("/")
    public List<Personas> getAll(){
        return this.personasServiceImpl.getAll();
    }

    @GetMapping("/get/{id}")
    public Personas get(@PathVariable int id){
        return this.personasServiceImpl.get(id);
    }

    @GetMapping("/goles/{id}")
    public List<Goles> getGoles(@PathVariable int id){
        return this.personasServiceImpl.getGoles(id);
    }
     @GetMapping("/getRoles")
    public List<Rols> getRoles(){
        return this.personasServiceImpl.getRoles();
    }

    @GetMapping("/partidos/{id}")
    public List<Partidos> getPArtidos(@PathVariable int id){
        return this.personasServiceImpl.getPartidos(id);
    }

    @PostMapping("/transferir")
    public FichajeJugador crear(@RequestBody TransfersDTO transferir){
        return this.personasServiceImpl.transferir(transferir);
    }

    @GetMapping("/transfers/{id}")
    public List<FichajeJugador> getTransfers(@PathVariable int id){
        return this.personasServiceImpl.getFichajes(id);
    }

    @PostMapping("/crear")
    public Personas crear(@RequestBody PersonasDTO persona){
        return this.personasServiceImpl.create(persona);
    }
    @GetMapping("/getByEquipo/{idEquipo}")
    public List<Personas> getAll(@PathVariable int idEquipo) {
        return this.personasServiceImpl.getByEquipo(idEquipo);
    }
    @GetMapping("/getCount")
    public int getCount(){
        return this.personasServiceImpl.getCount();
    }
       @DeleteMapping("/delete/personas")
    public Boolean delete(@PathVariable int id){
        return this.personasServiceImpl.delete(id);
    }
     /*
      * @PostMapping("/update/persona")
    public Personas crear(@RequestBody Personas persona){
        return this.personasServiceImpl.create(persona);
    } 
      */
    
}
//endpoints


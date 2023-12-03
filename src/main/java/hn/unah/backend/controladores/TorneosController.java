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

import hn.unah.backend.modelos.Clasificatoria;
import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.modelos.Torneos;
import hn.unah.backend.servicios.impl.TorneosServiceImpl;

@RestController
@RequestMapping("/api/torneos")
public class TorneosController {

    @Autowired
    private TorneosServiceImpl torneosServiceImpl;

    @GetMapping("/test")
    public String test(){
        return "ok";
    }

    @GetMapping("/")
    public List<Torneos> getAll(){
        return this.torneosServiceImpl.getAll();
    }

    @GetMapping("/id/{id}")
    public Torneos get(@PathVariable int id){
        return this.torneosServiceImpl.get(id);
    }

    @PostMapping("/create")
    public Torneos create(@RequestBody Torneos torneo){
        return this.torneosServiceImpl.create(torneo);
    }

    @PostMapping("/update")
    public Torneos update(@RequestBody Torneos torneo){
        return this.torneosServiceImpl.create(torneo);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable int id){
        return this.torneosServiceImpl.delete(id);
    }

    @GetMapping("/jugar/{id}")
    public Equipos jugar(@PathVariable int id){
        return this.torneosServiceImpl.jugar(id);
    }
    @GetMapping("/getPartidos/{idTorneo}")
    public List<Partidos> getPartidos(@PathVariable int idTorneo){
        return this.torneosServiceImpl.getPartidos(idTorneo);
    }
    @GetMapping("/getEquipos/{idTorneo}")
    public List<Equipos> getEquipos(@PathVariable int idTorneo){
        return this.torneosServiceImpl.getEquipos(idTorneo);
    }
    @GetMapping("/equiposClasificatoria/{id}")
    public List<Clasificatoria> equiposClasificatoria(@PathVariable int id){
        return this.torneosServiceImpl.equiposClasificatoria(id);
    }

}

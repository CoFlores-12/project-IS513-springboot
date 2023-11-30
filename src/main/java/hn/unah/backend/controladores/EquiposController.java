package hn.unah.backend.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.backend.modelos.Equipos;
import hn.unah.backend.servicios.impl.EquiposServiceImpl;

@RestController
@RequestMapping("/api/equipos")
public class EquiposController {
    
    @Autowired
    private EquiposServiceImpl equiposServiceImpl;

    @PostMapping("/create/{idTorneo}")
    public Equipos create(@RequestBody Equipos equipo, @PathVariable int idTorneo) {
        return this.equiposServiceImpl.create(equipo, idTorneo);
    }

    @GetMapping("/get/{id}")
    public Equipos get(@PathVariable(name="id") int idEquipo){
        return this.equiposServiceImpl.get(idEquipo);
    }

    @PutMapping("/update/{id}")
    public Equipos update(@PathVariable(name="id") int idEquipo, @RequestBody Equipos equipo){
        return this.equiposServiceImpl.update(idEquipo, equipo);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable(name="id") int idEquipo){
        return this.equiposServiceImpl.delete(idEquipo);
    }

    @GetMapping("/get")
    public List<Equipos> getAll(){
        return this.equiposServiceImpl.getAll();
    }
     
}

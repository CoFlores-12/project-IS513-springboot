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

import hn.unah.backend.modelos.Personas;
import hn.unah.backend.modelos.Rols;
import hn.unah.backend.servicios.impl.PersonasServiceImpl;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {
    @Autowired
    private PersonasServiceImpl personasServiceImpl;
    
    @PostMapping("/crear")
    public Personas crear(@RequestBody Personas persona, int idRol){
        return this.personasServiceImpl.create(persona, idRol);
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


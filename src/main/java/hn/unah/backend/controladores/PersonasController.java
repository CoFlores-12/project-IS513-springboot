package hn.unah.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.backend.modelos.Personas;
import hn.unah.backend.servicios.impl.PersonasServiceImpl;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {
    @Autowired
    private PersonasServiceImpl personasServiceImpl;
    
    @PostMapping("/crear/persona")
    public Personas crear(@RequestBody Personas persona){
        return this.personasServiceImpl.create(persona);
    }
     /*  @DeleteMapping("/delete/personas")
    public Boolean delete(@PathVariable int id){
        return this.personasServiceImpl.delete(id);
    }
     @PostMapping("/update/persona")
    public Personas crear(@RequestBody Personas persona){
        return this.personasServiceImpl.create(persona);
    } 
     @GetMapping("/")
    public List<Personas> getAll(){
        return this.personasServiceImpl.getAll();
    }*/
}
//endpoints
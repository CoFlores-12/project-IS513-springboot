package hn.unah.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.backend.modelos.Partidos;
import hn.unah.backend.servicios.impl.PartidosServiceImpl;

@RestController
@RequestMapping("api/partidos")
public class PartidosController {
 
    @Autowired
    private PartidosServiceImpl partidosServiceImpl;
    
    @PostMapping("/crear")
    public Partidos crear(@RequestBody Partidos partidos){
        return this.partidosServiceImpl.create(partidos);
    }
}

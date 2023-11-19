package hn.unah.backend.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.backend.repositorios.TorneosRepository;
import hn.unah.backend.modelos.Torneos;
import hn.unah.backend.servicios.TorneosService;

@Service
public class TorneosServiceImpl implements TorneosService {
    @Autowired
    private TorneosRepository torneosRepository;

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
        Torneos torneoMod = this.torneosRepository.findById(torneo.getId()).get();
        torneoMod.setNombre(torneo.getNombre());
        torneoMod.setTitulo(torneo.getTitulo());
        torneoMod.setInformacion(torneo.getInformacion());
        torneoMod.setEstado(torneo.getEstado());
        torneoMod.setLogo(torneo.getLogo());

        this.torneosRepository.save(torneoMod);

        return torneoMod;
    }
    
}

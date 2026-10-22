package br.com.fiap.museu.service;

import br.com.fiap.museu.model.Obra;
import br.com.fiap.museu.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {

    private final ObraRepository repository;

    public ObraService(ObraRepository repository) {
        this.repository = repository;
    }

    public List<Obra> buscarObras(){
        return repository.buscarObras();
    }

    public void adicionarVoto(long id){
        repository.adicionarVoto(id);
    }


}

package br.com.fiap.museu.service;

import br.com.fiap.museu.model.Pintura;
import br.com.fiap.museu.model.type.TipoPintura;
import br.com.fiap.museu.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PinturaService {
    private final ObraRepository repository;

    @Autowired
    public PinturaService(ObraRepository repository) {
        this.repository = repository;
    }

    public Pintura cadastrar(String titulo, String autor, TipoPintura tipo, int larguraCm, int alturaCm){
        Pintura p = new Pintura();
        p.setTitulo(titulo);
        p.setAutor(autor);
        p.setDataCriacao(LocalDate.now());
        p.setTipo(tipo);
        p.setLarguraCm(larguraCm);
        p.setAlturaCm(alturaCm);
        p.setId(repository.castrarObra(p));

        return p;
    }


    public void editar(long id, Pintura pintura) {
        repository.editar(id, pintura);
    }
}

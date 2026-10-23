package br.com.fiap.museu.service;

import br.com.fiap.museu.model.Escultura;
import br.com.fiap.museu.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EsculturaService {
    private final ObraRepository repository;

    public EsculturaService(ObraRepository repository) {
        this.repository = repository;
    }

    public Escultura cadastrar(String titulo, String autor, String material, int alturaCm){
        Escultura e = new Escultura();

        e.setTitulo(titulo);
        e.setAutor(autor);
        e.setMaterial(material);
        e.setAlturaCm(alturaCm);
        e.setDataCriacao(LocalDate.now());
        e.setId(repository.castrarObra(e));
        return e;
    }

    public void editar(long id, Escultura escultura){
        repository.editar(id, escultura);
    }


}

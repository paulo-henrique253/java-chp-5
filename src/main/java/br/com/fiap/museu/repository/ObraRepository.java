package br.com.fiap.museu.repository;

import br.com.fiap.museu.model.Obra;
import br.com.fiap.museu.model.Pintura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class ObraRepository {
    // "persistencia" falsa
    public static List<Obra> obras = new ArrayList<>();
    public static long numId = 0;

    public long castrarObra(Obra obra){
        numId++;
        obra.setId(numId);
        obras.add(obra);
        return numId;
    }

    public List<Obra> buscarObras(){
        return obras;
    }

    public void remover(long id){
        obras.removeIf((obra -> obra.getId() == id));
    }

    public void editar(long id, Obra obra){
        for (Obra o : obras){
            if (o.getId() == id){
                obra.setId(o.getId());
                obra.setVotos(o.getVotos());
                obra.setDataCriacao(o.getDataCriacao());
                obras.remove(o);
                obras.add(obra);
                return;
            }
        }
    }
    public Obra buscar(long id){
        for (Obra o : obras){
            if (o.getId() == id)
                return o;
        }
        throw new RuntimeException("Obra não encontrada");
    }


    public void adicionarVoto(long id) {
        for (Obra o : obras){
            if (o.getId() == id){
                o.adicionarVoto();
                return;
            }
        }
        throw new RuntimeException("Obra não encontrada");
    }

    public List<Obra> buscarRanking() {
        obras.sort(Comparator.comparing(Obra::getVotos).reversed());
        return obras;
    }
}

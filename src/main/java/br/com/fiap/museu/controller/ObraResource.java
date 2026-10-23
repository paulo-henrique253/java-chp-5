package br.com.fiap.museu.controller;

import br.com.fiap.museu.exception.ErrorResponse;
import br.com.fiap.museu.model.Obra;
import br.com.fiap.museu.service.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ObraResource {

    private final ObraService service;

    public ObraResource(ObraService service) {
        this.service = service;
    }

    @PostMapping("/votar/{id}")
    public ResponseEntity<?> adicionarVoto(@PathVariable long id){
        service.adicionarVoto(id);
        return ResponseEntity.ok("Voto contabilizado com sucesso");
    }

    @GetMapping("/ranking")
    public ResponseEntity<?> buscarRanking(){
        List<Obra> obras = service.buscarRanking();
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id){
        try {

            return ResponseEntity.ok(service.buscar(id));
        } catch (RuntimeException e) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            ErrorResponse error = new ErrorResponse(
                    Instant.now(),
                    status.value(),
                    "Entidade não encontrada",
                    e.getMessage(),
                    "/api/pintura/" + id
            );
            return ResponseEntity.status(status).body(error);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarObras(){
        List<Obra> obras = service.buscarObras();
        return ResponseEntity.ok(obras);
    }

}

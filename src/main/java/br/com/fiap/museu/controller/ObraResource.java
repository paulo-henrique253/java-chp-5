package br.com.fiap.museu.controller;

import br.com.fiap.museu.service.ObraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

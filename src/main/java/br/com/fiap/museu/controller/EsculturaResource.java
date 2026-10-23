package br.com.fiap.museu.controller;

import br.com.fiap.museu.controller.dto.EsculturaDto;
import br.com.fiap.museu.controller.dto.EsculturaDtoMapper;
import br.com.fiap.museu.exception.ErrorResponse;
import br.com.fiap.museu.model.Escultura;
import br.com.fiap.museu.service.EsculturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/escultura")
public class EsculturaResource{

    private final EsculturaService service;

    public EsculturaResource(EsculturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody EsculturaDto dto){
        try{
            Escultura e = service.cadastrar(dto.titulo(), dto.autor(), dto.material(), dto.alturaCm());
            return ResponseEntity.ok(e);
        } catch (RuntimeException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorResponse error = new ErrorResponse(
                    Instant.now(),
                    status.value(),
                    "Erro ao cadastrar",
                    e.getMessage(),
                    "/api/escultura"
            );
            return ResponseEntity.status(status).body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable long id, @RequestBody EsculturaDto dto){
        try {
            service.editar(id, EsculturaDtoMapper.toEntity(dto));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorResponse error = new ErrorResponse(
                    Instant.now(),
                    status.value(),
                    "Erro ao editar",
                    e.getMessage(),
                    "/api/escultura"
            );
            return ResponseEntity.status(status).body(error);
        }
    }

}

package br.com.fiap.museu.controller;

import br.com.fiap.museu.controller.dto.PinturaDto;
import br.com.fiap.museu.controller.dto.PinturaDtoMapper;
import br.com.fiap.museu.exception.ErrorResponse;
import br.com.fiap.museu.model.Pintura;
import br.com.fiap.museu.model.type.TipoPintura;
import br.com.fiap.museu.service.PinturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/pintura")
public class PinturaResource {
    private final PinturaService service;

    public PinturaResource(PinturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody PinturaDto dto){
        try{
            Pintura p = service.cadastrar(dto.titulo(), dto.autor(), TipoPintura.valueOf(dto.tipo()), dto.larguraCm(), dto.alturaCm());
            return ResponseEntity.status(HttpStatus.CREATED).body(PinturaDtoMapper.toRespone(p));
        } catch (RuntimeException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorResponse error = new ErrorResponse(
                    Instant.now(),
                    status.value(),
                    "Erro ao cadastrar",
                    e.getMessage(),
                    "/api/pintura"
            );
            return ResponseEntity.status(status).body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar (@RequestBody PinturaDto dto, @PathVariable long id){
        try {
            service.editar(id, PinturaDtoMapper.toEntity(dto));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorResponse error = new ErrorResponse(
                    Instant.now(),
                    status.value(),
                    "Erro ao editar",
                    e.getMessage(),
                    "/api/pintura"
            );
            return ResponseEntity.status(status).body(error);
        }

    }


}

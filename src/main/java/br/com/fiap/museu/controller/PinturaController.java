package br.com.fiap.museu.controller;

import br.com.fiap.museu.controller.dto.PinturaDto;
import br.com.fiap.museu.controller.dto.PinturaDtoMapper;
import br.com.fiap.museu.model.Pintura;
import br.com.fiap.museu.model.type.TipoPintura;
import br.com.fiap.museu.service.PinturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pintura")
public class PinturaController {
    private final PinturaService service;

    public PinturaController(PinturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody PinturaDto dto){
        try{
            Pintura p = service.cadastrar(dto.titulo(), dto.autor(), dto.dataCriacao(), TipoPintura.valueOf(dto.tipo()), dto.larguraCm(), dto.alturaCm());
            return ResponseEntity.status(HttpStatus.CREATED).body(PinturaDtoMapper.toRespone(p));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Ocorreu um erro");
        }
    }

}

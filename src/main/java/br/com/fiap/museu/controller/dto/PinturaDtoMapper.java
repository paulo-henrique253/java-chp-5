package br.com.fiap.museu.controller.dto;

import br.com.fiap.museu.model.Pintura;
import br.com.fiap.museu.model.type.TipoPintura;

public class PinturaDtoMapper {
    public static PinturaDto toRespone(Pintura pintura) {
        return new PinturaDto(
                pintura.getId(),
                pintura.getTitulo(),
                pintura.getVotos(),
                pintura.getAutor(),
                pintura.getDataCriacao(),
                pintura.getTipo().name(),
                pintura.getLarguraCm(),
                pintura.getAlturaCm()
        );
    }

    public static Pintura toEntity(PinturaDto dto){
        Pintura p = new Pintura();
        p.setAutor(dto.autor());
        p.setTitulo(dto.titulo());
        p.setAlturaCm(dto.alturaCm());
        p.setLarguraCm(dto.larguraCm());
        p.setTipo(TipoPintura.valueOf(dto.tipo()));

        return p;
    }
}

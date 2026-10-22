package br.com.fiap.museu.controller.dto;

import br.com.fiap.museu.model.Pintura;

public class PinturaDtoMapper {
    public static Object toRespone(Pintura pintura) {
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
}

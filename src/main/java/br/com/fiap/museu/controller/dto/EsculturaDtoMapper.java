package br.com.fiap.museu.controller.dto;

import br.com.fiap.museu.model.Escultura;

public class EsculturaDtoMapper {
    public static EsculturaDto toResponse(Escultura escultura){
        return new EsculturaDto(
                escultura.getId(),
                escultura.getTitulo(),
                escultura.getVotos(),
                escultura.getAutor(),
                escultura.getDataCriacao(),
                escultura.getMaterial(),
                escultura.getAlturaCm()
        );
    }

    public static Escultura toEntity(EsculturaDto dto){
        Escultura e = new Escultura();
        e.setTitulo(dto.titulo());
        e.setAutor(dto.autor());
        e.setMaterial(e.getMaterial());
        e.setAlturaCm(dto.alturaCm());
        return e;
    }

}

package br.com.fiap.museu.controller.dto;

import br.com.fiap.museu.model.type.TipoPintura;

import java.time.LocalDate;

public record PinturaDto(long id, String titulo, int votos, String autor, LocalDate dataCriacao, String tipo, int larguraCm, int alturaCm) {
}

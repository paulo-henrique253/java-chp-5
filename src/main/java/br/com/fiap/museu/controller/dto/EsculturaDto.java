package br.com.fiap.museu.controller.dto;

import java.time.LocalDate;

public record EsculturaDto (long id, String titulo, int votos, String autor, LocalDate dataCriacao, String material, int alturaCm) {
}

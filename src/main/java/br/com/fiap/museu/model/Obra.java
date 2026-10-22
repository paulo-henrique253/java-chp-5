package br.com.fiap.museu.model;

import java.time.LocalDate;

public class Obra {
    private long id;
    private String titulo;
    private int votos;
    private String autor;
    private LocalDate dataCriacao;


    public Obra() {
    }

    public Obra(long id, String titulo, int votos, String autor, LocalDate dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.votos = votos;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void adicionarVoto() {
        this.votos += 1;
    }
}

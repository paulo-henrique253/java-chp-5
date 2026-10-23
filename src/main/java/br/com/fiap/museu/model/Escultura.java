package br.com.fiap.museu.model;

import java.time.LocalDate;

public class Escultura extends Obra {
    private String material;
    private int alturaCm;

    public Escultura() {
    }

    public Escultura(long id, String titulo, int votos, String autor, LocalDate dataCriacao, String material, int alturaCm) {
        super(id, titulo, votos, autor, dataCriacao);
        this.material = material;
        this.alturaCm = alturaCm;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

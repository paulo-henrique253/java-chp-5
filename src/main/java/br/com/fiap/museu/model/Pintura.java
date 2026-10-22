package br.com.fiap.museu.model;

import br.com.fiap.museu.model.type.TipoPintura;

import java.time.LocalDate;

public class Pintura extends Obra{
    private TipoPintura tipo;
    private int larguraCm;
    private int alturaCm;

    public Pintura() {
        super();
    }

    public Pintura(long id, String titulo, int votos, String autor, LocalDate dataCriacao, TipoPintura tipo, int larguraCm, int alturaCm) {
        super(id, titulo, votos, autor, dataCriacao);
        this.tipo = tipo;
        this.larguraCm = larguraCm;
        this.alturaCm = alturaCm;
    }

    public TipoPintura getTipo() {
        return tipo;
    }

    public void setTipo(TipoPintura tipo) {
        this.tipo = tipo;
    }

    public int getLarguraCm() {
        return larguraCm;
    }

    public void setLarguraCm(int larguraCm) {
        this.larguraCm = larguraCm;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }


}

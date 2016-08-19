package br.com.daniel.oliveira.projetocadastroitembd.model;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Categoria extends SugarRecord implements Serializable {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;

        Categoria categoria = (Categoria) o;

        if (getId() != null ? !getId().equals(categoria.getId()) : categoria.getId() != null)
            return false;
        return getNome() != null ? getNome().equals(categoria.getNome()) : categoria.getNome() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        return result;
    }
}

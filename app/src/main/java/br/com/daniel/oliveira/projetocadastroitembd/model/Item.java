package br.com.daniel.oliveira.projetocadastroitembd.model;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Item extends SugarRecord implements Serializable {

    private String nome;
    private Integer quantidade;
    private Categoria categoria;

    public Item() {
    }

    public Item(String nome, Integer quantidade, Categoria categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (getNome() != null ? !getNome().equals(item.getNome()) : item.getNome() != null)
            return false;
        if (getQuantidade() != null ? !getQuantidade().equals(item.getQuantidade()) : item.getQuantidade() != null)
            return false;
        return getCategoria() != null ? getCategoria().equals(item.getCategoria()) : item.getCategoria() == null;

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getQuantidade() != null ? getQuantidade().hashCode() : 0);
        result = 31 * result + (getCategoria() != null ? getCategoria().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", categoria=" + categoria +
                '}';
    }
}

package com.roomano786.bookstore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();

    public Categoria() {
        super();
    }

    public Categoria(Integer idCategoria, String nome, String descricao) {
        super();
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer id) {
        this.idCategoria = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return getIdCategoria().equals(categoria.getIdCategoria());
    }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Categoria other = (Categoria) o;
        if (idCategoria == null) {
            if (other.idCategoria != null)
                return false;
        } else if (!idCategoria.equals(other.idCategoria))
            return false;
        return true;
   }

    @Override
    public int hashCode() {
        //return Objects.hash(getIdCategoria());
        final int prime = 31;
        int result =1;
        result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
        return result;
    }
}

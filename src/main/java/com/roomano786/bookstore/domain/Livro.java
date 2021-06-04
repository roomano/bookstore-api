package com.roomano786.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivro;
    private String titulo;
    private String nome_autor;
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer idLivro, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer id) {
        this.idLivro = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Livro other = (Livro) o;
        if (idLivro == null) {
            if (other.idLivro != null)
                return false;
        } else if (!idLivro.equals(other.idLivro))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getIdCategoria());
        final int prime = 31;
        int result =1;
        result = prime * result + ((idLivro == null) ? 0 : idLivro.hashCode());
        return result;
    }

}

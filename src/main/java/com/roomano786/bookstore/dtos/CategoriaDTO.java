package com.roomano786.bookstore.dtos;

import com.roomano786.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo NOME é requerido")
    @Length(min = 4, max = 30, message = "O campo nome deve ter entre 4 a 30 caracteres")
    private String nome;
    @NotEmpty(message = "O campo DESCRIÇÃO é requerido")
    @Length(min = 10 ,max = 150, message = "O campo DESCRIÇÃO deve conter entre 10 a 150 caracteres")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getIdCategoria();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

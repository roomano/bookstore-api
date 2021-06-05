package com.roomano786.bookstore.service;

import com.roomano786.bookstore.domain.Livro;
import com.roomano786.bookstore.repositories.LivroRepository;
import com.roomano786.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));

    }

    public List<Livro> findAll(Integer idCategoria) {
        categoriaService.findById(idCategoria);
        return repository.findAllByCategoria(idCategoria);
    }
}

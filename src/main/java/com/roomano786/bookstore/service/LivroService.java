package com.roomano786.bookstore.service;

import com.roomano786.bookstore.domain.Livro;
import com.roomano786.bookstore.repositories.LivroRepository;
import com.roomano786.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));

    }
}

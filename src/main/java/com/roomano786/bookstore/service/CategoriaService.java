package com.roomano786.bookstore.service;

import com.roomano786.bookstore.domain.Categoria;
import com.roomano786.bookstore.repositories.CategoriaRepository;
import com.roomano786.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! ID: " + id + "; Tipo: "+ Categoria.class.getName()));
    }
}

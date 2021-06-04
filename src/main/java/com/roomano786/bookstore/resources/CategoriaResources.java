package com.roomano786.bookstore.resources;

import com.roomano786.bookstore.domain.Categoria;
import com.roomano786.bookstore.dtos.CategoriaDTO;
import com.roomano786.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> lista = service.findAll();
        List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }
    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto ) {
        Categoria newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));

    }
}
//localhost:8080/categorias/1
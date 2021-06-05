package com.roomano786.bookstore.resources;

import com.roomano786.bookstore.domain.Livro;
import com.roomano786.bookstore.dtos.LivroDTO;
import com.roomano786.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResources {
    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    // localhost:8079/livros?categoria=1
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria) {
        List<Livro> list = service.findAll(idCategoria);
        List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}

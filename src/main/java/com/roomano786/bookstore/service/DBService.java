package com.roomano786.bookstore.service;

import com.roomano786.bookstore.domain.Categoria;
import com.roomano786.bookstore.domain.Livro;
import com.roomano786.bookstore.repositories.CategoriaRepository;
import com.roomano786.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
    public void instanciaBaseDeDados() {

            Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
            Categoria cat2 = new Categoria(null, "Romance", "Livros de contos e histórias dramáticas");
            Categoria cat3 = new Categoria(null,"Direito","Livros sobre a legislação");

            Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
            Livro l11 = new Livro(null, "Java", "Deitel Melo", "Lorem Ipsum", cat1);
            Livro l2 = new Livro(null, "Harry Potter", "Aquela Tia", "Lorem Ipsum amet", cat2);
            Livro l3 = new Livro(null, "Saga Twilight", "Irmãos Chupacabra", "História dos vampiros", cat2);
            Livro l4 = new Livro(null, "Introdução ao Estudo do Direito", "Zimel Makovo", "Lorem Ipsum", cat3);
            Livro l5 = new Livro(null, "Introdução ao Estudo", "Makaroni Stiven", "Lorem Ipsum", cat3);

            cat1.getLivros().addAll(Arrays.asList(l1,l11));
            cat2.getLivros().addAll(Arrays.asList(l2,l3));
            cat3.getLivros().addAll(Arrays.asList(l4, l5));


            this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
            this.livroRepository.saveAll(Arrays.asList(l1, l11, l2, l3, l4, l5));

    }
}

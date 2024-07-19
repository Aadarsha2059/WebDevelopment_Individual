package org.example.individual.Service;


import org.example.individual.Entity.Book;
import org.example.individual.Pojo.BooksPojo;
import org.example.individual.Pojo.BooksProjection;

import java.io.IOException;
import java.util.List;

public interface BookService {

    Integer save(BooksPojo booksPojo) throws IOException;

    List<Book> findAll();
    List<BooksProjection> findAllProj();
    List<Book> findByUserId(Integer id);

    Book findById(Integer id);

    void deleteById(Integer id);

}

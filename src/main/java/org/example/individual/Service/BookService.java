package org.example.individual.Service;


import org.example.individual.Entity.Book;
import org.example.individual.Pojo.BooksPojo;

import java.util.List;

public interface BookService {

    Integer save(BooksPojo booksPojo);

    List<Book> findAll();

    Book findById(Integer id);

    void deleteById(Integer id);

}

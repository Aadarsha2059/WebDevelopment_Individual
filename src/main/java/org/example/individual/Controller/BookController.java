package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Book;
import org.example.individual.Pojo.BooksPojo;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PostMapping
    public GlobalAPIResponse<Integer> save(@RequestBody BooksPojo booksPojo) {
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        Integer bookId = bookService.save(booksPojo);
        globalAPIResponse.setData(bookId);
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data saved successfully");
        return globalAPIResponse;

    }

    @PutMapping
    public void update(@RequestBody BooksPojo booksPojo) {
        bookService.save(booksPojo);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        bookService.deleteById(id);


    }

    @GetMapping("{id}")
    public Book findById(@PathVariable Integer id) {
        return this.bookService.findById(id);
    }

}


package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Book;
import org.example.individual.Pojo.BooksPojo;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Service.BookService;
import org.example.individual.util.ImageToBase64;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        ImageToBase64 imageToBase64 = new ImageToBase64();
       List<Book> items= this.bookService.findAll();
        items = items.stream().map(item -> {
            item.setImage(imageToBase64.getImageBase64(item.getImage()));
            return item;
        }).collect(Collectors.toList());
        return items;

    }

    @PostMapping
    public GlobalAPIResponse<Integer> save( @ModelAttribute BooksPojo booksPojo) throws IOException {
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        Integer bookId = bookService.save(booksPojo);
        globalAPIResponse.setData(bookId);
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data saved successfully");
        return globalAPIResponse;

    }

    @PutMapping
    public void update(@RequestBody BooksPojo booksPojo) throws IOException {
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        bookService.save(booksPojo);
        globalAPIResponse.setData(booksPojo.getId());
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data updated successfully");



    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        bookService.deleteById(id);
        globalAPIResponse.setData(id);
        globalAPIResponse.setMessage("data deleted successfully");


    }

    @GetMapping("{id}")
    public Book findById(@PathVariable Integer id) {
        return this.bookService.findById(id);
    }

}


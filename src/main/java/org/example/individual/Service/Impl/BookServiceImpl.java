package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Book;
import org.example.individual.Entity.User;
import org.example.individual.Pojo.BooksPojo;
import org.example.individual.Pojo.BooksProjection;
import org.example.individual.Repository.BooksRepository;
import org.example.individual.Repository.UserRepository;
import org.example.individual.Service.BookService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final String UPLOAD_DIRECTORY = new StringBuilder().append(System.getProperty("user.dir")).append("/files/").toString();

    private final BooksRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public Integer save(BooksPojo booksPojo) throws IOException {
        Book book = new Book();

        book.setId(booksPojo.getId());
        book.setBooksName(booksPojo.getBooksName());
        book.setGenres(booksPojo.getGenres());

        User user = userRepository.findById(booksPojo.getUserId()).get();
        book.setUser(user);


        // image upload logic
        if(booksPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, booksPojo.getImage().getOriginalFilename());
            fileNames.append(booksPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, booksPojo.getImage().getBytes());

            book.setImage(booksPojo.getImage().getOriginalFilename());
        }

        book = bookRepository.save(book);
        return book.getId();
    }

    @Override
    public List<BooksProjection> findAllProj() {
        return bookRepository.findAllData();
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByUserId(Integer id) {
        return bookRepository.findBooksByUserId(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }


}

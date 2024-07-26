package org.example.individual;




import org.assertj.core.api.Assertions;
import org.example.individual.Entity.Book;
import org.example.individual.Repository.BooksRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BooksRepositoryTest {
    @Autowired
    private BooksRepository booksRepository;

    @Test
    @Rollback(value = false)
    @Order(1)
    public void saveBookTest(){
        Book book = new Book();
        book.setBooksName("Munamadan");
        book.setImage("aa");
        book.setGenres("Poetry");
        booksRepository.save(book);


        Assertions.assertThat(book.getId()).isGreaterThan(0);


    }
    @Test
    @Order(2)
    public void findByIdTest(){



        Book bookGet = booksRepository.findById(1).get();
        Assertions.assertThat(bookGet.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void findAllBookData(){
        List<Book> books = booksRepository.findAll();
        Assertions.assertThat(books.size()).isGreaterThan(0);

    }
    @Test
    @Order(4)
    public void updateBook(){
        Book book=booksRepository.findById(1).get();
        book.setBooksName("Newnmunamadan");


        Book bookUpdated=booksRepository.save(book);
        Assertions.assertThat(bookUpdated.getBooksName()).isEqualTo("Newnmunamadan");
//



    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteBookTest(){
        Book book=booksRepository.findById(1).get();
        booksRepository.delete(book);



        Book book1=null;

        Optional<Book> book2=booksRepository.findById(2);
        if(book2.isPresent()){
            book1=book2.get();
        }
        Assertions.assertThat(book1).isNull();



    }
}


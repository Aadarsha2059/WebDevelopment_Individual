package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Sellbooks;
import org.example.individual.Entity.User;
import org.example.individual.Pojo.SellBooksPojo;
import org.example.individual.Pojo.SellBooksProjection;
import org.example.individual.Repository.SellBooksRepository;
import org.example.individual.Repository.UserRepository;
import org.example.individual.Service.SellBookService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellBookServiceImpl implements SellBookService {

    private final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/files/";

    private final SellBooksRepository sellBooksRepository;
    private final UserRepository userRepository;

    @Override
    public Integer save(SellBooksPojo sellBooksPojo) throws IOException {
        Sellbooks sellbooks = new Sellbooks();

        // Set values from SellBooksPojo
        sellbooks.setBookname(sellBooksPojo.getBookname());
        sellbooks.setGenre(sellBooksPojo.getGenre());
        sellbooks.setBookprice(String.valueOf(sellBooksPojo.getBookprice()));
        sellbooks.setBookcondition(sellBooksPojo.getBookcondition());

        // Find the user by ID and set the user for the book
        User user = userRepository.findById(sellBooksPojo.getUserId()).orElse(null);
        if (user != null) {
            sellbooks.setUser(user);
        }

        // Handle image upload if present
        if (sellBooksPojo.getImage() != null) {
            String fileName = sellBooksPojo.getImage().getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIRECTORY, fileName);
            Files.write(filePath, sellBooksPojo.getImage().getBytes());
            sellbooks.setImage(fileName);  // Save the image file name
        }

        // Save the book to the repository
        sellbooks = sellBooksRepository.save(sellbooks);
        return sellbooks.getId();  // Return the saved book's ID
    }

    @Override
    public List<SellBooksProjection> findAllProj() {
        return sellBooksRepository.findAllData();
    }

    @Override
    public List<Sellbooks> findAll() {
        return sellBooksRepository.findAll();
    }

    @Override
    public List<Sellbooks> findByUserId(Integer id) {
        return sellBooksRepository.findBooksByUserId(id);
    }

    @Override
    public void deleteById(Integer id) {
        sellBooksRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Sellbooks findById(Integer id) {
        return sellBooksRepository.findById(Long.valueOf(id)).orElse(null);
    }
}

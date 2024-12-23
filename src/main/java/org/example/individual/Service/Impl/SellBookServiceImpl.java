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
    private  final  String UPLOAD_DIRECTORY = new StringBuilder().append(System.getProperty("user.dir")).append("/files/").toString();

    private  final SellBooksRepository sellBooksRepository;
    private final UserRepository userRepository;



    @Override
    public Integer save(SellBooksPojo sellBooksPojo) throws IOException{
        Sellbooks sellbooks = new Sellbooks();

        sellbooks.setId(sellbooks.getId());
        sellbooks.setBookname(sellbooks.getBookname());
        sellbooks.setGenre(sellbooks.getGenre());
        sellbooks.setBookprice(sellbooks.getBookprice());
        sellbooks.setBookcondition(sellbooks.getBookcondition());

        User user = userRepository.findById(sellBooksPojo.getId()).get();
        sellbooks.setUser(user);

        // image upload logic
        if(sellBooksPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, sellBooksPojo.getImage().getOriginalFilename());
            fileNames.append(sellBooksPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, sellBooksPojo.getImage().getBytes());

            sellbooks.setImage(sellBooksPojo.getImage().getOriginalFilename());
        }
        sellbooks =sellBooksRepository.save(sellbooks);
        return sellbooks.getId();
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
        sellBooksRepository.deleteById(id);

    }

    @Override
    public Sellbooks findById(Integer id) {
        return sellBooksRepository.findById(id).orElse(null);
    }
}

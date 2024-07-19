package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Book;
import org.example.individual.Entity.Seeker;
import org.example.individual.Entity.User;
import org.example.individual.Pojo.SeekerPojo;
import org.example.individual.Repository.BooksRepository;
import org.example.individual.Repository.SeekerRepository;
import org.example.individual.Repository.UserRepository;
import org.example.individual.Service.SeekerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SeekerServiceImpl implements SeekerService {

    private final SeekerRepository seekerRepository;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    @Override
    public Integer save(SeekerPojo seekerPojo) {
        Seeker seeker = new Seeker();

        seeker.setId(seekerPojo.getId());


        User user = userRepository.findById(seekerPojo.getUserId()).get();
        seeker.setUser(user);
        seeker.setSeekerName(user.getUserName());
        seeker.setAddress(user.getAddress());
        seeker.setEmail(user.getEmail());

        Book book = booksRepository.findById(seekerPojo.getBookId()).get();
        seeker.setBook(book);

        seeker = seekerRepository.save(seeker);
        return seeker.getId();
    }

    @Override
    public List<Seeker> findAll() {
        return List.of();
    }

    @Override
    public Seeker findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
seekerRepository.deleteById(id);
    }
}

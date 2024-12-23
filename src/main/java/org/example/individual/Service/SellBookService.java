package org.example.individual.Service;

import org.example.individual.Entity.Sellbooks;
import org.example.individual.Pojo.SellBooksPojo;
import org.example.individual.Pojo.SellBooksProjection;

import java.io.IOException;
import java.util.List;

public interface SellBookService {

    List<SellBooksProjection> findAllProj();

    List<Sellbooks> findAll();

    List<Sellbooks> findByUserId(Integer id);

    Integer save(SellBooksPojo sellBooksPojo) throws IOException;

    void deleteById(Integer id);

    Sellbooks findById(Integer id);
}

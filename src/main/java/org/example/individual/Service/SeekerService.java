package org.example.individual.Service;

import org.example.individual.Entity.Seeker;
import org.example.individual.Pojo.SeekerPojo;

import java.util.List;

public interface SeekerService {

    Integer save(SeekerPojo seekerPojo);

    List<Seeker> findAll();

    Seeker findById(Integer id);

    void deleteById(Integer id);

}

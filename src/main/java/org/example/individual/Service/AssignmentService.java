package org.example.individual.Service;

import org.example.individual.Entity.Assignment;
import org.example.individual.Pojo.AssignmentPojo;

import java.util.List;

public interface AssignmentService {
    void save(AssignmentPojo assignmentPojo);

    List<Assignment> findAll();

    void deleteById(Integer id);
}

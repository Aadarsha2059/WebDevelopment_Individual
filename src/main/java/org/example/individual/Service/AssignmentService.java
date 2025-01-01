package org.example.individual.Service;

import org.example.individual.Entity.Assignment;
import org.example.individual.Pojo.AssignmentPojo;

import java.io.IOException;
import java.util.List;

public interface AssignmentService {
    Long save(AssignmentPojo assignmentPojo) throws IOException;

    List<Assignment> findAll();

    Assignment findById(Long id);

    void deleteById(Long id);
}

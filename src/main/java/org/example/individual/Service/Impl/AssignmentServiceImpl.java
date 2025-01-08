package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Assignment;
import org.example.individual.Pojo.AssignmentPojo;
import org.example.individual.Repository.AssignmentRepository;
import org.example.individual.Service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AssignmentServiceImpl implements AssignmentService {
    private final AssignmentRepository assignmentRepository;

    @Override
    public void save(AssignmentPojo assignmentPojo) {
        Assignment assignment = new Assignment();
        assignment.setQualificationList(assignmentPojo.getQualificationList());
        assignmentRepository.save(assignment);

    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        assignmentRepository.deleteById(id);

    }
}

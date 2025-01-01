package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Assignment;
import org.example.individual.Pojo.AssignmentPojo;
import org.example.individual.Repository.AssignmentRepository;
import org.example.individual.Service.AssignmentService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    private final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/assignments/";

    @Override
    public Long save(AssignmentPojo assignmentPojo) throws IOException {
        Assignment assignment = new Assignment();
        if (assignmentPojo.getId() != null) {
            assignment = assignmentRepository.findById(assignmentPojo.getId()).orElse(new Assignment());
        }

        assignment.setTitle(assignmentPojo.getTitle());

        // Handle file upload
        if (assignmentPojo.getPdfFile() != null) {
            String fileName = assignmentPojo.getPdfFile().getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIRECTORY, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, assignmentPojo.getPdfFile().getBytes());

            assignment.setPdfFileName(fileName);
            assignment.setUploadPath(filePath.toString());
        }

        return assignmentRepository.save(assignment).getId();
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        assignmentRepository.deleteById(id);
    }
}

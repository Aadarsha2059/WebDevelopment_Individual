package org.example.individual.Controller;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Assignment;
import org.example.individual.Pojo.AssignmentPojo;
import org.example.individual.Service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveAssignment(
            @RequestParam("title") String title,
            @RequestParam("pdfFile") MultipartFile pdfFile) {
        try {
            AssignmentPojo assignmentPojo = new AssignmentPojo();
            assignmentPojo.setTitle(title);
            assignmentPojo.setPdfFile(pdfFile);

            Long id = assignmentService.save(assignmentPojo);
            return ResponseEntity.ok("Assignment saved with ID: " + id);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to save assignment: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteById(id);
        return ResponseEntity.ok("Assignment deleted successfully.");
    }
}

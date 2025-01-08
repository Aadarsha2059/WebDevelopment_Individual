package org.example.individual.Controller;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Assignment;
import org.example.individual.Pojo.AssignmentPojo;
import org.example.individual.Service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("qualification")
@RequiredArgsConstructor

public class AssignmentController {
    private final AssignmentService assignmentService;

    @PostMapping
    public void save(@RequestBody AssignmentPojo assignmentPojo){
        assignmentService.save(assignmentPojo);
    }

    @GetMapping
    public List <Assignment> findAll(){
        return assignmentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        assignmentService.deleteById(id);
    }
}

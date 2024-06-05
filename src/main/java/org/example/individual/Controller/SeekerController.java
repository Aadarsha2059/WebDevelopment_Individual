package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Seeker;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Pojo.SeekerPojo;
import org.example.individual.Service.SeekerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seeker")
@RequiredArgsConstructor
public class SeekerController {
    private final SeekerService seekerService;

    @GetMapping
    public List<Seeker> findAll() {
        return this.seekerService.findAll();
    }

    @PostMapping
    public GlobalAPIResponse<Integer> save(@RequestBody SeekerPojo seekerPojo) {
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        Integer seekerId = seekerService.save(seekerPojo);
        globalAPIResponse.setData(seekerId);
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data saved successfully");
        return globalAPIResponse;

    }

    @PutMapping
    public void update(@RequestBody SeekerPojo seekerPojo) {
        seekerService.save(seekerPojo);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        seekerService.deleteById(id);


    }

    @GetMapping("{id}")
    public Seeker findById(@PathVariable Integer id) {
        return this.seekerService.findById(id);
    }

}

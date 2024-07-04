package org.example.individual.Controller;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Suggestions;
import org.example.individual.Pojo.SuggestionsPojo;
import org.example.individual.Service.SuggestionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suggestion")
@RequiredArgsConstructor



public class SuggestionsController {
    private final SuggestionsService suggestionsService;

    @PostMapping
    public void save(@RequestBody SuggestionsPojo suggestionsPojo) {
        suggestionsService.save(suggestionsPojo);
    }
    @GetMapping
    public List<Suggestions> findAll(){
        return suggestionsService.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        suggestionsService.deleteById(id);
    }

}

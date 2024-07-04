package org.example.individual.Service;

import org.example.individual.Entity.Suggestions;
import org.example.individual.Pojo.SuggestionsPojo;

import java.util.List;

public interface SuggestionsService {
    void save(SuggestionsPojo suggestionsPojo);

    List<Suggestions> findAll();

    void deleteById(Integer id);
}

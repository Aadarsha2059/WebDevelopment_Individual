package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Suggestions;
import org.example.individual.Pojo.SuggestionsPojo;
import org.example.individual.Repository.SuggestionsRepository;
import org.example.individual.Service.SuggestionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class SuggestionsServiceImpl implements SuggestionsService {

    private final SuggestionsRepository suggestionsRepository;
    @Override
    public void save(SuggestionsPojo suggestionsPojo) {
        Suggestions suggestions = new Suggestions();
        suggestions.setSuggestionList(suggestionsPojo.getSuggestions());
        suggestionsRepository.save(suggestions);

    }

    @Override
    public List<Suggestions> findAll() {
        return suggestionsRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        suggestionsRepository.deleteById(id);

    }
}

package org.example.individual.Repository;


import org.example.individual.Entity.Suggestions;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface SuggestionsRepository  extends JpaRepository<Suggestions, Integer> {



}

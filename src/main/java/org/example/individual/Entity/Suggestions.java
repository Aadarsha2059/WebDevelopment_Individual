package org.example.individual.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="suggestion")
@Setter
@Getter

public class Suggestions {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suggestion_seq_gen")
    @SequenceGenerator(name = "suggestion_seq_gen", sequenceName = "suggestion_seq", allocationSize = 1, initialValue = 1)
    @Id
    private Integer id;

    @Column(name="suggestion_list",length = 255)
    private String suggestionList;




}

package org.example.individual.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String pdfFileName; // Stores the name of the PDF file

    @Column(nullable = false)
    private String uploadPath; // Stores the path to the PDF file
}

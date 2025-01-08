package org.example.individual.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "qualification")
@Setter
@Getter
public class Assignment {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "qualification_seq_gen")
    @SequenceGenerator(name = "qualification_seq_gen",sequenceName = "qualification_seq",allocationSize = 1,initialValue = 1)

    @Id
    private Integer id;

    @Column(name = "qualification_list",length = 255)
    private String qualificationList;



}

package org.example.individual.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
    @Id
    private Integer id;

    @Column(name = "userName", length = 255)
    private String userName;

    @Column(name = "password", length = 255)
    private String password;



    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "address", length = 255)
    private String address;




}

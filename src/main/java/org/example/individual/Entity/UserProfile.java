package org.example.individual.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="userprofile")
@Setter
@Getter

public class UserProfile {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)

    @Id
    private Integer id;

    @Column(name="fullName", length = 255)
    private String fullName;

    @Column(name = "Age",length = 255)
    private Integer age;

    @Column(name="Location",length = 255)
    private String location;

    @Column(name = "Gender",length = 255)
    private String gender;

    @Column(name = "Contact",length = 255)
    private Integer contact;

    @Column(name = "UpdatePassword",length = 255)
    private String updatePassword;

    @Column(name = "ConfirmPassword",length = 255)
    private String confirmPassword;

    @Column(name = "UpdateEmail",length = 255)
    private String updateEmail;


//    public List<UserProfilePageProjection> findAllData() {
//    }
}

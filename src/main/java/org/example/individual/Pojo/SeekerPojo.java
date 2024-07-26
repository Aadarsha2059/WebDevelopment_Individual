package org.example.individual.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeekerPojo {
    private Integer id;

    private String seekerName;

    private String email;

    private String password;

    private String address;

    private Integer userId;

    private Integer bookId;
}

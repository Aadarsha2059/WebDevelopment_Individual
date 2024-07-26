package org.example.individual.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;

    private String userName;
    private String password;


    private String email;

    private String address;
}

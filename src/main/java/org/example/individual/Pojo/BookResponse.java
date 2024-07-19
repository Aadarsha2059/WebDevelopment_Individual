package org.example.individual.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Integer id;
    private Integer seekerId;
    private String name;
    private String genre;
    private String image;
    private Integer userId;
}

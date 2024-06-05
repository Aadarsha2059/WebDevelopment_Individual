package org.example.individual.Pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BooksPojo {
    private Integer id;

    private String booksName;

    private String genres;

    private Integer userId;
}

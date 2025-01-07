package org.example.individual.Pojo;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BooksPojo {
    private Integer id;

    @NotNull
    private MultipartFile image;

    private String booksName;

    private String genres;

    private Integer cost;
    private String type;

    private Integer userId;
}

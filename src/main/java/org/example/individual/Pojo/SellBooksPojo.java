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





public class SellBooksPojo {
    private Integer id;

    @NotNull
    private MultipartFile image;

    private String bookname;
    private String genre;
    private Integer bookprice;
    private String bookcondition;


    private Integer UserId;
//   {
//    }
}

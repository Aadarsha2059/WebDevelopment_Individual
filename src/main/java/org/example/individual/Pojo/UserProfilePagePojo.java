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

public class UserProfilePagePojo {
    private Integer id;

    @NotNull
    private MultipartFile image;
    private String fullname;
    private Integer age;
    private String gender;
    private Integer contact;
    private String updatePassword;
    private String confirmPassword;
    private String updateEmail;
    private String location;


}

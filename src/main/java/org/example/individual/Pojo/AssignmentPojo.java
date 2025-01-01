package org.example.individual.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AssignmentPojo {
    private Long id; // Optional, for updates
    private String title;
    private MultipartFile pdfFile; // File to be uploaded
}

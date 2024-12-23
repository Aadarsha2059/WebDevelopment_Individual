package org.example.individual.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.individual.Entity.UserProfile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class GlobalAPIResponse<T> extends UserProfile {
    private String message;
    private String status;
    private T data;
}

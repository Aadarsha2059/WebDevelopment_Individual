package org.example.individual.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class GlobalAPIResponse<T> {
    private String message;
    private String status;
    private T data;
}

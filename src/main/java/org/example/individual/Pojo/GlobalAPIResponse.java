package org.example.individual.Pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalAPIResponse<T> {
    private int status; // HTTP status code
    private String message; // Success or error message
    private T data; // The actual data being returned (generic type)

    // Constructor for success cases
    public GlobalAPIResponse(T data, String message) {
        this.status = 200; // Default to HTTP 200 OK
        this.data = data;
        this.message = message;
    }

    // Constructor for error cases
    public GlobalAPIResponse(String message, int status) {
        this.status = status;
        this.message = message;
    }
}

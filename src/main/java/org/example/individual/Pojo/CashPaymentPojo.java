package org.example.individual.Pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CashPaymentPojo {

    private Long id;

    @NotNull
    @Size(min = 1, max = 255, message = "Customer name cannot be empty or exceed 255 characters")
    private String customerName;

    @NotNull
    @Size(min = 1, max = 255, message = "Address cannot be empty or exceed 255 characters")
    private String address;

    @NotNull
    @Size(min = 10, max = 15, message = "Contact number should be between 10 and 15 characters")
    private String contactNumber;

    @NotNull
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull
    private boolean paymentStatus;

    private String createdAt; // Assuming the date-time will be managed on the backend

}

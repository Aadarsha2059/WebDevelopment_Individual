package org.example.individual.Pojo;

import java.time.LocalDateTime;

public interface CashPaymentProjection {

    Long getId();
    String getCustomerName();
    String getAddress();
    String getContactNumber();
    String getEmail();
    boolean getPaymentStatus();
    LocalDateTime getCreatedAt();
}
package org.example.individual.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "cash_payment")
@Setter
@Getter
public class CashPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cash_payment_seq_gen")
    @SequenceGenerator(name = "cash_payment_seq_gen", sequenceName = "cash_payment_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "customer_name", length = 255, nullable = false)
    private String customerName;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "contact_number", length = 50, nullable = false)
    private String contactNumber;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "payment_status", nullable = false)
    private boolean paymentStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}

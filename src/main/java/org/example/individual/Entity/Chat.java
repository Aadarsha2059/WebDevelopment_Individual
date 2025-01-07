package org.example.individual.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat")
@Setter
@Getter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_seq_gen")
    @SequenceGenerator(name = "chat_seq_gen", sequenceName = "chat_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "sender_id", nullable = false)
    private Long senderId;  // User ID who sent the message

    @Column(name = "receiver_id", nullable = false)
    private Long receiverId;  // User ID who receives the message

    @Column(name = "message", length = 1000, nullable = false)
    private String message;  // The content of the message

    @Column(name = "status", nullable = false)
    private boolean status;  // Status of the message (sent, read, etc.)

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;  // Timestamp of when the message was sent

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User receiver;
}

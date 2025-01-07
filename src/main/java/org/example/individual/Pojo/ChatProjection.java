package org.example.individual.Pojo;



import java.time.LocalDateTime;

public interface ChatProjection {

    Long getId();               // ID of the chat message
    Long getSenderId();         // ID of the sender
    Long getReceiverId();       // ID of the receiver
    String getMessage();        // Content of the message
    boolean getStatus();        // Status of the message (e.g., read, delivered, etc.)
    LocalDateTime getCreatedAt(); // Timestamp when the message was created
}

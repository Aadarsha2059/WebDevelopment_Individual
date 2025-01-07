package org.example.individual.Pojo;




import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChatPojo {

    private Long id;
    private Long senderId;
    private Long receiverId;
    private String messageContent;
    private boolean status;
    private LocalDateTime timestamp;

}

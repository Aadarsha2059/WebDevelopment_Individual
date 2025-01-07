package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Chat;
import org.example.individual.Pojo.ChatPojo;
import org.example.individual.Pojo.ChatProjection;
import org.example.individual.Service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/all")
    public ResponseEntity<List<ChatProjection>> getAllChats() {
        List<ChatProjection> chats = chatService.findAllChats();
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/conversation/{senderId}/{receiverId}")
    public ResponseEntity<List<Chat>> getConversation(@PathVariable Long senderId, @PathVariable Long receiverId) {
        List<Chat> conversation = chatService.getConversation(senderId, receiverId);
        return ResponseEntity.ok(conversation);
    }

    @PostMapping("/send")
    public ResponseEntity<Long> sendChat(@RequestBody ChatPojo chatPojo) {
        Long chatId = chatService.save(chatPojo);
        return ResponseEntity.ok(chatId);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateChat(@RequestBody ChatPojo chatPojo) {
        chatService.update(chatPojo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/user/{userId}")
    public ResponseEntity<Void> deleteChatsByUser(@PathVariable Long userId) {
        chatService.deleteChatsByUserId(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/markAllAsRead/{userId}")
    public ResponseEntity<Void> markAllAsRead(@PathVariable Long userId) {
        chatService.markAllAsRead(userId);
        return ResponseEntity.ok().build();
    }
}

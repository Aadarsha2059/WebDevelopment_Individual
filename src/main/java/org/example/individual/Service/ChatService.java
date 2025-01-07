package org.example.individual.Service;

import org.example.individual.Entity.Chat;
import org.example.individual.Pojo.ChatPojo;
import org.example.individual.Pojo.ChatProjection;

import java.util.List;

public interface ChatService {

    List<ChatProjection> findAllChats();

    List<Chat> getConversation(Long senderId, Long receiverId);

    List<Chat> getChatsBySender(Long senderId);

    List<Chat> getChatsByReceiver(Long receiverId);

    List<ChatProjection> getChatsByStatus(boolean status);

    Long save(ChatPojo chatPojo);

    void update(ChatPojo chatPojo);

    void deleteById(Long id);

    Chat findById(Long id);

    void deleteChatsByUserId(Long userId);

    void markAllAsRead(Long userId);
}

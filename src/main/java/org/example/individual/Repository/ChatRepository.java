package org.example.individual.Repository;




import org.example.individual.Entity.Chat;
import org.example.individual.Pojo.ChatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    // Custom query to fetch all chat messages along with sender and receiver details
    @Query(nativeQuery = true, value = "SELECT c.id, c.sender_id AS senderId, c.receiver_id AS receiverId, c.message AS messageContent, c.status AS status, c.created_at AS timestamp " +
            "FROM chat c")
    List<ChatProjection> findAllChats();

    // Method to find all chat messages between two specific users
    @Query("SELECT c FROM Chat c WHERE (c.senderId = ?1 AND c.receiverId = ?2) OR (c.senderId = ?2 AND c.receiverId = ?1) ORDER BY c.createdAt ASC")
    List<Chat> findConversation(Long senderId, Long receiverId);

    // Method to find all unread or sent messages for a specific user (based on the status)
    List<Chat> findByReceiverIdAndStatus(Long receiverId, boolean status);

    // Method to find a specific chat message by ID
    Optional<Chat> findById(Long id);

    // Method to find all messages sent by a specific user
    List<Chat> findBySenderId(Long senderId);

    // Method to find all messages for a specific receiver
    List<Chat> findByReceiverId(Long receiverId);

    // Custom query to find all chat messages for a conversation (sender and receiver)
    @Query("SELECT c FROM Chat c WHERE (c.senderId = ?1 AND c.receiverId = ?2) OR (c.senderId = ?2 AND c.receiverId = ?1) ORDER BY c.createdAt ASC")
    List<ChatProjection> findConversationProjection(Long senderId, Long receiverId);

    // Method to delete all chats for a user (sender or receiver)
    @Query("DELETE FROM Chat c WHERE c.senderId = ?1 OR c.receiverId = ?1")
    void deleteChatsByUserId(Long userId);

    // Method to mark all chats as read for a user (sender or receiver)
    @Query("UPDATE Chat c SET c.status = true WHERE c.senderId = ?1 OR c.receiverId = ?1")
    void markAllChatsAsRead(Long userId);

    List<ChatProjection> findChatsByStatus(boolean status);
}

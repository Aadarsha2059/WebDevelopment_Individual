package org.example.individual.Service.Impl;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.Chat;
import org.example.individual.Pojo.ChatPojo;
import org.example.individual.Pojo.ChatProjection;
import org.example.individual.Repository.ChatRepository;
import org.example.individual.Service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public List<ChatProjection> findAllChats() {
        return chatRepository.findAllChats();
    }

    @Override
    public List<Chat> getConversation(Long senderId, Long receiverId) {
        return chatRepository.findConversation(senderId, receiverId);
    }

    @Override
    public List<Chat> getChatsBySender(Long senderId) {
        return chatRepository.findBySenderId(senderId);
    }

    @Override
    public List<Chat> getChatsByReceiver(Long receiverId) {
        return chatRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<ChatProjection> getChatsByStatus(boolean status) {
        return chatRepository.findChatsByStatus(status);
    }

    @Override
    public Long save(ChatPojo chatPojo) {
        Chat chat = new Chat();
        chat.setSenderId(chatPojo.getSenderId());
        chat.setReceiverId(chatPojo.getReceiverId());
        chat.setMessage(chatPojo.getMessageContent());
        chat.setStatus(chatPojo.isStatus());
        chat.setCreatedAt(chatPojo.getTimestamp());
        chat = chatRepository.save(chat);
        return chat.getId();
    }

    @Override
    public void update(ChatPojo chatPojo) {
        Optional<Chat> chat = chatRepository.findById(chatPojo.getId());
        if (chat.isPresent()) {
            Chat existingChat = chat.get();
            existingChat.setSenderId(chatPojo.getSenderId());
            existingChat.setReceiverId(chatPojo.getReceiverId());
            existingChat.setMessage(chatPojo.getMessageContent());
            existingChat.setCreatedAt(chatPojo.getTimestamp());
            existingChat.setStatus(chatPojo.isStatus());
            chatRepository.save(existingChat);
        }
    }

    @Override
    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }

    @Override
    public Chat findById(Long id) {
        Optional<Chat> chat = chatRepository.findById(id);
        return chat.orElse(null);
    }

    @Override
    public void deleteChatsByUserId(Long userId) {
        chatRepository.deleteChatsByUserId(userId);
    }

    @Override
    public void markAllAsRead(Long userId) {
        chatRepository.markAllChatsAsRead(userId);
    }
}

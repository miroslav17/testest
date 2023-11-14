package service;

import entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String getHelloMessage() {
        return "Hello!";
    }

    @Transactional
    public Message createMessage(String text) {
        Message newMessage = new Message(text);
        return messageRepository.save(newMessage);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    @Transactional
    public Message updateMessage(Long id, String newText) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        message.setText(newText);
        return messageRepository.save(message);
    }

    @Transactional
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}

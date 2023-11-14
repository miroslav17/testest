package entity;

import jakarta.persistence.*;


@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text",unique = true) // за уникалност на полето
    private String text;
    // Конструктори
    public Message() {}

    public Message(String text) {
        this.text = text;
    }

    // Гетъри и сетъри
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
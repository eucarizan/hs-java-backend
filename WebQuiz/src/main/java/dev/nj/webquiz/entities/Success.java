package dev.nj.webquiz.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Success {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long quizId;
    @Column
    private LocalDateTime completedAt;
    @Column
    private String username;
    @ManyToOne
    private User user;

    public Success() {
    }

    public Success(long quizId, User user) {
        this.quizId = quizId;
        this.completedAt = LocalDateTime.now();
        this.username = user.getUsername();
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public long getQuizId() {
        return quizId;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public String getUsername() {
        return username;
    }

    public User getUser() {
        return user;
    }
}

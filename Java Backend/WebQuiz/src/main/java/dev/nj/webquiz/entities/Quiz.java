package dev.nj.webquiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String text;
    @Column
    private String[] options;
    @Column
    private int[] answer = new int[0];

    @ManyToOne(optional = false)
    private User creator;

    public Quiz() {
    }

    public Quiz(String text, String[] options, int[] answer, User user) {
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.creator = user;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int[] getAnswer() {
        return answer;
    }

    public User getCreator() {
        return creator;
    }
}

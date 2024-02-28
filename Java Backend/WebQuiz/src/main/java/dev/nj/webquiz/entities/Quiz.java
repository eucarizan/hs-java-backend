package dev.nj.webquiz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
public class Quiz {
    private String title;
    private String text;
    private String[] options;

    @JsonIgnore
    private int answer;

    public Quiz() {
        createQuiz();
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

    public int getAnswer() {
        return answer;
    }

    public void createQuiz() {
        this.title = "The Java Logo";
        this.text = "What is depicted on the Java logo?";
        this.options = new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"};
        this.answer = 2;
    }
}

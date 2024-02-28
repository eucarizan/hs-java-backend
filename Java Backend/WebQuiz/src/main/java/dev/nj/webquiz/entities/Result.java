package dev.nj.webquiz.entities;

public class Result {
    boolean success;
    String feedback;

    public Result(boolean success) {
        this.success = success;
        this.feedback = setFeedback();
    }

    private String setFeedback() {
        if (success) {
            return "Congratulations, you're right!";
        }
        return "Wrong answer! Please, try again.";
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}

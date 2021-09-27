package com.platform.QuestionAnswer.Model.QuestionAnswer;

import javax.persistence.*;

@Entity
@Table
public class Answers {
    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence"
    )
    private Long answersId;
    private Long questionId;
    private String answer;
    private Long userId;

    public Answers() {
    }

    public Answers(Long questionId, String answer, Long userId) {
        this.questionId = questionId;
        this.answer = answer;
        this.userId = userId;
    }

    public Answers(Long answersId, Long questionId, String answer, Long userId) {
        this.answersId = answersId;
        this.questionId = questionId;
        this.answer = answer;
        this.userId = userId;
    }

    public Long getAnswersId() {
        return answersId;
    }

    public void setAnswersId(Long answersId) {
        this.answersId = answersId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "answersId=" + answersId +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                ", usersId=" + userId +
                '}';
    }
}

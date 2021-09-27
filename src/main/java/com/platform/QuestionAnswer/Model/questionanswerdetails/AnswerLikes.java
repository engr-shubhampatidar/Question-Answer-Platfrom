package com.platform.QuestionAnswer.Model.questionanswerdetails;

import javax.persistence.*;

@Entity
@Table
public class AnswerLikes {
    @Id
    @SequenceGenerator(
            name = "answer_likes_sequence",
            sequenceName = "answer_likes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_likes_sequence"
    )
    private Long answerLikesId;
    private Long answerId;
    private Long userId;
    private Boolean answerLike;

//    @ManyToOne(optional = true)
//    @JoinColumn(name = "answer_id", insertable = false, updatable = false)
//    private Answers answers;

    public AnswerLikes() {
    }

    public AnswerLikes(Long answer_id, Long user_id, Boolean answerLike) {
        this.answerId = answer_id;
        this.userId = user_id;
        this.answerLike = answerLike;
    }

    public AnswerLikes(Long answerLikes_id, Long answer_id, Long user_id, Boolean answerLike) {
        this.answerLikesId = answerLikes_id;
        this.answerId = answer_id;
        this.userId = user_id;
        this.answerLike = answerLike;
    }

    public Long getAnswerLikesId() {
        return answerLikesId;
    }

    public void setAnswerLikesId(Long answerLikesId) {
        this.answerLikesId = answerLikesId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getAnswerLike() {
        return answerLike;
    }

    public void setAnswerLike(Boolean answerLike) {
        this.answerLike = answerLike;
    }

    @Override
    public String toString() {
        return "AnswerLikes{" +
                "answerLikes_id=" + answerLikesId +
                ", answer_id=" + answerId +
                ", user_id=" + userId +
                ", answerLike=" + answerLike +
                '}';
    }
}

package com.platform.QuestionAnswer.Model.questionanswerdetails;

import javax.persistence.*;

@Entity
@Table
public class QuestionLikes {
    @Id
    @SequenceGenerator(
            name = "question_likes_sequence",
            sequenceName = "question_likes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_likes_sequence"
    )
    private Long questionLikesId;
    private Long questionId;
    private Long userId;
    private Boolean questionLike;

//    @ManyToOne(optional = true)
//    @JoinColumn(name = "question_id", insertable = false, updatable = false)
//    private Questions questions;

    public QuestionLikes() {
    }

    public QuestionLikes(Long questionId, Long userId, Boolean questionLike) {
        this.questionId = questionId;
        this.userId = userId;
        this.questionLike = questionLike;
    }

    public QuestionLikes(Long questionLikesId, Long questionId, Long userId, Boolean questionLike) {
        this.questionLikesId = questionLikesId;
        this.questionId = questionId;
        this.userId = userId;
        this.questionLike = questionLike;
    }

    public Long getQuestionLikesId() {
        return questionLikesId;
    }

    public void setQuestionLikesId(Long questionLikesId) {
        this.questionLikesId = questionLikesId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getQuestionLike() {
        return questionLike;
    }

    public void setQuestionLike(Boolean questionLike) {
        this.questionLike = questionLike;
    }

    @Override
    public String toString() {
        return "QuestionLikes{" +
                "question_likes=" + questionLikesId +
                ", question_id=" + questionId +
                ", user_id=" + userId +
                ", like=" + questionLike +
                '}';
    }
}

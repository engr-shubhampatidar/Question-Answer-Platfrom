package com.platform.QuestionAnswer.Model.questionanswerdetails;

import javax.persistence.*;

@Entity
@Table
public class Comments {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Long id;
    private Long answerId;
    private Long userId;
    private String comments;

    public Comments() {
    }

    public Comments(Long answerId, Long userId, String comments) {
        this.answerId = answerId;
        this.userId = userId;
        this.comments = comments;
    }

    public Comments(Long id, Long answerId , Long usersId, String comments) {
        this.id = id;
        this.answerId = answerId;
        this.userId = usersId;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", answer_id=" + answerId +
                ", user_id=" + userId +
                ", comments='" + comments + '\'' +
                '}';
    }
}

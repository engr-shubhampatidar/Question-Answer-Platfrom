package com.platform.QuestionAnswer.Model.QuestionAnswer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class Questions {
    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private Long questionId;
    @Size(min = 50, max = 500)
    private String question;
    private Long companyId;
    private Long subtopicId;
    private String tags;
    private Long userId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "company_id", insertable = false, updatable = false)
//    private Company company;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "subtopic_id", insertable = false, updatable = false)
//    private Subtopics subtopics;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tags_id", insertable = false, updatable = false)
//    private Tags tag;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "users_id", insertable = false, updatable = false)
//    private Users users;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "question_id", insertable = false, updatable = false)
//    private List<Answers> answers;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "questionLikes_id")
//    private QuestionLikes questionLikes;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "questions_id",
            referencedColumnName = "questionId"
    )
    private List<Answers> answers;

    public Questions() {
    }

    public Questions(@Size(min = 50, max = 500) String question,
                     Long companyId,
                     Long subtopicId,
                     String tag,
                     Long userId) {
        this.question = question;
        this.companyId = companyId;
        this.subtopicId = subtopicId;
        this.tags = tag;
        this.userId = userId;
    }

    public Questions(Long id,
                     @Size(min = 50, max = 500) String question,
                     Long companyId,
                     Long subtopicId,
                     String tag,
                     Long userId) {
        this.questionId = id;
        this.question = question;
        this.companyId = companyId;
        this.subtopicId = subtopicId;
        this.tags = tag;
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(Long subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + questionId +
                ", question='" + question + '\'' +
                ", company_id=" + companyId +
                ", subtopic_id=" + subtopicId +
                ", tags='" + tags + '\'' +
                ", user_id=" + userId +
                '}';
    }
}


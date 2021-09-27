package com.platform.QuestionAnswer.Model.masterdata;

import javax.persistence.*;

@Entity
@Table
public class Subtopics {
    @Id
    @SequenceGenerator(
            name = "subtopic_sequence",
            sequenceName = "subtopic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subtopic_sequence"
    )
    private Long subtopicId;
    private String subtopic;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Questions questions;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "topic_id",
//            referencedColumnName = "topicId")
//    private List<Topics> topics;

    public Subtopics() {
    }

    public Subtopics(String subtopic) {
        this.subtopic = subtopic;
    }

    public Subtopics(Long subtopic_id, String subtopic) {
        this.subtopicId = subtopic_id;
        this.subtopic = subtopic;
    }

    public Long getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(Long subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }

    @Override
    public String toString() {
        return "Subtopics{" +
                "subtopic_id=" + subtopicId +
                ", subtopic='" + subtopic + '\'' +
                '}';
    }
}

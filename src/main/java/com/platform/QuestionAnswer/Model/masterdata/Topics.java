package com.platform.QuestionAnswer.Model.masterdata;

import javax.persistence.*;

@Entity
@Table
public class Topics {
    @Id
    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence"
    )
    private Long topicId;
    private String topic;

    public Topics() {
    }

    public Topics(String topic) {
        this.topic = topic;
    }

    public Topics(Long topic_id, String topic) {
        this.topicId = topic_id;
        this.topic = topic;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "topic_id=" + topicId +
                ", topic='" + topic + '\'' +
                '}';
    }
}

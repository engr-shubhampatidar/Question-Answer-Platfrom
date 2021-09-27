package com.platform.QuestionAnswer.Model.masterdata;

import javax.persistence.*;

@Entity
@Table
public class Tags {
    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    private Long tagId;
    private String tag;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Questions questions;

    public Tags() {
    }

    public Tags(String tags) {
        this.tag = tags;
    }

    public Tags(Long tags_id, String tags) {
        this.tagId = tags_id;
        this.tag = tags;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tags_id=" + tagId +
                ", tags='" + tag + '\'' +
                '}';
    }
}

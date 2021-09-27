package com.platform.QuestionAnswer.Model.user;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
    private String users;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "question_id")
//    private Questions questions;

    public Users() {
    }

    public Users(String user) {
        this.users = user;
    }

    public Users(Long user_id, String user) {
        this.userId = user_id;
        this.users = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + userId +
                ", user='" + users + '\'' +
                '}';
    }
}

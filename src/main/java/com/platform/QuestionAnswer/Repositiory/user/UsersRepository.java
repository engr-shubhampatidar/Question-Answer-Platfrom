package com.platform.QuestionAnswer.Repositiory.user;

import com.platform.QuestionAnswer.Model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}

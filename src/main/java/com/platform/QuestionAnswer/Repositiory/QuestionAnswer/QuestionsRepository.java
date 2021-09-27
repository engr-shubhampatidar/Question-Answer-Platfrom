package com.platform.QuestionAnswer.Repositiory.QuestionAnswer;

import com.platform.QuestionAnswer.Model.QuestionAnswer.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

}

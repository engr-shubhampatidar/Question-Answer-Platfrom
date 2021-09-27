package com.platform.QuestionAnswer.Repositiory.QuestionAnswer;

import com.platform.QuestionAnswer.Model.QuestionAnswer.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers, Long> {

    @Query("SELECT a FROM Answers a WHERE a.questionId=?1")
    List<Answers> findAnswersByQuestionId(Long questionId);
}

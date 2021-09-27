package com.platform.QuestionAnswer.Service.QuestionAnswer;

import com.platform.QuestionAnswer.Model.QuestionAnswer.Answers;
import com.platform.QuestionAnswer.Repositiory.QuestionAnswer.AnswersRepository;
import com.platform.QuestionAnswer.Repositiory.QuestionAnswer.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnswersService {
    @Autowired
    private final AnswersRepository answersRepository;

    @Autowired
    private final QuestionsRepository questionsRepository;

    public AnswersService(AnswersRepository answersRepository,
                          QuestionsRepository questionsRepository) {
        this.answersRepository = answersRepository;
        this.questionsRepository = questionsRepository;
    }

    // To get the list of answers
    public List<Answers> getAnswers() {
        return answersRepository.findAll();
    }

    // To add new answer to a question
    public Long postAnswer(Answers answers, Long questionId, Long userId) {
        questionsRepository.findById(questionId).orElseThrow(() ->
                new IllegalStateException("Question with the question id " + questionId + " not found !!"));
        Answers answers1 = new Answers(questionId,answers.getAnswer(),userId);
        answers1.setQuestionId(questionId);
        answers1.setAnswer(answers.getAnswer());
        answers1.setUserId(answers.getUserId());
        answersRepository.save(answers1);
        return answers1.getAnswersId();
    }

    @Transactional
    public void updateAnswer(Long answerId, Answers answers) {
        Answers answers1 = answersRepository.findById(answerId).orElseThrow(() ->
                new IllegalStateException("Answer with id " + answerId + "not found"));
        if(answers != null && answers.getAnswer().length() > 0){
            answers1.setAnswer(answers.getAnswer());
        }
    }

    public void deleteAnswer(Long answerId) {
        answersRepository.deleteById(answerId);
    }
}

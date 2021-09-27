package com.platform.QuestionAnswer.Service.QuestionAnswer;

import com.platform.QuestionAnswer.Model.QuestionAnswer.Answers;
import com.platform.QuestionAnswer.Model.QuestionAnswer.Questions;
import com.platform.QuestionAnswer.Repositiory.QuestionAnswer.AnswersRepository;
import com.platform.QuestionAnswer.Repositiory.QuestionAnswer.QuestionsRepository;
import com.platform.QuestionAnswer.Repositiory.master.CompanyRepository;
import com.platform.QuestionAnswer.Repositiory.master.TagsRepository;
import com.platform.QuestionAnswer.Repositiory.master.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class QuestionsService {
    @Autowired
    private final QuestionsRepository questionsRepository;

    @Autowired
    private final AnswersRepository answersRepository;

//    @Autowired
//    private final AnswerLikesRepository answerLikesRepository;
//
//    @Autowired
//    private final QuestionLikesRepository questionLikesRepository;
//
//    @Autowired
//    private final CommentsRepository commentsRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final TagsRepository tagsRepository;

    @Autowired
    private final TopicsRepository topicsRepository;

    public QuestionsService(QuestionsRepository questionsRepository,
                            AnswersRepository answersRepository,
//                            AnswerLikesRepository answerLikesRepository,
//                            QuestionLikesRepository questionLikesRepository,
//                            CommentsRepository commentsRepository,
                            CompanyRepository companyRepository,
                            TagsRepository tagsRepository,
                            TopicsRepository topicsRepository) {
        this.questionsRepository = questionsRepository;
        this.answersRepository = answersRepository;
//        this.answerLikesRepository = answerLikesRepository;
//        this.questionLikesRepository = questionLikesRepository;
//        this.commentsRepository = commentsRepository;
        this.companyRepository = companyRepository;
        this.tagsRepository = tagsRepository;
        this.topicsRepository = topicsRepository;
    }


    public HashMap<Questions, List<Answers>> getQuestion(Long question_id) {
        Questions questions1 = questionsRepository.findById(question_id).orElseThrow(() ->
            new IllegalStateException("Question not found !!"));
        List<Answers> answers1 = answersRepository.findAnswersByQuestionId(question_id);
        HashMap<Questions, List<Answers>> questionAnswerDetails = new HashMap<>();
        questionAnswerDetails.put(questions1, answers1);
        return questionAnswerDetails;
    }


    public Long postQuestion(Questions question, Long companyId, Long subtopicId, String tag, Long userId) {
         Questions questions1 = new Questions();
         questions1.setCompanyId(companyId);
         questions1.setTags(tag);
         questions1.setSubtopicId(subtopicId);
         questions1.setUserId(userId);
         questionsRepository.save(question);
         return question.getQuestionId();
    }

    public void deleteQuestion(Long question_id) {
        questionsRepository.deleteById(question_id);
    }

    @Transactional
    public void updateQuestion(Long question_id, Questions questions) {
        Questions questions1 = questionsRepository.findById(question_id).orElseThrow(() ->
                new IllegalStateException("There is no question with id " + question_id));
        if(questions != null &&
                questions.getQuestion().length() > 0){
            questions1.setQuestion(questions.getQuestion());
        }
        questionsRepository.save(questions1);
    }

    public List<Questions> getQuestions() {
        return questionsRepository.findAll();
    }
}

package com.platform.QuestionAnswer.DAO;

import com.platform.QuestionAnswer.Model.QuestionAnswer.Answers;
import com.platform.QuestionAnswer.Model.QuestionAnswer.Questions;
import com.platform.QuestionAnswer.Model.masterdata.Company;
import com.platform.QuestionAnswer.Model.masterdata.Tags;
import com.platform.QuestionAnswer.Model.masterdata.Topics;
import com.platform.QuestionAnswer.Model.questionanswerdetails.QuestionLikes;
import com.platform.QuestionAnswer.Repositiory.QuestionAnswer.AnswersRepository;
import com.platform.QuestionAnswer.Repositiory.QuestionAnswer.QuestionsRepository;
import com.platform.QuestionAnswer.Repositiory.master.CompanyRepository;
import com.platform.QuestionAnswer.Repositiory.master.TagsRepository;
import com.platform.QuestionAnswer.Repositiory.master.TopicsRepository;
import com.platform.QuestionAnswer.Repositiory.questionanswerdetails.QuestionLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionAnswers {
    @Autowired
    private final AnswersRepository answersRepository;

    @Autowired
    private final QuestionsRepository questionsRepository;

    @Autowired
    private final QuestionLikesRepository questionLikesRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final TagsRepository tagsRepository;

    @Autowired
    private final TopicsRepository topicsRepository;

    public QuestionAnswers(AnswersRepository answersRepository,
                           QuestionsRepository questionsRepository,
                           QuestionLikesRepository questionLikesRepository,
                           CompanyRepository companyRepository,
                           TagsRepository tagsRepository,
                           TopicsRepository topicsRepository) {
        this.answersRepository = answersRepository;
        this.questionsRepository = questionsRepository;
        this.questionLikesRepository = questionLikesRepository;
        this.companyRepository = companyRepository;
        this.tagsRepository = tagsRepository;
        this.topicsRepository = topicsRepository;
    }

    public Map<QuestionDetail, List<Answers>> getQuestionsAnswers(long questionId){
        Questions questions = questionsRepository.getById(questionId);
        QuestionLikes questionLikes = questionLikesRepository.getById(questionId);
        Company company = companyRepository.getById(questionId);
        Tags tags = tagsRepository.getById(questionId);
        Topics topics = topicsRepository.getById(questionId);

        QuestionDetail questionDetail = new QuestionDetail();
        questionDetail.setQuestionText(questions.getQuestion());
        questionDetail.setQuestionLikes(questionLikes.getQuestionLike());
        questionDetail.setCompany(company.getCompany());
        questionDetail.setTag(tags.getTag());
        questionDetail.setTopics(topics.getTopic());

        List<Answers> answers;
        answers = answersRepository.findAnswersByQuestionId(questionId);
        Map<QuestionDetail, List<Answers>> questionsListMap = new HashMap<>();
        questionsListMap.put(questionDetail, answers);
        return questionsListMap;
    }
}


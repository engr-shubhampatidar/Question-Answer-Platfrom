package com.platform.QuestionAnswer.Service.questionanswerdetails;

import com.platform.QuestionAnswer.Model.questionanswerdetails.QuestionLikes;
import com.platform.QuestionAnswer.Repositiory.questionanswerdetails.QuestionLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionLikesService {
    @Autowired
    private final QuestionLikesRepository questionLikesRepository;

    public QuestionLikesService(QuestionLikesRepository questionLikesRepository) {
        this.questionLikesRepository = questionLikesRepository;
    }

    public Boolean postLike(Long questionId, Long userId, QuestionLikes questionLike) {
        questionLike.setQuestionId(questionId);
        questionLike.setUserId(questionLike.getUserId());
        questionLike.setQuestionLike(questionLike.getQuestionLike());
        questionLikesRepository.save(questionLike);
        return questionLike.getQuestionLike();
    }

}

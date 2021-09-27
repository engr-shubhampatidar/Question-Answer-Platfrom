package com.platform.QuestionAnswer.Service.questionanswerdetails;

import com.platform.QuestionAnswer.Model.questionanswerdetails.AnswerLikes;
import com.platform.QuestionAnswer.Repositiory.questionanswerdetails.AnswerLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerLikeService {
    @Autowired
    private final AnswerLikesRepository answerLikesRepository;

    public AnswerLikeService(AnswerLikesRepository answerLikesRepository) {
        this.answerLikesRepository = answerLikesRepository;
    }

    public void postAnswer(Long answer_id, Long user_id, AnswerLikes answerLike) {
        AnswerLikes answerLikes1 = new AnswerLikes();
        answerLikes1.setAnswerId(answer_id);
        answerLikes1.setUserId(answerLikes1.getUserId());
        answerLikes1.setAnswerLike(answerLike.getAnswerLike());
        answerLikesRepository.save(answerLikes1);
    }
}

package com.platform.QuestionAnswer.Controller.questionanswerdetails;

import com.platform.QuestionAnswer.Model.questionanswerdetails.AnswerLikes;
import com.platform.QuestionAnswer.Model.questionanswerdetails.QuestionLikes;
import com.platform.QuestionAnswer.Service.questionanswerdetails.AnswerLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerLikeController {
    @Autowired
    private final AnswerLikeService answerLikeService;

    public AnswerLikeController(AnswerLikeService answerLikeService) {
        this.answerLikeService = answerLikeService;
    }


    @ResponseBody
    @PostMapping(path = "/answer_likes/{answer_id}/{user_id}")
    void postAnswerLikes(@PathVariable Long answer_id,
                         Long user_id,
                         @RequestParam AnswerLikes answerLike){
        answerLikeService.postAnswer(answer_id, user_id, answerLike);
    }
}

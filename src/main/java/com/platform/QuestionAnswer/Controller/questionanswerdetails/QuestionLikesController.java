package com.platform.QuestionAnswer.Controller.questionanswerdetails;

import com.platform.QuestionAnswer.Model.questionanswerdetails.QuestionLikes;
import com.platform.QuestionAnswer.Service.questionanswerdetails.QuestionLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionLikesController {
    @Autowired
    private final QuestionLikesService questionLikesService;

    public QuestionLikesController(QuestionLikesService questionLikesService) {
        this.questionLikesService = questionLikesService;
    }

    @ResponseBody
    @PostMapping(path = "/questionLikes/{questionId}")
    Boolean postLikes(@PathVariable Long questionId,
                      @RequestBody QuestionLikes questionLike,
                      Long userId){
        return questionLikesService.postLike(questionId, userId, questionLike);
    }
}

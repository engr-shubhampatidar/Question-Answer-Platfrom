package com.platform.QuestionAnswer.Controller.questionanswerdetails;

import com.platform.QuestionAnswer.Model.questionanswerdetails.Comments;
import com.platform.QuestionAnswer.Service.questionanswerdetails.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {
    @Autowired
    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping(path = "/comments")
    List<Comments> getComments(){
        return commentsService.getComments();
    }

    @ResponseBody
    @PostMapping(path = "/comments/{answerId}")
    Long postComments(@PathVariable Long answerId,
                      @RequestBody Comments comments,
                      Long userId){
        return commentsService.postComments(answerId, userId, comments);
    }
}

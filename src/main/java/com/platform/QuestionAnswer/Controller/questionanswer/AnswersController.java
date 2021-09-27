package com.platform.QuestionAnswer.Controller.questionanswer;

import com.platform.QuestionAnswer.Model.QuestionAnswer.Answers;
import com.platform.QuestionAnswer.Service.QuestionAnswer.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswersController {
    @Autowired
    private final AnswersService answersService;

    public AnswersController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @GetMapping(path = "/answers")
    List<Answers> getAnswer(){
        return answersService.getAnswers();
    }

    @ResponseBody
    @PostMapping(path = "/answer/{questionId}")
    Long postAnswer(@PathVariable Long questionId,
                    @RequestBody Answers answers,
                    Long userId){
        return answersService.postAnswer(answers, questionId, userId);
    }

    @ResponseBody
    @PutMapping(path = "/answer/{answerId}")
    void updateAnswer(@PathVariable Long answerId,
                    @RequestBody Answers answers){
        answersService.updateAnswer(answerId, answers);
    }

    @DeleteMapping(path = "/answer/{answerId}")
    void deleteAnswer(@PathVariable Long answerId){
        answersService.deleteAnswer(answerId);
    }
}

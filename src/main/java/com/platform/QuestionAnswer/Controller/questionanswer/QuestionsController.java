package com.platform.QuestionAnswer.Controller.questionanswer;

import com.platform.QuestionAnswer.DAO.QuestionAnswers;
import com.platform.QuestionAnswer.DAO.QuestionDetail;
import com.platform.QuestionAnswer.Model.QuestionAnswer.Answers;
import com.platform.QuestionAnswer.Model.QuestionAnswer.Questions;
import com.platform.QuestionAnswer.Service.QuestionAnswer.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionsController {
    @Autowired
    private final QuestionsService questionsService;

    private final QuestionAnswers questionAnswers;

    public QuestionsController(QuestionsService questionsService,
                               QuestionAnswers questionAnswers) {
        this.questionsService = questionsService;
        this.questionAnswers = questionAnswers;
    }

    @GetMapping(path = "/questions")
    List<Questions> getAllQuestions(){
        return questionsService.getQuestions();
    }

    @GetMapping(path = "/question/{question_id}")
    Map<QuestionDetail, List<Answers>> getQuestions(@PathVariable Long question_id){
        return questionAnswers.getQuestionsAnswers(question_id);
    }

    @ResponseBody
    @PostMapping(path = "/question")
    Long postQuestions(@RequestBody Questions question,
                      Long companyId,
                      Long subtopicId,
                      String tag,
                      Long userId){
       return questionsService.postQuestion(question,companyId,subtopicId,tag,userId);
    }

    @PutMapping(path = "/question/{question_id}")
    void updateQuestion(@PathVariable Long question_id,
                        @RequestBody Questions questions){
        questionsService.updateQuestion(question_id, questions);
    }

    @DeleteMapping(path = "/question/{question_id}")
    void deleteQuestion(@PathVariable Long question_id){
        questionsService.deleteQuestion(question_id);
    }
}

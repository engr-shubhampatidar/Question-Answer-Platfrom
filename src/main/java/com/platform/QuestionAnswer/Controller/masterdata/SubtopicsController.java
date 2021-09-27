package com.platform.QuestionAnswer.Controller.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Subtopics;
import com.platform.QuestionAnswer.Service.masterdata.SubtopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubtopicsController {
    @Autowired
    private final SubtopicsService subtopicsService;

    public SubtopicsController(SubtopicsService subtopicsService) {
        this.subtopicsService = subtopicsService;
    }

    @GetMapping(path = "/subtopic")
    List<Subtopics> getSubtopic(){
      return subtopicsService.getSubtopics();
    }

    @ResponseBody
    @PostMapping(path = "/subtopic")
    void postSubtopic(@RequestBody Subtopics subtopic){
        subtopicsService.postSubtopic(subtopic);
    }

    @PutMapping(path = "/subtopic/{subtopicId}")
    void updateSubtopic(@PathVariable Long subtopicId,@RequestParam String subtopic){
        subtopicsService.updateSubtopic(subtopicId, subtopic);
    }

    @DeleteMapping(path = "/subtopic/{subtopicId}")
    void deleteSubtopic(@PathVariable Long subtopicId){
        subtopicsService.deleteSubtopic(subtopicId);
    }
}

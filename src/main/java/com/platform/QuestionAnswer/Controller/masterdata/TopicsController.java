package com.platform.QuestionAnswer.Controller.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Topics;
import com.platform.QuestionAnswer.Service.masterdata.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicsController {
    @Autowired
    private final TopicsService topicsService;

    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    @GetMapping(path = "/topic")
    List<Topics> getTopics(){
       return topicsService.getTopics();
    }

    @ResponseBody
    @PostMapping(path = "/topic")
    void postTopic(@RequestBody Topics topic){
        topicsService.postTopic(topic);
    }

    @PutMapping(path = "/topic/{topicId}")
    void updateTopic(@PathVariable Long topicId, @RequestParam String topic){
        topicsService.updateTopic(topicId, topic);
    }

    @DeleteMapping(path = "/topic/{topicId}")
    void deleteTopic(@PathVariable Long topicId){
        topicsService.deleteTopics(topicId);
    }
}

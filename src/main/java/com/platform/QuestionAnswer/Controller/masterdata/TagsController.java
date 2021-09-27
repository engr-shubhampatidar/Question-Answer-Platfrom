package com.platform.QuestionAnswer.Controller.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Tags;
import com.platform.QuestionAnswer.Service.masterdata.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagsController {
    @Autowired
    private final TagsService tagsService;

    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping(path = "/tag")
    List<Tags> getTags(){
        return tagsService.getTags();
    }

    @ResponseBody
    @PostMapping(path = "/tag")
    void postTag(@RequestBody Tags tag){
        tagsService.postTags(tag);
    }

    @PutMapping(path = "/tag/{tagId}")
    void updateTag(@PathVariable Long tagId, @RequestParam String tag){
        tagsService.updateTag(tagId, tag);
    }


    @DeleteMapping(path = "/tag/{tagId}")
    void deleteTag(@PathVariable Long tagId){
        tagsService.deleteTag(tagId);
    }
}

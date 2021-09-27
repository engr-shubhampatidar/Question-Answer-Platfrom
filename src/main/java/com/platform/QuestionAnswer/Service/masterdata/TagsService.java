package com.platform.QuestionAnswer.Service.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Tags;
import com.platform.QuestionAnswer.Repositiory.master.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TagsService {
    @Autowired
    private final TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public List<Tags> getTags() {
       return tagsRepository.findAll();
    }

    public void postTags(Tags tag) {
        tagsRepository.save(tag);
    }

    public void deleteTag(Long tag_id) {
        tagsRepository.deleteById(tag_id);
    }

    @Transactional
    public void updateTag(Long tag_id, String tag) {
        Tags tag1 = tagsRepository.findById(tag_id).orElseThrow(() ->
                new IllegalStateException("Tag with id" + tag_id + " not found"));
        if(tag != null &&
                tag.length() > 0){
            tag1.setTag(tag);
        }
    }
}

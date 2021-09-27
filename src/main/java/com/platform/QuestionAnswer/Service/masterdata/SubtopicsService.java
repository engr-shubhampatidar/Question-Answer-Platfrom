package com.platform.QuestionAnswer.Service.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Subtopics;
import com.platform.QuestionAnswer.Repositiory.master.SubtopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubtopicsService {
    @Autowired
    private final SubtopicsRepository subtopicsRepository;

    public SubtopicsService(SubtopicsRepository subtopicsRepository) {
        this.subtopicsRepository = subtopicsRepository;
    }

    public List<Subtopics> getSubtopics() {
        return subtopicsRepository.findAll();
    }

    public void postSubtopic(Subtopics subtopic) {
        subtopicsRepository.save(subtopic);
    }

    @Transactional
    public void updateSubtopic(Long subtopic_id, String subtopic) {
        Subtopics subtopics1 = subtopicsRepository.findById(subtopic_id).orElseThrow(() ->
                new IllegalStateException("Subtopic with id" + subtopic_id + "not found"));
        if(subtopic != null &&
               subtopic.length() > 0){
            subtopics1.setSubtopic(subtopic);
        }
    }

    public void deleteSubtopic(Long subtopic_id) {
        subtopicsRepository.deleteById(subtopic_id);
    }
}

package com.platform.QuestionAnswer.Service.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Topics;
import com.platform.QuestionAnswer.Repositiory.master.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TopicsService {
    @Autowired
    private final TopicsRepository topicsRepository;

    public TopicsService(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    public List<Topics> getTopics() {
       return topicsRepository.findAll();
    }

    public void postTopic(Topics topic) {
        topicsRepository.save(topic);
    }


    public void deleteTopics(Long topic_id) {
        topicsRepository.deleteById(topic_id);
    }

    @Transactional
    public void updateTopic(Long topic_id, String topic) {
        Topics topic1 = topicsRepository.findById(topic_id).orElseThrow(() ->
                new IllegalStateException("Topic with topic_id" + topic_id + " not found"));

        if(topic != null &&
                topic.length() > 0){
            topic1.setTopic(topic);
        }
    }
}

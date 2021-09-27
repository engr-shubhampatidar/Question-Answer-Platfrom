package com.platform.QuestionAnswer.Service.questionanswerdetails;

import com.platform.QuestionAnswer.Model.questionanswerdetails.Comments;
import com.platform.QuestionAnswer.Repositiory.questionanswerdetails.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<Comments> getComments() {
        return commentsRepository.findAll();
    }

    
    public Long postComments(Long answerId, Long userId, Comments comments) {
//        Comments comments1 = commentsRepository.findById(answerId).orElseThrow(() ->
//                new IllegalStateException("Answer with the " + answerId + " not found"));
        Comments comments1 = new Comments(answerId, comments.getUserId(), comments.getComments());
        commentsRepository.save(comments1);
        return comments1.getId();
    }
}

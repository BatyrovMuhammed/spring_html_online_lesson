package legendSoft.service;

import legendSoft.model.Comment;
import legendSoft.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public List<Comment> getCommentByHouseId(Long id){
        return commentRepository.getAllComments(id);
    }
    public void saveCommentToHouse(Long id, Comment comment){
        commentRepository.saveCommentToHouse(id, comment);
    }
}

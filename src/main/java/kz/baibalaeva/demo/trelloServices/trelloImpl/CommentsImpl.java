package kz.baibalaeva.demo.trelloServices.trelloImpl;

import kz.baibalaeva.demo.trelloModels.Comments;
import kz.baibalaeva.demo.trelloRepositories.CommentsRepository;
import kz.baibalaeva.demo.trelloServices.CommentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsImpl implements CommentsServices {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments addComments(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public Comments saveComments(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public void deleteComments(Comments comments) {
    commentsRepository.delete(comments);
    }

    @Override
    public Comments getComment(Long id) {
        return commentsRepository.getOne(id);
    }
}

package kz.baibalaeva.demo.trelloServices;

import kz.baibalaeva.demo.trelloModels.Comments;

import java.util.List;

public interface CommentsServices {

    List<Comments> getAllComments();
    Comments addComments(Comments comments);
    Comments saveComments(Comments comments);
    void deleteComments(Comments comments);
    Comments getComment(Long id);
}

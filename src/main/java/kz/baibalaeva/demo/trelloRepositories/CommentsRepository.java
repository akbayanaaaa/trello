package kz.baibalaeva.demo.trelloRepositories;

import kz.baibalaeva.demo.trelloModels.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentsRepository extends JpaRepository<Comments, Long> {
}

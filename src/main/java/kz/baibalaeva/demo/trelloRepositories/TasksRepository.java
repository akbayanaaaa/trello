package kz.baibalaeva.demo.trelloRepositories;

import kz.baibalaeva.demo.trelloModels.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    void deleteTasksByFoldersId(Long id);
}

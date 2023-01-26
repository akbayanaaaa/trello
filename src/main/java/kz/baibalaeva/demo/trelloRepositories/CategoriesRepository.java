package kz.baibalaeva.demo.trelloRepositories;

import kz.baibalaeva.demo.trelloModels.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CategoriesRepository extends JpaRepository<TaskCategories, Long> {

}

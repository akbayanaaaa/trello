package kz.baibalaeva.demo.trelloServices;

import kz.baibalaeva.demo.trelloModels.TaskCategories;

import java.util.List;

public interface CategoriesServices {
    List<TaskCategories> getAllCategories ();
    TaskCategories addCategories(TaskCategories taskCategories);
    TaskCategories saveCategories(TaskCategories taskCategories);
    void deleteCategories(TaskCategories taskCategories);
    TaskCategories getCategory(Long id);
}

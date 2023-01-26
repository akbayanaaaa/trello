package kz.baibalaeva.demo.trelloServices.trelloImpl;

import kz.baibalaeva.demo.trelloModels.TaskCategories;
import kz.baibalaeva.demo.trelloRepositories.CategoriesRepository;
import kz.baibalaeva.demo.trelloServices.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategotyImpl implements CategoriesServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<TaskCategories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public TaskCategories addCategories(TaskCategories taskCategories) {
        return categoriesRepository.save(taskCategories);
    }

    @Override
    public TaskCategories saveCategories(TaskCategories taskCategories) {
        return categoriesRepository.save(taskCategories);
    }

    @Override
    public void deleteCategories(TaskCategories taskCategories) {
        categoriesRepository.delete(taskCategories);
    }

    @Override
    public TaskCategories getCategory(Long id) {
        return categoriesRepository.getOne(id);
    }
}

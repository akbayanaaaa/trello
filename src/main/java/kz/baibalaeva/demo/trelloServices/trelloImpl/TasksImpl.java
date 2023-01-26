package kz.baibalaeva.demo.trelloServices.trelloImpl;

import kz.baibalaeva.demo.trelloModels.Tasks;
import kz.baibalaeva.demo.trelloRepositories.TasksRepository;
import kz.baibalaeva.demo.trelloServices.TasksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksImpl implements TasksServices {

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks addTasks(Tasks tasks) {
        return tasksRepository.save(tasks);
    }

    @Override
    public Tasks saveTasks(Tasks tasks) {
        return tasksRepository.save(tasks);
    }

    @Override
    public void deleteTasks(Tasks tasks) {
    tasksRepository.delete(tasks);
    }

    @Override
    public Tasks getTask(Long id) {
        return tasksRepository.getOne(id);
    }

    @Override
    public void deleteTasksByFoldersId(Long id) {
        tasksRepository.deleteTasksByFoldersId(id);
    }
}

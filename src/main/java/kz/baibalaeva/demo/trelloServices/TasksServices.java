package kz.baibalaeva.demo.trelloServices;

import kz.baibalaeva.demo.trelloModels.Tasks;

import java.util.List;

public interface TasksServices {
    List<Tasks> getAllTasks();
    Tasks addTasks(Tasks tasks);
    Tasks saveTasks(Tasks tasks);
    void  deleteTasks(Tasks tasks);
    Tasks getTask(Long id);

    void  deleteTasksByFoldersId(Long id);
}

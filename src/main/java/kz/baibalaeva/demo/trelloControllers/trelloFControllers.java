package kz.baibalaeva.demo.trelloControllers;

import kz.baibalaeva.demo.trelloModels.Comments;
import kz.baibalaeva.demo.trelloModels.Folders;
import kz.baibalaeva.demo.trelloModels.TaskCategories;

import kz.baibalaeva.demo.trelloModels.Tasks;
import kz.baibalaeva.demo.trelloServices.CategoriesServices;
import kz.baibalaeva.demo.trelloServices.CommentsServices;
import kz.baibalaeva.demo.trelloServices.FoldersServices;
import kz.baibalaeva.demo.trelloServices.TasksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class trelloFControllers {

    @Autowired
    private FoldersServices foldersServices;

    @Autowired
    private CategoriesServices categoriesService;

    @Autowired
    private TasksServices tasksServices;

    @Autowired
    private CommentsServices commentsServices;


    @GetMapping(value = "/trelloF")
    public String getAllF(Model model){
        model.addAttribute("folders", foldersServices.getAllFolders());
        return "trelloF";

    }

    @GetMapping(value = "/trelloAddCategories")
    public String getAllCat(Model model){
        model.addAttribute("categories", categoriesService.getAllCategories());
        return "trelloAddCategories";

    }

    @PostMapping(value = "/trelloAddCategories")
    public String trelloAddCategories(@RequestParam(name = "name", defaultValue = "") String name){
        TaskCategories taskCategories=new TaskCategories();
        taskCategories.setName(name);
        categoriesService.addCategories(taskCategories);

        return "redirect:/trelloF";

    }





    @PostMapping(value = "/addF")
    public String addF(@RequestParam(name = "name", defaultValue = "") String name){
        Folders folders=new Folders();
        folders.setName(name);
        foldersServices.addFolders(folders);

        return "redirect:/trelloF";

    }

    @PostMapping(value = "/addTa")
    public String addTa(Model model,
                        @RequestParam(name = "folder_id", defaultValue = "0L") Long id,
                       @RequestParam(name = "title", defaultValue = "") String title,
                       @RequestParam(name = "description", defaultValue = "") String description,
                       @RequestParam(name = "status", defaultValue = "") int status){

        Folders folders=foldersServices.getFolders(id);
        if (folders!=null){
            Tasks tasks=new Tasks();
            tasks.setTitle(title);
            tasks.setDescription(description);
            tasks.setStatus(status);
            tasks.setFolders(folders);
            tasksServices.addTasks(tasks);
        }
        return "redirect:/trelloD/" + id;

    }

    @PostMapping(value = "/deleteF")
    public String deleteF(@RequestParam(name = "id", defaultValue = "0") Long id){
        Folders folders=foldersServices.getFolders(id);

        if (folders!=null){
           tasksServices.deleteTasksByFoldersId(id);
            foldersServices.deleteFolders(folders);

        }
        return "redirect:/trelloF";
    }


    @PostMapping(value = "/deleteTrello")
    public String deleteTrello(@RequestParam(name = "id", defaultValue = "0") Long id,
                               @RequestParam(name = "folder_id", defaultValue = "0") Long folderId){
        Tasks tasks=tasksServices.getTask(id);
        if (tasks!=null){
            tasksServices.deleteTasks(tasks);
        }

        return "redirect:/trelloD/" + folderId;
    }


    @GetMapping(value = "/trelloD/{idshka}")
    public String detailsD(Model model, @PathVariable(name = "idshka") Long idshka){

        Folders folders= foldersServices.getFolders(idshka);
        model.addAttribute("folders", folders);



        List<TaskCategories> taskCategories= categoriesService.getAllCategories();
        taskCategories.removeAll(folders.getTaskCategories());
        model.addAttribute("categories", taskCategories);

        List<Tasks> tasks=tasksServices.getAllTasks();
            model.addAttribute("tasks", tasks);





        return "/trelloD";
    }

    @PostMapping(value = "/trelloA")
    public String assign(@RequestParam(name = "folder_id") Long folderId,
                         @RequestParam(name = "category_id") Long categoryId){
        TaskCategories taskCategories=categoriesService.getCategory(categoryId);

        if (taskCategories != null) {
            Folders folders=foldersServices.getFolders(folderId);
            if (folders != null) {
                List<TaskCategories> taskCategories1 = folders.getTaskCategories();
                if (taskCategories1 == null) {
                    taskCategories1 = new ArrayList<>();
                }
                taskCategories1.add(taskCategories);
                foldersServices.saveFolders(folders);
                return "redirect:/trelloD/" + folderId;
            }
        }
        return "redirect:/trelloF";
    }

    @PostMapping(value = "/trelloU")
    public String unassign(@RequestParam(name = "folder_id") Long folderId,
                         @RequestParam(name = "category_id") Long categoryId){
        TaskCategories taskCategories=categoriesService.getCategory(categoryId);

        if (taskCategories != null) {
            Folders folders=foldersServices.getFolders(folderId);
            if (folders != null) {
                List<TaskCategories> taskCategories1 = folders.getTaskCategories();
                if (taskCategories1 == null) {
                    taskCategories1 = new ArrayList<>();
                }
                taskCategories1.remove(taskCategories);
                foldersServices.saveFolders(folders);
                return "redirect:/trelloD/" + folderId;
            }
        }
        return "redirect:/trelloF";
    }

    @GetMapping(value = "/trelloDetails/{id}")
    public String trelloDetails( Model model, @PathVariable(name = "id") Long id){



        Tasks tasks= tasksServices.getTask(id);
        model.addAttribute("tasks", tasks);

        List<Comments> comments=commentsServices.getAllComments();
        model.addAttribute("comments", comments);


        List<Folders> folders = foldersServices.getAllFolders();
        model.addAttribute("foldeer", folders);

        return "/trelloDetails";

    }


    @PostMapping(value = "/trelloS")
    public String trelloS(@RequestParam(name = "id", defaultValue = "0") Long id,
                          @RequestParam(name = "title", defaultValue = "") String title,
                          @RequestParam(name = "description", defaultValue = "") String description,
                          @RequestParam(name = "status", defaultValue = "") int status,
                          @RequestParam(name = "folder_id", defaultValue = "0") Long folderId){

        Tasks tasks=tasksServices.getTask(id);
        if (tasks!=null ) {
            Folders folders = foldersServices.getFolders(folderId);

            if (folders != null) {
                tasks.setTitle(title);
                tasks.setDescription(description);
                tasks.setStatus(status);
                tasks.setFolders(folders);
                tasksServices.saveTasks(tasks);
            }
        }

        return "redirect:/trelloD/" + folderId;
    }

//    @PostMapping(value = "/addCom")
//    public String addCom(@RequestParam(name = "tasks_id", defaultValue = "0L") Long id,
//                        @RequestParam(name = "name", defaultValue = "") String name){
//
//        Tasks tasks=tasksServices.getTask(id);
//        if (tasks!=null){
//            Comments comments=new Comments();
//            comments.setName(name);
//            comments.setTasks(tasks);
//            commentsServices.addComments(comments);
//        }
//        return "redirect:/trelloDetails/" + id;
//
//    }








}
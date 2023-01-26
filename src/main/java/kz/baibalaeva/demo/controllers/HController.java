package kz.baibalaeva.demo.controllers;

import kz.baibalaeva.demo.db.DBM;
import kz.baibalaeva.demo.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HController {

    @GetMapping(value = "/")
    public String getAllTasks(Model model){
        model.addAttribute("tasks", DBM.getAllTasks());
        return "main";
    }

    @GetMapping(value = "/details/{idshka}")
    public String detailsT(Model model, @PathVariable(name = "idshka") Long id){
        Task task= new Task();
         task = DBM.detailsT(id);
        model.addAttribute("task", task);
        return "details";
    }

    @PostMapping(value = "/edit")
    public String update(@RequestParam(name = "id", defaultValue = "") Long id,
                         @RequestParam(name = "name", defaultValue = "") String name,
                         @RequestParam(name = "description", defaultValue = "") String description,
                         @RequestParam(name = "deadlineDate", defaultValue = "") String deadlineDate,
                         @RequestParam(name = "isCompleted", defaultValue = "") String is){
        boolean isCompleted= true;
        if (is.equals("Yes")){
            isCompleted =true;
        } else {
            isCompleted=false;
        }
        Task task=new Task(id, name, description, deadlineDate, isCompleted);
        DBM.editT(task);
        return "redirect:/";
    }

    @GetMapping(value = "/remove/{id}")
    public  String remove(@PathVariable(name = "id") Long id){
        DBM.deleteT(id);
        return "redirect:/";

    }

    @PostMapping(value = "/addT")
    public String addT(@RequestParam(name = "name", defaultValue = "") String name,
                       @RequestParam(name = "description", defaultValue = "") String description,
                       @RequestParam(name = "deadlineDate", defaultValue = "") String deadlineDate,
                       @RequestParam(name = "is", defaultValue = "false") String is){
        boolean isCompleted= true;
        if (is.equals("Yes")){
          isCompleted = true;
        } else {
            isCompleted=false;
        }
        Task task=new Task(null, name, description, deadlineDate, isCompleted);
        DBM.addTasks(task);
        return "redirect:/";

    }

}

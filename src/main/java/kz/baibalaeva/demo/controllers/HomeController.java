package kz.baibalaeva.demo.controllers;


import kz.baibalaeva.demo.db.DBManager;
import kz.baibalaeva.demo.models.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping(value = "/students")
    String getIndex(Model model){
        model.addAttribute("students", DBManager.getStudents());
        return "index1";
    }

    @PostMapping(value = "/addStudent")
    String add(
               @RequestParam(name = "name", defaultValue = "") String name,
               @RequestParam(name = "surname", defaultValue = "") String surname,
               @RequestParam(name="exam", defaultValue = "0") int exam){
        String mark;
        if (90<=exam){
            mark="A";
        } else if (exam>=75&& exam<=89) {
            mark="B";
        } else if (exam>=60&& exam<=74) {
            mark="C";
        } else if (exam>=50&& exam<=59) {
            mark="D";
        } else {
         mark="F";
        }
        Student student=new Student(null, name, surname, exam, mark);
        DBManager.addStudents(student);
        return "redirect:/students";

    }

    @GetMapping(value = "/detailss/{id}")
    public String detailss(@PathVariable(name="id") Long id,
                           Model model){
        Student student= new Student();
        student=DBManager.detailss(id);
        model.addAttribute("st", student);
        return "detailss";
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "surname") String surname,
                         @RequestParam(name = "exam") int exam){
        String mark;
        if (90<=exam){
            mark="A";
        } else if (exam>=75&& exam<=89) {
            mark="B";
        } else if (exam>=60&& exam<=74) {
            mark="C";
        } else if (exam>=50&& exam<=59) {
            mark="D";
        } else {
            mark="F";
        }
        Student student=new Student(id, name, surname, exam, mark);
        DBManager.update(student);
        return "redirect:/students";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        DBManager.remove(id);
        return "redirect:/students";
    }



}

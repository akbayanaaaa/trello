package kz.baibalaeva.demo.controllers;

import kz.baibalaeva.demo.models.ApplicationRequest;
import kz.baibalaeva.demo.models.Operators;
import kz.baibalaeva.demo.models.Teacher;
import kz.baibalaeva.demo.services.ItemService;
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
public class HomeC {
    
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/add")
    public String mainA(Model model){

        List<Teacher> teachers= itemService.getAlTeachers();
        model.addAttribute("teachers", teachers);
        return "mainA";
    }

    @PostMapping (value = "/addApp")
    public String addA(@RequestParam(name = "username", defaultValue = "") String username,
                       @RequestParam(name = "coursename", defaultValue = "") String coursename,
                       @RequestParam(name = "commentary", defaultValue = "") String commentary,
                       @RequestParam(name = "phone", defaultValue = "0") String phone,
                       @RequestParam(name = "handled", defaultValue = "false") boolean handled,
                       @RequestParam(name = "teacher_id", defaultValue = "0") Long teacherId){

        Teacher teacher = itemService.getTeacher(teacherId);

        if (teacher!=null) {

            ApplicationRequest applicationRequest=new ApplicationRequest();
            applicationRequest.setUsername(username);
            applicationRequest.setCoursename(coursename);
            applicationRequest.setCommentary(commentary);
            applicationRequest.setPhone(phone);
            applicationRequest.setHandled(handled);
            applicationRequest.setTeacher(teacher);
            itemService.addApp(applicationRequest);
        }
    return "redirect:/allApp";
    }



    @GetMapping(value = "/allApp")
    public String allApp(Model model){
        List<ApplicationRequest> applicationRequests = itemService.getAllApp();
        model.addAttribute("tovary", applicationRequests);

        List<Teacher> teachers= itemService.getAlTeachers();
        model.addAttribute("teachers", teachers);

        return "allApp";
    }

    @GetMapping(value = "/getApp/{id}")
    public String getApp( Model model, @PathVariable(name = "id") Long id){
        ApplicationRequest applicationRequest= itemService.getApp(id);
        model.addAttribute("get", applicationRequest);


        List<Teacher> teachers = itemService.getAlTeachers();
        model.addAttribute("teachers", teachers);


        List<Operators> operators=itemService.getAllOperators();
        operators.removeAll(applicationRequest.getOperators());
        model.addAttribute("operators", operators);

        return "/detailsApp";

    }



    @PostMapping(value = "/saveApp")
    public String saveApp(@RequestParam(name = "id", defaultValue = "0") Long id,
                          @RequestParam(name = "username", defaultValue = "") String username,
                          @RequestParam(name = "coursename", defaultValue = "") String coursename,
                          @RequestParam(name = "commentary", defaultValue = "") String commentary,
                          @RequestParam(name = "phone", defaultValue = "0") String phone,
                          @RequestParam(name = "handled", defaultValue = "false") boolean handled,
                          @RequestParam(name = "teacher_id", defaultValue = "0") Long teacherId){

        ApplicationRequest applicationRequest = itemService.getApp(id);
        if (applicationRequest!=null && handled==false) {
            Teacher teacher = itemService.getTeacher(teacherId);

            if (teacher != null) {
                applicationRequest.setUsername(username);
                applicationRequest.setCoursename(coursename);
                applicationRequest.setCommentary(commentary);
                applicationRequest.setPhone(phone);
                applicationRequest.setHandled(true);
                applicationRequest.setTeacher(teacher);
                itemService.saveApp(applicationRequest);
            }
        }

        return "redirect:/getApp/" + id;
    }



    @PostMapping(value = "/deleteApp")
    public String deleteApp(@RequestParam(name = "id", defaultValue = "0") Long id){
        ApplicationRequest applicationRequest = itemService.getApp(id);
        if (applicationRequest!=null){
            itemService.deleteApp(applicationRequest);
        }

        return "redirect:/allApp";
    }

    @PostMapping(value = "/assign")
    public String assign(@RequestParam(name = "app_id") Long appId,
                         @RequestParam(name = "op_id") Long opId){
        Operators operators=itemService.getOperator(opId);

            if (operators != null) {
                ApplicationRequest applicationRequest = itemService.getApp(appId);
                if (applicationRequest != null) {
                    List<Operators> operators1 = applicationRequest.getOperators();
                    if (operators1 == null) {
                        operators1 = new ArrayList<>();
                    }
                    operators1.add(operators);
                    itemService.saveApp(applicationRequest);
                    return "redirect:/getApp/" + appId;
                }
            }
        return "redirect:/allApp";
    }


    @PostMapping(value = "/unassigncategory")
    public String unassign(@RequestParam(name = "appid") Long appI,
                         @RequestParam(name = "opid") Long opI){
        Operators operators=itemService.getOperator(opI);

        if (operators != null) {
            ApplicationRequest applicationRequest = itemService.getApp(appI);
            if (applicationRequest != null) {
                List<Operators> operators1 = applicationRequest.getOperators();
                if (operators1 == null) {
                    operators1 = new ArrayList<>();
                }
                operators1.remove(operators);
                itemService.saveApp(applicationRequest);
                return "redirect:/getApp/" + appI;
            }
        }
        return "redirect:/allApp";
    }



    @GetMapping(value = "/getN")
    public String getN(Model model){
        List<ApplicationRequest> applicationRequests = itemService.getN();
        model.addAttribute("tov", applicationRequests);
        return "getN";
    }

    @GetMapping(value = "/getP")
    public String getP(Model model){
        List<ApplicationRequest> applicationRequests = itemService.getP();
        model.addAttribute("to", applicationRequests);
        return "getP";
    }



}

package kz.baibalaeva.demo.services;

import kz.baibalaeva.demo.models.ApplicationRequest;
import kz.baibalaeva.demo.models.Operators;
import kz.baibalaeva.demo.models.Teacher;

import java.util.List;

public interface ItemService {
    ApplicationRequest addApp(ApplicationRequest applicationRequest);
    List<ApplicationRequest> getAllApp();

    List<ApplicationRequest> getN();

    List<ApplicationRequest> getP();

    ApplicationRequest getApp(Long id);

    void deleteApp(ApplicationRequest applicationRequest);

    ApplicationRequest saveApp(ApplicationRequest applicationRequest);


    List<Teacher> getAlTeachers();
    Teacher addTeacher(Teacher teacher);
    Teacher saveTeacher(Teacher teacher);
    Teacher getTeacher(Long id);




    List<Operators> getAllOperators();
    Operators addOperators(Operators operators);
    Operators saveOperators(Operators operators);
    Operators getOperator(Long id);



}

package kz.baibalaeva.demo.services.impl;

import kz.baibalaeva.demo.models.ApplicationRequest;
import kz.baibalaeva.demo.models.Operators;
import kz.baibalaeva.demo.models.Teacher;
import kz.baibalaeva.demo.repositories.AppRepository;
import kz.baibalaeva.demo.repositories.OperatorsRepository;
import kz.baibalaeva.demo.repositories.TeacherRepository;
import kz.baibalaeva.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private OperatorsRepository operatorsRepository;

    @Override
    public ApplicationRequest addApp(ApplicationRequest applicationRequest) {
        return appRepository.save(applicationRequest);
    }

    @Override
    public List<ApplicationRequest> getAllApp() {
        return appRepository.findAll();
    }

    @Override
    public List<ApplicationRequest> getN() {
        return appRepository.findAllByHandledFalse();
    }

    @Override
    public List<ApplicationRequest> getP() {
        return appRepository.findAllByHandledTrue();
    }

    @Override
    public ApplicationRequest getApp(Long id) {
        return appRepository.getOne(id);
    }

    @Override
    public void deleteApp(ApplicationRequest applicationRequest) {
        appRepository.delete(applicationRequest);
    }

    @Override
    public ApplicationRequest saveApp(ApplicationRequest applicationRequest) {
        return appRepository.save(applicationRequest);
    }



    @Override
    public List<Teacher> getAlTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public List<Operators> getAllOperators() {
        return operatorsRepository.findAll();
    }

    @Override
    public Operators addOperators(Operators operators) {
        return operatorsRepository.save(operators);
    }

    @Override
    public Operators saveOperators(Operators operators) {
        return operatorsRepository.save(operators);
    }

    @Override
    public Operators getOperator(Long id) {
        return operatorsRepository.getOne(id);
    }


}

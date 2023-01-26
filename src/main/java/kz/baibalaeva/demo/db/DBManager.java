package kz.baibalaeva.demo.db;

import kz.baibalaeva.demo.models.Student;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> students= new ArrayList<>();

    public static Long id= 5L;

    static {
        students.add(new Student(0L, "Akbayan", "Baibalayeva", 95, "A"));
        students.add(new Student(1L, "Nurzhan", "Bolatov", 48, "F"));
        students.add(new Student(2L, "Sabira", "Assetova", 33, "F"));
        students.add(new Student(3L, "Madina", "Adiletova", 77, "B"));
        students.add(new Student(4L, "Karina", "Serzhanova", 51, "D"));

    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudents(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student detailss(Long id){
        return students.get(Integer.parseInt(id.toString()));
    }

    public static void update(Student student){
        students.set(Integer.parseInt(student.getId().toString()), student);
    }

    public static void remove(Long id){
        students.remove(Integer.parseInt(id.toString()));
    }
    
    
}

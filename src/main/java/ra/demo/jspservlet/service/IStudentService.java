package ra.demo.jspservlet.service;

import ra.demo.jspservlet.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add(Student student);
}

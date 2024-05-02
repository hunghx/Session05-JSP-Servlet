package ra.demo.jspservlet.dao;

import ra.demo.jspservlet.model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();
    boolean add(Student student);
}

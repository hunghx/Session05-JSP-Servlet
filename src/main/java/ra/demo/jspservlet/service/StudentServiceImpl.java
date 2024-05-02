package ra.demo.jspservlet.service;

import ra.demo.jspservlet.dao.IStudentDao;
import ra.demo.jspservlet.dao.StudentDaoImpl;
import ra.demo.jspservlet.model.Student;

import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private static IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean add(Student student) {
        return studentDao.add(student);
    }
}

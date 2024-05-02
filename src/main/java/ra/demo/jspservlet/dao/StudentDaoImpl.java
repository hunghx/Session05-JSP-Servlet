package ra.demo.jspservlet.dao;

import ra.demo.jspservlet.model.Student;
import ra.demo.jspservlet.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("Select * from student");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setSex(rs.getBoolean("sex"));
                students.add(s);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Student student) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("INSERT INTO Student(name,address,phone,sex) " +
                    " VALUES (?,?,?,?)");
            callSt.setString(1,student.getName());
            callSt.setString(2,student.getAddress());
            callSt.setString(3,student.getPhone());
            callSt.setBoolean(4,student.getSex());

            int count = callSt.executeUpdate();
            return count!=0;
        } catch (SQLException e) {
            return false;
        }
    }
}

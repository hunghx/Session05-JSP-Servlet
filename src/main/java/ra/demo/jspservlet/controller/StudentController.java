package ra.demo.jspservlet.controller;

import ra.demo.jspservlet.model.Student;
import ra.demo.jspservlet.service.IStudentService;
import ra.demo.jspservlet.service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private static IStudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "GETALL":
                    // hiển thị danh sách sinh viên
                    showListStudent(request, response);
                    break;
                case "ADD" :
                    // điều hướng trang
                    request.getRequestDispatcher("/student/add.jsp").forward(request,response);
                    break;

            }
        }
    }

    private static void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student>  students = studentService.findAll();
        request.setAttribute("list",students);
        request.getRequestDispatcher("/student/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  cau hình utf - 8
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "ADD":
                    // lấy thông tin gửi lên
                    String nameIn = request.getParameter("name");
                    String phoneIn = request.getParameter("phone");
                    String addressIn = request.getParameter("address");
                    Boolean sexIn = Boolean.valueOf(request.getParameter("sex"));
                    Student newStudent = new Student(null,nameIn,phoneIn,sexIn,addressIn);
                    studentService.add(newStudent);
                    showListStudent(request,response);
                    break;
            }
        }

    }
}
 
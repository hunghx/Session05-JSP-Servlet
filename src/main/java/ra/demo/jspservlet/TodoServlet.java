package ra.demo.jspservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Home", value = "/todo")
public class TodoServlet extends HttpServlet {
    private static List<Todo> todoList;
    @Override
    public void init()  {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,"đi học","đi học thêm toán",false));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // nhận cac request theo phuong thuc GET : Sử dụng đường dẫn, thẻ <a> , thẻ <form method ="GET">
            String action = request.getParameter("action");
            if (action!=null){
                switch (action){
                    case "GETALL":
                        // hiển thị danh sách sp
                        showListTodo(request,response);
                        break;
                    case "DELETE":
                        int idDelete = Integer.parseInt(request.getParameter("id"));
                        deleteById(request,response,idDelete);
                    default:
                        System.err.println("ko phù hơp");
                }
            }
    }

    protected void showListTodo(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("list",todoList);
        // gửi sang trang jsp
        req.getRequestDispatcher("/list.jsp").forward(req,res);
    }
    protected void deleteById(HttpServletRequest req,HttpServletResponse res,int id) throws ServletException,IOException{
        Todo todo = todoList.stream().filter(t->t.getId()==id).findFirst().orElse(null);
        if (todo!=null){
            todoList.remove(todo);
        }
        // hiển thị lại danh sách
        showListTodo(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // nhận các request gửi theo post : <form method="post">
    }
}
 
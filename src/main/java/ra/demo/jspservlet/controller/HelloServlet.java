package ra.demo.jspservlet.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    @Override
    public void init() {
        System.out.println("Khởi tạo giá trị cho hello servlet");
        message = "Hello World!";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Truy cập hello sevlet 1 lần");
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    @Override // @ là chú thích để đảm bảo phương thức có ý nghĩa nào đấy
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    @Override
    public void destroy() {
            System.out.println("hủy servlet");
    }
}
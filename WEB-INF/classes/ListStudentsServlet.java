import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ListStudentsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Student> students = StudentDAO.getAllStudents();

        out.println("<html><body><h2>Student List</h2><table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Country</th></tr>");
        for (Student s : students) {
            out.println("<tr><td>" + s.getId() + "</td><td>" + s.getName() + "</td><td>" + s.getEmail() +
                        "</td><td>" + s.getCourse() + "</td><td>" + s.getCountry() + "</td></tr>");
        }
        out.println("</table><br><a href='student-management.html'>Back</a></body></html>");
    }
}

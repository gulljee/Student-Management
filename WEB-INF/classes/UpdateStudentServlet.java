import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String country = request.getParameter("country");

        Student student = new Student(id, name, email, course, country);
        boolean success = StudentDAO.updateStudent(student);

        if (success) out.println("<h3>Student updated successfully!</h3>");
        else out.println("<h3>Failed to update student.</h3>");

        out.println("<a href='student-management.html'>Back</a>");
    }
}

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String country = request.getParameter("country");

        Student student = new Student(name, email, course, country);

        StudentDAO dao = new StudentDAO();
        boolean isInserted = dao.addStudent(student);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        if (isInserted) {
            out.println("<h2>Student added successfully!</h2>");
        } else {
            out.println("<h2>Error adding student.</h2>");
        }
        out.println("</body></html>");
    }
}

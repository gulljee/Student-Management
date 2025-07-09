import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = StudentDAO.deleteStudent(id);

        if (success) out.println("<h3>Student deleted successfully!</h3>");
        else out.println("<h3>Failed to delete student.</h3>");

        out.println("<a href='student-management.html'>Back</a>");
    }
}

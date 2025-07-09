import java.sql.*;
import java.util.*;

public class StudentDAO {
    private static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bcsf22", "root", "root");
    }

    public static boolean addStudent(Student s) {
        boolean status = false;
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO students(name, email, course, country) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getCountry());
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getString("country")
                );
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean updateStudent(Student s) {
        boolean status = false;
        try (Connection con = getConnection()) {
            String sql = "UPDATE students SET name=?, email=?, course=?, country=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getCountry());
            ps.setInt(5, s.getId());
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean deleteStudent(int id) {
        boolean status = false;
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

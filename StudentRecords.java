import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentRecords {

    public static void main(String[] args) {

        // MySQL database details
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "2026";

        try {
            // Connect Java to MySQL
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

            // Create Statement
            Statement stmt = con.createStatement();

            // SELECT query
            String query = "SELECT * FROM students";

            // Execute SELECT query
            ResultSet rs = stmt.executeQuery(query);

            // Display student records
            System.out.println("\nStudent Records");
            System.out.println("---------------------------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");

                System.out.println(
                        id + " | " +
                        name + " | " +
                        age + " | " +
                        course + " | " +
                        marks
                );
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
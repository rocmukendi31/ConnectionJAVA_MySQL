import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDetails {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "2026";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            System.out.println("Database connected successfully!");

            // Create Statement
            Statement stmt = con.createStatement();

            // SELECT query
            String query = "SELECT * FROM products";

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Display product details
            System.out.println("\nProduct Details");
            System.out.println("---------------------------------------------");

            while (rs.next()) {

                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.println(
                        productId + " | " +
                        productName + " | " +
                        quantity + " | ₹" +
                        price
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
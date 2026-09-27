import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/student_expense_tracker";
            String username = "root";
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(
                url,
                username,
                password
            );

            System.out.println("Database connected successfully!");
            return con;

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
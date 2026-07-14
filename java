import java.sql.*;
import java.util.Scanner;

public class LoginSystem {

    private static final String URL =
            "jdbc:mysql://localhost:3306/sampledb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            String sql =
                    "SELECT * FROM users WHERE userid='"
                    + userId
                    + "' AND password='"
                    + password
                    + "'";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Login Success");
            } else {
                System.out.println("Login Failed");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

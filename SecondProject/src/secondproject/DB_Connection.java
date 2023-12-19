package secondproject;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class DB_Connection {

    private static final String url = "jdbc:sqlserver://192.168.1.12\\\\SQLEXPRESS:1433;database=Mangment_Clinc_Sysyem;encrypt=true;trustservercertificate=true;user=George;password=12345;";
    private static final String username = "George";
    private static final String password = "12345";
    private static Connection connection = null;

    public static void write(String query) {
        try {
            String connectionString = "jdbc:sqlserver://192.168.1.12\\\\SQLEXPRESS:1433;database=Mangment_Clinc_Sysyem;encrypt=true;trustservercertificate=true;user=George;password=12345;";
            try ( Connection connection = DriverManager.getConnection(connectionString)) {
                PreparedStatement st = connection.prepareStatement(query);
                st.executeUpdate();
// chat gpt comment it
//                st.close();
//                connection.close(); 
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL update: " + query);
            e.printStackTrace();
        }
        catch (Exception e) {
             System.out.println("Error Line 34");
            e.printStackTrace(); // Consider using a logging framework here
    }
    }
    

    public static ResultSet read(String query) {
        String connectionString = "jdbc:sqlserver://192.168.1.12\\\\SQLEXPRESS:1433;database=Mangment_Clinc_Sysyem;encrypt=true;trustservercertificate=true;integratedSecurity=true";
       


        try ( Connection connection = DriverManager.getConnection(connectionString);) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + query);
            e.printStackTrace();
        }
        return null;
    }
}

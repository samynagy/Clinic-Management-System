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
    private static final String url="jdbc:sqlserver://255.255.255.0:1433;database=Mangment_Clinc_Sysyem;encrypt=true;trustservercertificate=true";
    private static final String username="Bebawy";
    private static final String password="12345";
    private static Connection connection=null;
    
//public static Connection getConnection(){
//    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    try{
//    Class.forName(driver);
//    connection =DriverManager.getConnection(url,username,password);
//    if(connection ==null){
//        System.out.println("the connection is null");
//    }
//    else
//    {
//        System.out.println("the connection is not null");
//    }
//    }
//    catch(Exception e){
//        System.out.println("com.Models.DbConnection.getConnection()"+e.getMessage());
//    }
//    return connection;
//}

public static void write(String query) {
        try {
            String connectionString = "jdbc:sqlserver://George\\SQLEXPRESS;database=Mangment_Clinc_Sysyem;encrypt=true;trustservercertificate=true;integratedSecurity=true";
            try (Connection connection = DriverManager.getConnection(connectionString)) {
                PreparedStatement st = connection.prepareStatement(query);
                st.executeUpdate();

                st.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static ResultSet read(String query) {
        String connectionString = "jdbc:sqlserver://George\\SQLEXPRESS;database=Mangment_Clinc_Sysyem;encrypt=true;trustservercertificate=true;integratedSecurity=true";

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return null;
    }
}

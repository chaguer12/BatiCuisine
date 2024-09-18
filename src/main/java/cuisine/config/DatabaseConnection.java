package cuisine.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/baticuisine";
    private static final String db_user = "postgres";
    private static final String password = "1360";
    private static Connection conn = null;

    public static Connection Connect() {
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,db_user,password);
            System.out.println("Connected to database");

        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());

        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return conn;
    }
    public static Connection getConnection(){
        if(conn == null){
            Connect();
            return conn;
        }else {
            return conn;
        }
    }
}
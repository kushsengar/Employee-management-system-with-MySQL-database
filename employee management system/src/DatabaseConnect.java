import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DatabaseConnect {
    static Connection con;
    public static Connection CreateDBConnection(){
        //load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/employeedatabase";
            String username="root";
            String password="Kush@mysql11";
            con=
                    DriverManager.getConnection(url,username,password);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}













































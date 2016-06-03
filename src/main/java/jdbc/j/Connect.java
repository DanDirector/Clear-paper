package jdbc.j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by в on 03.06.2016.
 */
public class Connect {
    private static Connection con;

    public static Connection getConnection(){

        if (con==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clean_paper", "root", "qawsed");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}

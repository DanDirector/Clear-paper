package jdbc.j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by в on 31.05.2016.
 */
public class Jdbc {
    public static List<String> showAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clean_paper", "root", "qawsed");
            statement = connection.createStatement();

            statement.execute("SELECT * FROM thing");


            resultSet=statement.getResultSet();

            while (resultSet.next()){
                list.add(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null)
                        statement.close();
                    if (resultSet != null)
                        resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return list;
    }

    public static void createThing(String s){

    }
}

package jdbc.j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by в on 31.05.2016.
 */
public class Jdbc {
    public static List<String> showAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> list = new ArrayList();

        try {
            statement = Connect.getConnection().createStatement();

            statement.execute("SELECT * FROM thing");


            resultSet=statement.getResultSet();

            while (resultSet.next()){
                list.add(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
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
        try {
            Statement statement = Connect.getConnection().createStatement();
            statement.execute("INSERT INTO thing (`name`) VALUES ('" + s + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

package vtb.workspace.lesson_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @author Mikhail Zaitsev
 */
public class MainDB {
    private static final String SQL_DRIVER = "org.sqlite.JDBC";
    private static final String MY_DB = "jdbc:sqlite:mydb.db";
    private static Connection connection;
    private static Statement statement;

    public static void connect() {
        try {
            Class.forName(SQL_DRIVER);
            connection = DriverManager.getConnection(MY_DB);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName, Map<String, Map<String, Object>> data) throws SQLException {
        StringBuilder builder = new StringBuilder();
        List<String> names = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        builder.append("CREATE TABLE IF NOT EXISTS " + tableName);
        builder.append(" ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");

        for (Iterator<String> iterator = data.keySet().iterator(); (iterator.hasNext()); ) {
            String name = iterator.next();
            Map<String, Object> map = data.get(name);
            builder.append(name + " ");

            for (String type : map.keySet()) {
                names.add(name);
                values.add(map.get(type));
                if (iterator.hasNext()) {
                    builder.append(type + ",");
                } else {
                    builder.append(type);
                }
            }
        }
        builder.append(");");
        statement.executeUpdate(String.valueOf(builder));
        addDataToDB(tableName, names, values); // Добавить данные в базу
    }

    private static void addDataToDB(String tableName, List<String> names, List<Object> values) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO "+tableName+" (");

        for (int i = 0; i < names.size(); i++) {
            if (i != names.size() -1)
                builder.append(names.get(i) + ",");
            else builder.append(names.get(i) + ") VALUES (");
        }
        for (int i = 0; i < values.size(); i++) {

            if (i != values.size() -1) builder.append("'"+values.get(i) + "',");
            else builder.append("'"+values.get(i)+"');");
        }
        statement.executeUpdate(String.valueOf(builder));

    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


package model.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class DataBase {
    /* Static Fields */
    private static DataBase dataBase = new DataBase();

    /* Instance Fields */
    private Statement statement;
    private Connection connection;

    /* Constructor */
    private DataBase() {
        // This is singleton class
    }

    /* Static methods */
    public static DataBase getInstance() {
        if (DataBase.dataBase == null)
            DataBase.dataBase = new DataBase();

        return DataBase.dataBase;
    }

    /* Getters And Setters */
    public Statement getStatement() {
        return statement;
    }

    private void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    /* Instance Methods */
    public void run() throws ClassNotFoundException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        Connection connection;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            setStatement(statement);
            setConnection(connection);

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Dictionary<String, String>> getResult(String query) {
        String temp;
        try {
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            ArrayList<Dictionary<String, String>> resultSet = new ArrayList<>();
            while (rs.next()) {
                Dictionary<String, String> res = new Hashtable<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    temp = rs.getString(i);
                    res.put(metaData.getColumnName(i), temp == null ? "" : temp);
                }
                resultSet.add(res);
            }
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public void exeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public int getGenerateKey() {
        try {
            return dataBase.getStatement().getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return 0;
    }

    public int getCount(String query) {
        try {
            ResultSet rs = statement.executeQuery(query);
            int counter = 0;
            while (rs.next()) {
                counter++;
            }
            return counter;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return 0;
    }

    public void close() {
        try {
            if (getConnection() != null)
                getConnection().close();
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }
}
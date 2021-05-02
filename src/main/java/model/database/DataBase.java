package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

        Connection connection = null;
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

    public void close() {
        try {
            if (getConnection() != null)
                getConnection().close();
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e);
        }
    }

}
package helper;

import sun.misc.Service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

public class JDBCConnectionHelper {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/reservation_cinema_place";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    private static Iterator<Driver> ps;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        ps = Service.providers(Driver.class);


        //Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        return connection;
    }}
    //static method, creating Connection


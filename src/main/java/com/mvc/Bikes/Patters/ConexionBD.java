package com.mvc.Bikes.Patters;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    private static String url="jdbc:sqlserver://localhost\\MSSQLSERVER2022;databaseName=airflatsandhome;TrustServerCertificate=true";

    private static String userName = "sa";
    private static String password = "12345678";
    private static Connection con;

    public static Connection getConexion() throws SQLException {

        con = DriverManager.getConnection(url,userName, password);



        return con;
    }

    public static Connection setConection(String url, String userName, String password) throws SQLException {


        con = DriverManager.getConnection(url);


        return con;
    }



}

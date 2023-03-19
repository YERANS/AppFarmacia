package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private String database_name = "pharmacy_database";
    private String user = "root";
    private String password = "admin";
    private String url = "jdbc:mysql://localhost:3306/" + database_name;
    Connection conn = null;
    
    
    public Connection getConnection(){
        try {
            //optener valor del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtener la coneción
            conn = DriverManager.getConnection(url, user, password);
         
        } catch (ClassNotFoundException e) {
            System.err.println("Ha ocurrido un ClassNotFoundException" + e.getMessage());
        } catch (SQLException e){
            System.err.println("Ha ocurrido un SQLException" + e.getMessage());
        }
        return conn;
    
    }
}

package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class CustomersDao {
    //instanciar la conecxion
    ConnectionMySQL cn = new ConnectionMySQL ();
    //variables para conectarnos a la base de datos 
    Connection conn;
    //sirve para las consultas
    PreparedStatement pst;
    //optener datos de las consultas para operar 
    ResultSet rs;
    
    //METODO REGISTRAR CLIENTE
    public boolean registerCustomerQuery(Customers customer){
        String query = "INSERT INTO customers (id, full_name, address, telephone, email, created, updated) " + "VALUES (?,?,?,?,?,?,?)";
        
        Timestamp datetime = new Timestamp(new Date().getTime());
        
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, customer.getId());
            pst.setString(2, customer.getFull_name());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getTelephone());
            pst.setString(5, customer.getEmail());
            pst.setTimestamp(6, datetime);
            pst.setTimestamp(7, datetime);
            pst.execute();
            return true;
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al registrar el cliente");
            return false;
        }
    }  
    
    //LISTAR CLIENTE
    public List listCustomerQuery(String value){
        List<Customers> list_customers = new ArrayList();
        String query = "SELECT * FROM customers ";
        String query_search_customer = "SELECT FROM customer WHERE id LIKE '%" + value + "%'";
        
        try {
            conn = cn.getConnection();
            if (value.equalsIgnoreCase("")) {
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            } else {
                pst = conn.prepareStatement(query_search_customer);
                rs = pst.executeQuery();
            }
            
            while (rs.next()) {                
                Customers customer = new Customers();
                customer.setId(rs.getInt("id"));
                customer.setFull_name(rs.getString("full_name"));
                customer.setAddress(rs.getString("address"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));          
                list_customers.add(customer);   
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
        return list_customers;
    }
}

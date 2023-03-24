package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author yerso
 */
public class ProductsDao {
    //instanciar la conecxion
    ConnectionMySQL cn = new ConnectionMySQL ();
    //variables para conectarnos a la base de datos 
    Connection conn;
    //sirve para las consultas
    PreparedStatement pst;
    //optener datos de las consultas para operar 
    ResultSet rs;
    
    //METODO PARA REGISTRAR PRODUCTO 
    public boolean registerProductQuery(Products product){
        String query = "INSERT INTO products (code, name, description, unit_price, created, updated, category_id)"
                + "VALUE (?,?,?,?,?,?,?)";
        
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, product.getCode());
            pst.setString(2, product.getName());
            pst.setString(3, product.getDescription());
            pst.setDouble(4, product.getUnit_price());
            pst.setTimestamp(5, datetime);
            pst.setTimestamp(6, datetime);
            pst.setInt(7, product.getCategory_id());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al registrar el producto");
            return false;
        }
    }
    
    //METODO LISTAR PRODUCTO
    
}

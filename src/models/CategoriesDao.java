package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author yerso
 */
public class CategoriesDao {
    //instanciar la conecxion
    ConnectionMySQL cn = new ConnectionMySQL ();
    //variables para conectarnos a la base de datos 
    Connection conn;
    //sirve para las consultas
    PreparedStatement pst;
    //optener datos de las consultas para operar 
    ResultSet rs;
    
    //METODO PARA REGISTRAR CATEGORIA
    public boolean registerCategoryQuery(Categories category){
         String query = "INSERT INTO categories(name, created, updated) VALUES(?,?,?)";
         Timestamp datetime = new Timestamp(new Date().getTime());
         try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category.getName());
            pst.setTimestamp(2, datetime);
            pst.setTimestamp(3, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "error al registrar la categoria");
             return false;
        }
    }
    
    //METODO PARA LISTAR CATEGORIAS
    public List listCategoriesQuery(String value){
        List<Categories> list_categories = new ArrayList();
        String query = "SELECT * FROM categories ";
        String query_search_category = "SELECT FROM categories WHERE name LIKE '%" + value + "%'";
        
        try {
            conn = cn.getConnection();
            if (value.equalsIgnoreCase("")) {
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            } else {
                pst = conn.prepareStatement(query_search_category);
                rs = pst.executeQuery();
            }
            
            while (rs.next()) {                
                Categories category = new Categories();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));          
                list_categories.add(category);   
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
        return list_categories;
    }
    
    //METODO PARA MODIFICAR CATEGORIAS
    public boolean updateCategoryQuery(Categories category){
         String query = "UPDATE categories name = ?,  updated = ? WHERE id=? " ;
         Timestamp datetime = new Timestamp(new Date().getTime());
         try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, category.getName());
            pst.setTimestamp(2, datetime);
            pst.setInt(3, category.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "error al modificar los datos de la categoria");
             return false;
        }
    }
    
    //METODO PARA ELIMINAR CATEGORIA
        public boolean deleteCategoryQuery(int id) {
            String query = "DELETE FROM categories WHERE id = " + id;

            try {
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
                pst.execute();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "no puede eliminar una categoria que tenga relacion con otra tabla");            
                return false;
            }   

        }
}

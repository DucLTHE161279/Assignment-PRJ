/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Dell
 */
public class ProductDBContext extends DBContext {
    public ArrayList<Product> getProducts(){

ArrayList<Product> products = new ArrayList<>();
  try {
            String sql = "select pid,name,price from Product";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Product p = new Product();
                p.setId(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getInt("price"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
return products;
}
     public Product getProduct(int id){
         ArrayList<Product> products = getProducts();
         for (Product product:products){
             if (product.getId()==id){
                 return product;
             }
         }
         return null;
     }
}

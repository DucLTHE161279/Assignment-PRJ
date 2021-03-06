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

    public ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select pid,name,price,quantity,date,import,sold from Product ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getInt("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDate(rs.getDate("date"));
                p.setImports(rs.getInt("import"));
                p.setSold(rs.getInt("sold"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> getProductsByPage(int pageindex, int pagesize) {

        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select pid,name,price,quantity,date,import,sold from\n"
                    + "(select *, ROW_NUMBER() over (order by pid asc) as row_index from Product) tb1\n"
                    + "where row_index >= (?-1) * ? + 1\n"
                    + "and row_index <= ? *?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getInt("price"));
                p.setQuantity(rs.getInt("quantity"));
                  p.setDate(rs.getDate("date"));
                p.setImports(rs.getInt("import"));
                p.setSold(rs.getInt("sold"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProduct(int pid) {

        try {
            String sql = "select pid,name,price,quantity from Product\n"
                    + "where pid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getInt("price"));
                p.setQuantity(rs.getInt("quantity"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertProduct(Product p) {
        String sql = "INSERT INTO [Product]\n"
                + "           ([pid]\n"
                + "           ,[name]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[date]\n"
                + "           ,[import]\n"
                + "           ,[sold])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, p.getId());
            stm.setString(2, p.getName());
            stm.setInt(3, p.getPrice());
            stm.setInt(4, p.getQuantity());
            stm.setDate(5,p.getDate());
            stm.setInt(6, p.getImports());
            stm.setInt(7,p.getSold());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void updateProduct(Product p) {
        String sql = "UPDATE [Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[quantity] = ?\n"
                  + "      ,[date] = ?\n"
                  + "      ,[import] = ?\n"
                  + "      ,[sold] = ?\n"
                + " WHERE [pid]=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(7, p.getId());
            stm.setString(1, p.getName());
            stm.setInt(2, p.getPrice());
            stm.setInt(3, p.getQuantity());
              stm.setDate(4,p.getDate());
            stm.setInt(5, p.getImports());
            stm.setInt(6,p.getSold());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public int count() {

        try {
            String sql = "select count(*) as total from Product";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}

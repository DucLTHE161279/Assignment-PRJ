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
import model.ImportManage;

/**
 *
 * @author Dell
 */
public class ImportManageDBContext extends DBContext {

    public ArrayList<ImportManage> getImportManage() {

        ArrayList<ImportManage> importmanage = new ArrayList<>();
        try {
            String sql = "select importID,importdate,importnote from ImportManage";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ImportManage im = new ImportManage();
                im.setImportid(rs.getInt("importID"));
                im.setImportdate(rs.getDate("importdate"));
                im.setImportnote(rs.getString("importnote"));
                importmanage.add(im);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return importmanage;
    }

    public ImportManage getOneImportManage(int importid) {

        try {
            String sql = "select importID,importdate,importnote from ImportManage\n"
                    + "where importID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, importid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ImportManage im = new ImportManage();
                im.setImportid(rs.getInt("importID"));
                im.setImportdate(rs.getDate("importdate"));
                im.setImportnote(rs.getString("importnote"));
      
                return im;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertImportManage(ImportManage im) {
        String sql = "INSERT INTO [ImportManage]\n"
                + "           ([importId]\n"
                + "           ,[importdate] \n"
                + "           ,[importnote]  )\n"
                + "     VALUES( ?\n"
                + "           , ?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, im.getImportid());
            stm.setDate(2, im.getImportdate());
            stm.setString(3, im.getImportnote());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateImportManage(ImportManage im) {
        String sql = "UPDATE [ImportManage]\n"
                + "   SET [importdate] = ?\n"
                + "      ,[importnote] = ?\n"
                + " WHERE importID=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(3, im.getImportid());
            stm.setDate(1, im.getImportdate());
            stm.setString(2, im.getImportnote());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImportManageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

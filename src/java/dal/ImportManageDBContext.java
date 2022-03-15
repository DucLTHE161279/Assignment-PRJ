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
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return importmanage;
    }
}

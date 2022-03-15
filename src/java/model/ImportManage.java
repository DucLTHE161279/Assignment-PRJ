/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class ImportManage {
    private int importid;
    private Date importdate;
    private int importquantity;
    private String importnote;

    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }

    public int getImportquantity() {
        return importquantity;
    }

    public void setImportquantity(int importquantity) {
        this.importquantity = importquantity;
    }

    public String getImportnote() {
        return importnote;
    }

    public void setImportnote(String importnote) {
        this.importnote = importnote;
    }

    public int getImportid() {
        return importid;
    }

    public void setImportid(int importid) {
        this.importid = importid;
    }
    
    
}

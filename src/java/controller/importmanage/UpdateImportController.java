/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.importmanage;

import dal.ImportManageDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ImportManage;

/**
 *
 * @author Dell
 */
public class UpdateImportController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       int importid= Integer.parseInt(request.getParameter("importid"));
        ImportManageDBContext db= new ImportManageDBContext();
        
        
       ImportManage oneimportmanage =db.getOneImportManage(importid);
       request.setAttribute("oneimportmanage", oneimportmanage);
       
       request.getRequestDispatcher("ImportManage/updateimport.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String raw_id = request.getParameter("importid");
        String raw_date = request.getParameter("importdate");
        String raw_importnote = request.getParameter("importnote");
  
        
        
        //validate data
        int id = Integer.parseInt(raw_id);
         Date importdate = Date.valueOf(raw_date);
            String importnote= raw_importnote;
      
ImportManage im = new ImportManage();
       
        im.setImportid(id);
        im.setImportdate(importdate);
        im.setImportnote(importnote);
    
        
        ImportManageDBContext db = new ImportManageDBContext();
        db.updateImportManage(im);
        
       
        response.sendRedirect("importlist");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

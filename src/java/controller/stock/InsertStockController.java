/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.stock;

import controller.BaseAuthController;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Dell
 */
public class InsertStockController extends BaseAuthController {

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDBContext db = new ProductDBContext();
        ArrayList<Product> products = db.getProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/stock/insert.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_price = request.getParameter("price");
        String raw_quantity = request.getParameter("quantity");
        String raw_date = request.getParameter("date");
        String raw_import = request.getParameter("import");
        String raw_sold = request.getParameter("sold");

        //validate data
        int id = Integer.parseInt(raw_id);
        
        String name = raw_name;
        int price = Integer.parseInt(raw_price);
        int quantity = Integer.parseInt(raw_quantity);
        Date date = Date.valueOf(raw_date);
        int imports = Integer.parseInt(raw_import);
        int sold = Integer.parseInt(raw_sold);
        
        Product p = new Product();
        
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        p.setQuantity(quantity);
        
        
        p.setDate(date);
        p.setImports(imports);
        p.setSold(sold);
        ProductDBContext db = new ProductDBContext();
        db.insertProduct(p);
        
        response.sendRedirect("stocklist");
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

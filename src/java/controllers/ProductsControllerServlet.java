package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/**
 *
 * @author mauricio
 */
@WebServlet("/products")
public class ProductsControllerServlet extends HttpServlet {

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
        String path = request.getPathInfo();
        String url = path;
        if (url == null || url.equals("/")) {
            url = "/WEB-INF/jsp/products/index.jsp";
            ArrayList products = Product.all();
            request.setAttribute("products", products);
        } else if (url.matches("/new")) {
            url = "/WEB-INF/jsp/products/new.jsp";
        } else if (url.matches("/\\d+/buy")) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(url);
            matcher.find();
            request.setAttribute("product_id", matcher.group(0));
            url = "/WEB-INF/jsp/products/buy.jsp";
        } else if (url.matches("/\\d+")) {
            url = "/WEB-INF/jsp/products/show.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
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
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String is_subscription = request.getParameter("is_subscription");
        String path = request.getPathInfo();
        String url = path;
        if (url == null || url.equals("/")) {
            url = request.getContextPath() + "/products";
            Product product = new Product();
            product.build("0", name, description, price, is_subscription);
            product.save();
        }
        response.sendRedirect(url);
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

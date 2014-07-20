package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.conekta.CardPayment;
import com.conekta.Charge;
import com.conekta.PaymentMethod;
import com.conekta.Conekta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import org.json.JSONObject;

/**
 *
 * @author mauricio
 */
@WebServlet("/charges")
public class ChargesControllerServlet extends HttpServlet {

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
            url = "/WEB-INF/jsp/charges/index.jsp";
            ArrayList charges = models.Charge.all();
            request.setAttribute("charges", charges);
        } else if (url.matches("/new")) {
            url = "/WEB-INF/jsp/charges/new.jsp";
        } else if (url.matches("/\\d+/buy")) {
            url = "/WEB-INF/jsp/charges/buy.jsp";
        } else if (url.matches("/\\d+")) {
            url = "/WEB-INF/jsp/charges/show.jsp";
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
        String product_id = request.getParameter("product_id");
        String token = request.getParameter("conektaTokenId");
        String path = request.getPathInfo();
        String url = path;
        Charge conektaCharge;
        if (url == null || url.equals("/")) {
            Conekta.apiKey = "key_eYvWV7gSDkNYXsmr";
            JSONObject card_payment_params;
            JSONObject valid_visa_card;
            try {
                Product product = Product.find(product_id);
                valid_visa_card = new JSONObject("{'card':'" + token + "'}");
                card_payment_params = new JSONObject("{'description':'" + product.description + "',"
                        + "'reference_id':'" + product.id + "',"
                        + "'amount':" + ((int)Float.parseFloat(product.price)*100) + ","
                        + "'currency':'MXN'"
                        + "}");
                conektaCharge = Charge.create(card_payment_params.put("card", valid_visa_card.get("card")));
                url = request.getContextPath() + "/charges";
                models.Charge charge = new models.Charge();
                charge.build(conektaCharge.id, conektaCharge.livemode.toString(),
                        conektaCharge.created_at.toString(), conektaCharge.status,
                        conektaCharge.currency, conektaCharge.description,
                        conektaCharge.reference_id, conektaCharge.failure_code,
                        conektaCharge.failure_message, conektaCharge.amount.toString(),
                        ((CardPayment) conektaCharge.payment_method).name,
                        ((CardPayment) conektaCharge.payment_method).exp_month,
                        ((CardPayment) conektaCharge.payment_method).exp_year,
                        ((CardPayment) conektaCharge.payment_method).auth_code,
                        ((CardPayment) conektaCharge.payment_method).last4,
                        ((CardPayment) conektaCharge.payment_method).brand);
                charge.save();

            } catch (Exception ex) {
                Logger.getLogger(ChargesControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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

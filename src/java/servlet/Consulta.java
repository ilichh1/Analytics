/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
package servlet;

import dao.ClickDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import pojo.Click;

/**
 *
 * @author Ilich Arredondo
 */
@WebServlet(name = "Consulta", urlPatterns = {"/consulta"})
public class Consulta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String tipoConsulta = request.getParameter("tipo");
            
            if (tipoConsulta != null && !tipoConsulta.isEmpty() && tipoConsulta.equals("clicks")) {
                
                ClickDAO clickDAO = new ClickDAO();
                JSONArray jsonResponse = new JSONArray(clickDAO.getClicksByElements());
                
                response.setContentType("application/json");
                out.print(jsonResponse.toString());
                out.close();
                
                this.destroy();
            }
            
            ClickDAO clickDAO = new ClickDAO();
            JSONObject jsonResponse = new JSONObject();
            List<Click> clicks = clickDAO.getAllClicks();
            jsonResponse.put("clicks", clicks);
            
            response.setContentType("application/json");
            
            out.print(jsonResponse.toString());
            out.close();
            
            this.destroy();
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

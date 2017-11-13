/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
package servlet;

import dao.ClickDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            response.setContentType("application/json");
            ClickDAO clickDAO = new ClickDAO();
            
            if (tipoConsulta != null && !tipoConsulta.isEmpty() && tipoConsulta.equals("clicks")) {
                JSONArray jsonResponse = new JSONArray(clickDAO.getClicksByElements());
                
                out.print(jsonResponse.toString());
                out.close();
                
                this.destroy();
            } else if(tipoConsulta != null && !tipoConsulta.isEmpty() && tipoConsulta.equals("clicks2")) {
                JSONObject jsonObject = new JSONObject();
                
                List<String> labels = new ArrayList<>();
                List<Long> clicks = new ArrayList<>();
                
                for (Object[] item : clickDAO.getClicksByElementsArray()) {
                    labels.add((String) item[0]);
                    clicks.add((long) item[1]);
                }
                
                jsonObject.put("elements", new JSONArray(labels));
                jsonObject.put("clicks", new JSONArray(clicks));
                out.print(jsonObject.toString());
                out.close();
                
                this.destroy();
            }
            
            JSONObject jsonResponse = new JSONObject();
            List<Click> clicks = clickDAO.getAllClicks();
            jsonResponse.put("clicks", clicks);
            
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

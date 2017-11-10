/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
package servlet;

import dao.ClickDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import pojo.Click;

/**
 *
 * @author Ilich Arredondo
 */
@WebServlet(name = "RegistrarClick", urlPatterns = {"/registrarclick"})
public class RegistrarClick extends HttpServlet {

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
        
        
        //System.out.println(request.getParameter("data"));
        
        HashMap<String, Object> clickData = (HashMap<String, Object>) new JSONObject(request.getParameter("data")).toMap();
        
        System.out.println(request.getRemoteAddr());
        
        long date = Long.parseLong(clickData.getOrDefault("timeStamp", "0").toString());
        Click clickUsuario = new Click(
                new Date(date),
                clickData.getOrDefault("coordX", "").toString(),
                clickData.getOrDefault("coordY", "").toString(),
                clickData.getOrDefault("sizeY", "").toString(),
                clickData.getOrDefault("sizeX", "").toString(),
                clickData.getOrDefault("userAgent", "").toString(),
                clickData.getOrDefault("classListTarget", "").toString(),
                clickData.getOrDefault("idTarget", "").toString(),
                clickData.getOrDefault("outerHTMLTarget", "").toString(),
                clickData.getOrDefault("target", "").toString()
        );
        
        ClickDAO clickDAO = new ClickDAO();
        JSONObject json = new JSONObject();
        json.put("success", clickDAO.saveClick(clickUsuario));
        
        response.setContentType("application/json");
        
        //Objeto "out" para mandar datos a la respuesta
        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.close();
        
        //Matamos este Servlet
        this.destroy();
    }
}

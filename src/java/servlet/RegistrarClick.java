/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

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
        
        //Iteramos por todos los parametros recibidos y los imprimimos en pantalla
        
        Enumeration<String> keys = request.getParameterNames();
        
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(request.getParameter(key));
        }
        
        //Objeto "out" para mandar datos a la respuesta
        PrintWriter out = response.getWriter();
        //Objeto JSON que contendrá la respuesta del serivdor
        JSONObject json = new JSONObject();
        json.put("recibido", true);
        
        out.print(json.toString());
        
        //Matamos este Servlet
        this.destroy();
    }
}

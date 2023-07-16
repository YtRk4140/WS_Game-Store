/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.servlet;

import han.registration.RegistrationDAO;
import han.registration.RegistrationInsertError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author WINDOW
 */
public class CreateAccountServlet extends HttpServlet {
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
        try ( PrintWriter out = response.getWriter()) {
            String username = request.getParameter("textUsername");
            String password = request.getParameter("textPassword");
            String lastname = request.getParameter("textLastName");
            String confirm = request.getParameter("textConfirm");
            boolean isAdmin = false;
            
            RegistrationDAO dao = new RegistrationDAO();
            
            String url = "MainController?btAction=CreateError&textUsername="+username+"&textLastName="+lastname;
            
            HttpSession sessions = request.getSession();
            RegistrationInsertError errors = (RegistrationInsertError)sessions.getAttribute("INSERTER");
            if (errors == null) {
                errors = new RegistrationInsertError();
            }
            
            int nameLenght = username.length();
            int passLenght = password.length();
            int lastNameLenght = lastname.length();
            
            if(nameLenght<4)  errors.setUsernameLengthErr("Username cannot be shorter than 4 characters!");
            else if(nameLenght>20) errors.setUsernameLengthErr("Username cannot be longer than 20 characters!");
            else errors.setUsernameLengthErr("");
            
            if(passLenght<4)  errors.setPasswordLengthErr("Password cannot be shorter than 4 characters!");
            else if(passLenght>30) errors.setPasswordLengthErr("Password cannot be longer than 30 characters!");
            else errors.setPasswordLengthErr("");
            
            if(!confirm.equals(password))  errors.setConfirmNotMatch("Confirm password is incorrect!");
            else errors.setConfirmNotMatch("");
            
            if(lastNameLenght==1)  errors.setLastNameLengthErr("Lastname cannot be shorter than 2 characters!");
            else if(lastNameLenght>50) errors.setLastNameLengthErr("Lastname cannot be longer than 50 characters!");
            else errors.setLastNameLengthErr("");
            
            sessions.setAttribute("INSERTER", errors);
            
            if(dao.checkUsername(username)) errors.setUsernameIsExisted("Username is already existed!");
            
            if(!username.isEmpty() & !password.isEmpty() & nameLenght<=20 & nameLenght>=4 & passLenght<=30 & passLenght>=4 & confirm.equals(password)){
                
                boolean result = dao.insert(username, password, lastname, isAdmin);
                if(result) {
                    url = "login.html";
                }
            }
            response.sendRedirect(url);
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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

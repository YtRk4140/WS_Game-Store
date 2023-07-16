
package han.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author NgocLinh
 */
public class MainController extends HttpServlet {

    private final String LOGINPAGE = "login.html";
    private final String LOGINCONTROLLER = "LoginServlet";
    private final String SEARCHCONTROLLER = "SearchServlet";
    private final String DELETECONTROLLER = "DeleteServlet";
    private final String UPDATECONTROLLER = "UpdateServlet";
    private final String VIEWCART = "viewCart.jsp";
    private final String ADDTOCART = "AddItemServlet";
    private final String REMOVECART = "DeleteItemServlet";
    private final String CREATEACCOUNT = "CreateAccountServlet";
    private final String CREATEACCOUNTERROR = "createNewAccount.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String url = LOGINPAGE;
            String button = request.getParameter("btAction");

            try {
                if (button == null) {

                } else if (button.equals("Login")) {
                    url = LOGINCONTROLLER;
                } else if (button.equals("Search")) {
                    url = SEARCHCONTROLLER;
                } else if (button.equals("Delete")) {
                    url = DELETECONTROLLER;
                } else if (button.equals("Update")) {
                    url = UPDATECONTROLLER;
                } else if (button.equals("Add Game To Your Cart")) {
                    url = ADDTOCART;
                } else if (button.equals("View Your Cart")) {
                    url = VIEWCART;
                } else if (button.equals("Remove Selected Items")) {
                    url = REMOVECART;
                } else if (button.equals("Create New Account")) {
                    url = CREATEACCOUNT;
                } else if (button.equals("CreateError")) {
                    url = CREATEACCOUNTERROR;
                }
            } finally {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                
                out.close();
            }
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

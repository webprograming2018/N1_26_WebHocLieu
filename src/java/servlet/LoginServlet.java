/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Qldt;

/**
 *
 * @author TruongDao
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String signout = request.getParameter("signout");
        if (signout.equals("ok")) {
            session.setAttribute("user", "");
            session.setAttribute("pass", "");
            response.getWriter().write("ok");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        response.getWriter().write("oki");
//        RequestDispatcher rd = request.getRequestDispatcher("home");
//        rd.forward(request, response);
        if (session.isNew()) {
            session.setAttribute("user", "");
            session.setAttribute("name", "");
//            response.getWriter().write("new");
        }
////            else{
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        String mainQLDT = "http://qldt.ptit.edu.vn/";
        String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";

        Qldt http = new Qldt();

        CookieHandler.setDefault(new CookieManager());

        try {
            http.GetCookie(mainQLDT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String postParams = http.getFormParams(user, pass);
        String name = "";
        try {
            name = http.sendPost(defaultQLDT, postParams);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().write(ex.toString());
        }
        if (!"".equals(name)) {
            session.setAttribute("user", user);
            session.setAttribute("name", name);
            response.getWriter().write(name);
        } else {
            session.setAttribute("user", "");
            session.setAttribute("name", "");
            response.getWriter().write("false");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

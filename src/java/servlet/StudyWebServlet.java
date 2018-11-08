/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import control.StudyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudyWeb;

/**
 *
 * @author TruongDao
 */
public class StudyWebServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        ArrayList<StudyWeb> listStudyWeb = new ArrayList<>();
        listStudyWeb = new StudyDAO("LapTrinhWeb", "sa", "1").select();
        String json = new StudyWeb().studyWebToJson(listStudyWeb);
        PrintWriter pw = response.getWriter();
        pw.write(json);    
        System.out.println(json);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

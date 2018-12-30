/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.File;
import model.News;

/**
 *
 * @author TruongDao
 */
public class FileDAO {

    private Connection conn = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private String database = "";
    private String user = "";
    private String pass = "";

    public FileDAO(String database, String user, String pass) {
        this.database = database;
        this.user = user;
        this.pass = pass;
        String connectionUrl = "jdbc:sqlserver://localhost;Instance=TRUONGDAO-PC\\KHANGHOA:1433;databaseName=" + database + ";user=" + user + ";password=" + pass;
        try {
            System.out.println("start");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection(connectionUrl);
            System.out.println("end");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertFile(model.File file) {
            String query = "INSERT INTO [dbo].[File] ([fileName],[link],[type]) values" + "(?,?,?)";
        try {
            pstm = conn.prepareStatement(query);
            String fileName = file.getFileName();
            pstm.setString(1, fileName);
            String link = file.getLink();
            pstm.setString(2, link);
            String type = file.getType();
            pstm.setString(3, type);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<model.File> getListFile(){
        ArrayList<model.File> listFile = new ArrayList<>();
        String query = "SELECT TOP 100 * FROM [dbo].[File] ORDER BY id DESC";
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int i = 0;
            while(rs.next()){
                File file = new File();
                file.setFileName(rs.getNString("fileName"));
                file.setLink(rs.getNString("link"));
                file.setType(rs.getNString("type"));
                listFile.add(file);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listFile;
    }
}

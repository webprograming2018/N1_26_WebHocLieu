/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author TruongDao
 */
public class Qldt {

    private List<String> cookies;
    private HttpURLConnection conn;
    private static final String USER_AGENT = "Mozilla/5.0";

    public String getFormParams(String username, String password) throws UnsupportedEncodingException {

        Map<String, String> params = new HashMap<>();

        params.put("__EVENTTARGET", "");
        params.put("__EVENTARGUMENT", "");
        params.put("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa", username);
        params.put("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau", password);
        params.put("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$btnDangNhap", "Đăng nhập");

        String result = "";
        for (String key : params.keySet()) {
            result += key + "=" + URLEncoder.encode(params.get(key), "UTF-8") + "&";
        }
        result = result.substring(0, result.length() - 1);

        return result;
    }

//    public static void main(String[] args) throws UnsupportedEncodingException, Exception {
//
//        String mainQLDT = "http://qldt.ptit.edu.vn/";
//        String defaultQLDT = "http://qldt.ptit.edu.vn/default.aspx";
//
//        Qldt http = new Qldt();
//
//        http.setCokie();
//
//        http.GetCookie(mainQLDT);
//        String postParams = http.getFormParams("B15DCCN660", "vuong19971015");
//        
//        System.out.println(http.sendPost(defaultQLDT, postParams));
//
//    }
//    
//    public void setCokie(){
//        CookieHandler.setDefault(new CookieManager());
//    }
    public String sendPost(String url, String postParams) throws Exception {

        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();

        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        for (String cookie : this.cookies) {
            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
        }

        HttpURLConnection.setFollowRedirects(true);
        conn.setDoOutput(true);
        conn.setDoInput(true);

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        // 
//        BufferedInputStream bif = new BufferedInputStream(conn.getInputStream());
//        byte[] buffer = new byte[1024];
//        String response = "";
//        int k = bif.read(buffer, 0, 1024);
//        while(k!=-1){
//            response += new String(buffer, 0, buffer.length, "UTF-8");
//            buffer = new byte[1024];
//            k = bif.read(buffer, 0, 1024);
//        }
//        bif.close();
        in.close();

        Document doc = Jsoup.parse(response.toString());

        String name = doc.getElementById("ctl00_Header1_ucLogout_lblNguoiDung").text();
        name = name.replace("Chào bạn ", "");

        Pattern pattern = Pattern.compile("\\((.+?)\\)");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            String studentID = matcher.group();
            name = name.replace(studentID, "");
            studentID = studentID.substring(1, studentID.length() - 1);
            System.out.println(studentID);
        }

//        System.out.println(name);
        return name;

    }

    public ArrayList<String> getMonHoc(String[] listMa) throws IOException {
        ArrayList<String> listMH = new ArrayList<>();
        String url = "http://qldt.ptit.edu.vn/Default.aspx?page=dkmonhoc";
        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();

        conn.setUseCaches(false);
        conn.setRequestMethod("GET");
//        for (String cookie : this.cookies) {
//            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
//        }

        HttpURLConnection.setFollowRedirects(true);
        conn.setDoOutput(true);
        conn.setDoInput(true);
//        String postParams = getFormParams("B15DCCN582", "basmnjnszk465");
//        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
//        wr.writeBytes(postParams);
//        wr.flush();
//        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Document doc = Jsoup.parse(response.toString());
        Element table = doc.getElementsByClass("body-table").first();
        Elements trs = table.getElementsByTag("tr");
        for (int i = 0; i < trs.size() - 1; i++) {
            Element td1 = trs.get(i).getElementsByTag("td").get(3);
            listMH.add(td1.text());
            Element td2 = trs.get(i).getElementsByTag("td").get(2);
            listMa[i] = td2.text();
            System.out.println(td1.text());
        }
        return listMH;
    }

    public void GetCookie(String url) throws Exception {
        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        setCookies(conn.getHeaderFields().get("Set-Cookie"));
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

//    public String checkLogin(String msv) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        Document doc = Jsoup.parse(response.toString());
//
//        String name = doc.getElementById("ctl00_Header1_ucLogout_lblNguoiDung").text();
//
//        name = name.replace("Chào ", "");
//
//        Pattern pattern = Pattern.compile("\\((.+?)\\)");
//        Matcher matcher = pattern.matcher(name);
//        if (matcher.find()) {
//            String studentID = matcher.group();
//            name = name.replace(studentID, "");
//            studentID = studentID.substring(1, studentID.length() - 1);
//            System.out.println(studentID);
//        }
//
//        System.out.println(name);
//        return name;
//    }
}

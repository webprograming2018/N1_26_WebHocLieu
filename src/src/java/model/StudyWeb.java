/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author TruongDao
 */
public class StudyWeb {
    private int id;
    private String tenBai;
    private String noiDung;
    private String code;

    public StudyWeb() {
    }

    public StudyWeb(int id, String tenBai, String noiDung, String code) {
        this.id = id;
        this.tenBai = tenBai;
        this.noiDung = noiDung;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBai() {
        return tenBai;
    }

    public void setTenBai(String tenBai) {
        this.tenBai = tenBai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String studyWebToJson(ArrayList<StudyWeb> listStudyWeb){
        StringBuffer json = new StringBuffer();
        json.append("[");
        for (StudyWeb studyWeb : listStudyWeb){
            json.append("{");
            json.append("\"tenBai\":\""+studyWeb.getTenBai()+"\",");
            json.append("\"noiDung\":\""+studyWeb.getNoiDung()+"\",");
            json.append("\"code\":\""+studyWeb.getCode()+"\"");
            json.append("},");
        }
        json.deleteCharAt(json.length()-1);
        json.append("]");
        
        return json.toString();
    }
}

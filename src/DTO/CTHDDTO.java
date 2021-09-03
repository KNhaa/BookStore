/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author lenovo-x220i
 */
public class CTHDDTO {
    private int soluong,thanhtien,tienkm;
    private String mahd,masach;
    public CTHDDTO()
    {
        
    }

    public CTHDDTO(String mahd, String masach, int soluong, int thanhtien, int tienkm) 
    {
        this.mahd = mahd;
        this.masach = masach;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.tienkm = tienkm;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getTienkm() {
        return tienkm;
    }

    public void setTienkm(int tienkm) {
        this.tienkm = tienkm;
    }
    
}

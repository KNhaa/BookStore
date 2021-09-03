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
public class CTNhapDTO {
    private String manhap,masach;
    private int soluong,gianhap,thanhtien, trangthai;
    
    public CTNhapDTO()
    {
        
    }

    public CTNhapDTO(String manhap, String masach, int soluong, int gianhap, int thanhtien, int trangthai) {
        this.manhap = manhap;
        this.masach = masach;
        this.soluong = soluong;
        this.gianhap = gianhap;
        this.thanhtien = thanhtien;
        this.trangthai = trangthai;
    }

    public String getManhap() {
        return manhap;
    }

    public void setManhap(String manhap) {
        this.manhap = manhap;
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

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
}

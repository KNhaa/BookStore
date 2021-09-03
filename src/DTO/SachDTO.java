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
public class SachDTO {
    private String masach,matg,maloai,manxb,mancc, tensach;
    private int soluong,dongia, trangthai;
    
    public SachDTO()
    {
      
    }

    public SachDTO(String masach, String matg, String maloai, String manxb, String mancc, String tensach, int soluong, int dongia, int trangthai) {
        this.masach = masach;
        this.matg = matg;
        this.maloai = maloai;
        this.manxb = manxb;
        this.mancc = mancc;
        this.tensach = tensach;
        this.soluong = soluong;
        this.dongia = dongia;
        this.trangthai = trangthai;
    }

    

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    
    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getMatg() {
        return matg;
    }

    public void setMatg(String matg) {
        this.matg = matg;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getManxb() {
        return manxb;
    }

    public void setManxb(String manxb) {
        this.manxb = manxb;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    

    
    
}

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
public class PhieuNhapDTO {
    private int tongtien;
    private String manhap, manv,mancc, ngaynhap;
    public PhieuNhapDTO()
    {
        
    }

    public PhieuNhapDTO(int tongtien, String manhap, String manv, String mancc, String ngaynhap) {
        this.tongtien = tongtien;
        this.manhap = manhap;
        this.manv = manv;
        this.mancc = mancc;
        this.ngaynhap = ngaynhap;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getManhap() {
        return manhap;
    }

    public void setManhap(String manhap) {
        this.manhap = manhap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

   

    

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
}

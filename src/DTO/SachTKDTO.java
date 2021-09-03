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
public class SachTKDTO {
    private String masach,tenloai,manxb,tensach;
    private int soluong,dongia;
    
    public SachTKDTO()
    {
      
    }

    public SachTKDTO(String masach, String tenloai, String manxb, String tensach, int soluong, int dongia) {
        this.masach = masach;
        this.tenloai = tenloai;
        this.manxb = manxb;
        this.tensach = tensach;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
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

    

    

   
   
}

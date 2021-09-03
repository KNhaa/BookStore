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
public class NhanVienDTO {
    private String luong;
    private String manv,honv,tennv,sdt,diachi,tentk;
    public NhanVienDTO()
    {
        
    }
 public NhanVienDTO(String manv, String luong, String honv, String tennv, String sdt, String diachi,String tentk) {
        this.manv = manv;
        this.luong = luong;
        this.honv = honv;
        this.tennv = tennv;
        this.sdt = sdt;
        this.diachi = diachi;
         this.tentk = tentk;
    }
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

   

    public String getHonv() {
        return honv;
    }

    public void setHonv(String honv) {
        this.honv = honv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

   
}

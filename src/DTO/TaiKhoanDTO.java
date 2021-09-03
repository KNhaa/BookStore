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
public class TaiKhoanDTO {
    private String tentaikhoan,matkhau,vaitro;
    private int trangthai;
    public TaiKhoanDTO()
    {
        
    }

    public TaiKhoanDTO(String tentaikhoan, String matkhau, String vaitro,int trangthai) {
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
        this.trangthai = trangthai;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    
    
    
    
}

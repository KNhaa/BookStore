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
public class HoaDonDTO {
    private int tienkm,tongtien,thuctra;
    private String ngaylaphd,mahd,makm,makh,manv;
    public HoaDonDTO()
    {
        
    }

    public HoaDonDTO(String mahd, int tienkm, String makm,String makh, String manv, int tongtien, int thuctra, String ngaylaphd) {
        this.mahd = mahd;
        this.tienkm = tienkm;
        this.makm = makm;
        this.makh = makh;
        this.manv = manv;
        this.tongtien = tongtien;
        this.thuctra = thuctra;
        this.ngaylaphd = ngaylaphd;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public int getTienkm() {
        return tienkm;
    }

    public void setTienkm(int tienkm) {
        this.tienkm = tienkm;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    
    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getThuctra() {
        return thuctra;
    }

    public void setThuctra(int thuctra) {
        this.thuctra = thuctra;
    }

    public String getNgaylaphd() {
        return ngaylaphd;
    }

    public void setNgaylaphd(String ngaylaphd) {
        this.ngaylaphd = ngaylaphd;
    }
    
}

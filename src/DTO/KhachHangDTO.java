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
public class KhachHangDTO {
    private int tinhtrang;
    private String makh,hokh,tenkh,sdt,diachi;
    public KhachHangDTO()
    {
        
    }

    public KhachHangDTO(String makh, String hokh, String tenkh, String sdt, String diachi, int tinhtrang) {
        this.makh = makh;
        this.hokh = hokh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHokh() {
        return hokh;
    }

    public void setHokh(String hokh) {
        this.hokh = hokh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
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

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }  
    
}

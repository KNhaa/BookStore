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
public class LoaiDTO {
    private int maloai;
    private String tenloai;

    public LoaiDTO(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }
    public LoaiDTO()
    {
        
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    
}

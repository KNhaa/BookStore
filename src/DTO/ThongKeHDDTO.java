/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author acer
 */
public class ThongKeHDDTO {
    private String masach,tensach;
    private int tongthunhap,tongluongban;

    public ThongKeHDDTO() {
    }

    public ThongKeHDDTO(String masach, String tensach, int tongthunhap, int tongluongban) {
        this.masach = masach;
        this.tensach = tensach;
        this.tongthunhap = tongthunhap;
        this.tongluongban = tongluongban;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    
    public int getTongthunhap() {
        return tongthunhap;
    }

    public void setTongthunhap(int tongthunhap) {
        this.tongthunhap = tongthunhap;
    }

    public int getTongluongban() {
        return tongluongban;
    }

    public void setTongluongban(int tongluongban) {
        this.tongluongban = tongluongban;
    }
    
    
}

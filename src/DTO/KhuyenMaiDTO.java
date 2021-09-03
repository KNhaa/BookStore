/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

public class KhuyenMaiDTO {
    
    private String makm,tenkm;
    private int tilegiam,quidinh;
public KhuyenMaiDTO()
{
    
}
    public KhuyenMaiDTO(String makm, String tenkm, int tilegiam, int quidinh) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.tilegiam = tilegiam;
        this.quidinh = quidinh;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public int getTilegiam() {
        return tilegiam;
    }

    public void setTilegiam(int tilegiam) {
        this.tilegiam = tilegiam;
    }

    public int getQuidinh() {
        return quidinh;
    }

    public void setQuidinh(int quidinh) {
        this.quidinh = quidinh;
    }
    
        
   
  

 
}

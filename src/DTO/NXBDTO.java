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
public class NXBDTO {
    private int manxb;
    private String tennxb;
    public NXBDTO()
    {
        
    }

    public int getManxb() {
        return manxb;
    }

    public void setManxb(int manxb) {
        this.manxb = manxb;
    }

    public String getTennxb() {
        return tennxb;
    }

    public void setTennxb(String tennxb) {
        this.tennxb = tennxb;
    }

    public NXBDTO(int manxb, String tennxb) {
        this.manxb = manxb;
        this.tennxb = tennxb;
    }
}

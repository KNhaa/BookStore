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
public class TacGiaDTO {
    private String matg, tentg;
    public TacGiaDTO(String matg,String tentg)
    {
     this.matg=matg;
     this.tentg=tentg;
    }
    public TacGiaDTO()
    {
        
    }

    public String getMatg() {
        return matg;
    }

    public void setMatg(String matg) {
        this.matg = matg;
    }

    public String getTentg() {
        return tentg;
    }

    public void setTentg(String tentg) {
        this.tentg = tentg;
    }
    
}

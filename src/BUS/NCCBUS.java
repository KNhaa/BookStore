/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NCCDAO;
import DTO.NCCDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class NCCBUS {
     public static ArrayList<NCCDTO> dsloai;

    public NCCBUS() {
    }

    public void docdsloai() {
        NCCDAO data = new NCCDAO();
        if (dsloai == null) {
            dsloai = new ArrayList<NCCDTO>();
            dsloai = data.docdsncc();
        }
    }
}

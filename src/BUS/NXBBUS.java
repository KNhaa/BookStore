/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NCCDAO;
import DAO.NXBDAO;
import DTO.NCCDTO;
import DTO.NXBDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class NXBBUS {
     public static ArrayList<NXBDTO> dsnxb;

    public NXBBUS() {
    }

    public void docdsnxb() {
        NXBDAO data = new NXBDAO();
        if (dsnxb == null) {
            dsnxb = new ArrayList<NXBDTO>();
            dsnxb = data.docdsnxb();
        }
    }
}

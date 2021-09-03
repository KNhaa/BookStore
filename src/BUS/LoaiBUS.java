/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.LoaiDAO;
import DTO.LoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class LoaiBUS {
    public static ArrayList<LoaiDTO> dsloai;

    public LoaiBUS() {
    }

    public void docdsloai() {
        LoaiDAO data = new LoaiDAO();
        if (dsloai == null) {
            dsloai = new ArrayList<LoaiDTO>();
            dsloai = data.docdsloai();
        }
    }
}

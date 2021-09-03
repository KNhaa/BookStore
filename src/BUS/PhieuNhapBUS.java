/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

//import static BUS.HoaDonBUS.dshd;
import DAO.PhieuNhapDAO;
import DTO.CTNhapDTO;
import DTO.PhieuNhapDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class PhieuNhapBUS {

    public static ArrayList<PhieuNhapDTO> dspn;

    public Date ChuyenDate(String fmd) throws ParseException {
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Date d = fm.parse(fmd);
        return d;
    }

    public PhieuNhapBUS() {
    }

    public void docDSPN() {
        PhieuNhapDAO data = new PhieuNhapDAO();
        if (dspn == null) {
            dspn = new ArrayList<PhieuNhapDTO>();
        }
        dspn = data.docdsphieunhap();
    }

    public PhieuNhapDTO TimPNtheoCTPN(CTNhapDTO ctpn) {
        for (PhieuNhapDTO x : dspn) {
            if (x.getManhap().equals(ctpn.getManhap())) {
                return x;
            }
        }
        JOptionPane.showMessageDialog(null, "Không thể tìm ra PN này");
        return null;
    }

    public String Pntieptheo() {
//        PhieuNhapDTO pn = dspn.get(dspn.size() - 1);
//        String a = pn.getMapn();
//        String[] so = a.split("H");
//        int b = Integer.valueOf(so[1]);
//        b++;
//        String com = so[0] + "H" + String.valueOf(b);
//        return com;
        
//        PhieuNhapDTO pn = dspn.get(dspn.size() - 1);
//        int a = Integer.parseInt(pn.getManhap());
//        a = a + 1;
//        String nextid = String.valueOf(a);
        PhieuNhapDAO pndao = new PhieuNhapDAO();
        int a = pndao.demPN()+1;       
        String nextid = String.valueOf(a);
        return nextid;
    }

    public boolean ThemPN(PhieuNhapDTO pn) {
        //String regex = "^PNH[0-9]{2}$";
        String regex = "^[0-9]{1,2}$";
        if (pn.getManhap().matches(regex) == false) {
            JOptionPane.showMessageDialog(null, "Mã PNH không đúng định dạng");
            return false;
        }

        for (PhieuNhapDTO x : dspn) {
            if (x.getManhap().equals(pn.getManhap())) {
                JOptionPane.showMessageDialog(null, "Mã PNH đã tồn tại");
                return false;
            }
        }
        dspn.add(pn);
        PhieuNhapDAO data = new PhieuNhapDAO();
        data.Them(pn);
        return true;
    }

    public void XoaPN(PhieuNhapDTO pn) {
        int index = -1;
        for (PhieuNhapDTO x : dspn) {
            index++;
            if (x.getManhap().equals(pn.getManhap())) {
                break;
            }
        }
        dspn.remove(index);
        CTPhieuNhapBUS bus = new CTPhieuNhapBUS();
        bus.XoaallCTPNtheoPN(pn.getManhap());
        PhieuNhapDAO data = new PhieuNhapDAO();
        data.Xoa(pn.getManhap());
    }

    public void SuaPN(PhieuNhapDTO pn) {
        int index = -1;
        for (PhieuNhapDTO x : dspn) {
            index++;
            if (x.getManhap().equals(pn.getNgaynhap())) {
                //hd = x;
                break;
            }
        }

        dspn.set(index, pn);

        PhieuNhapDAO data = new PhieuNhapDAO();
        data.Sua(pn);
    }

    public ArrayList<PhieuNhapDTO> Timkiemnangcao(int Giatu, int Giaden, String ngaytu, String ngayden) throws ParseException {
        ArrayList<PhieuNhapDTO> dstk = new ArrayList<>();
        for (PhieuNhapDTO x : dspn) {
            if ((Giatu <= x.getTongtien() && x.getTongtien() <= Giaden) && (ChuyenDate(ngaytu).compareTo(ChuyenDate(x.getNgaynhap())) <= 0 && ChuyenDate(ngayden).compareTo(ChuyenDate(x.getNgaynhap())) >= 0)) {
                dstk.add(x);
            }
        }
        return dstk;
    }

}

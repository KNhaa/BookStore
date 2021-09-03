package BUS;

import DAO.CTNhapDAO;
import DAO.SachDAO;
import DTO.CTNhapDTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class CTPhieuNhapBUS {
    public static ArrayList<CTNhapDTO> dsctpn;
    public CTPhieuNhapBUS()
    {

    }
    
    public void docCTPNtheoPN(String mapn) 
    {
        CTNhapDAO data = new CTNhapDAO();
        if (dsctpn == null) 
        {
            dsctpn = new ArrayList<>();
        }
        dsctpn = data.docDSHDtheoHD(mapn);  
    }
             
     public boolean ThemCTHDtheoHD(CTNhapDTO ctpn) {
        String regex = "^[0-9]{1,}$";
        if (ctpn.getManhap().matches(regex) == false) {
            JOptionPane.showMessageDialog(null, "Mã PN không đúng định dạng");
            return false;
        }
        if (dsctpn != null) {
            for (CTNhapDTO x : dsctpn) {
                if (x.getMasach().equals(ctpn.getMasach())) {
                    JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại trong CTPN");
                    return false;
                }
            }
        }
        dsctpn.add(ctpn);
        CTNhapDAO data = new CTNhapDAO();
        data.Them(ctpn);
        
        //Tăng số lượng sách
        SachDAO sachdao = new SachDAO();
        int soluongcu=0;
        int soluongmoi=0;
        soluongcu=sachdao.getQuanity(ctpn.getMasach());
        soluongmoi = soluongcu+ctpn.getSoluong();
        sachdao.TangSoluong(ctpn.getMasach(), soluongmoi);
        return true;
    }
     
      public void XoaCTPNtheoPN(CTNhapDTO ctpn) {
        int index = -1;
        System.out.println(dsctpn.size());
        for (CTNhapDTO x : dsctpn)
        {
            index++;
            if(x.getManhap().equals(ctpn.getManhap()) && x.getMasach().equals(ctpn.getMasach()))
            break;
        }
        
        dsctpn.remove(index);
        CTNhapDAO data = new CTNhapDAO();
        data.Xoa(ctpn);
    }
      
//    public void SuaCTPNtheoPN(CTNhapDTO ctpn)
//    {
//        int index = -1;
//        for (CTNhapDTO x : dsctpn)
//        {
//            index++;
//            if(x.getManhap().equals(ctpn.getManhap()) && x.getMasach().equals(ctpn.getMasach()))
//            break;
//        }
//        System.out.println(ctpn.getSoluong());
//        dsctpn.set(index, ctpn);
//        //System.out.println(dscthd.get(index));
//        CTNhapDAO data = new CTNhapDAO();
//        data.Sua(ctpn);
//    }
        public void XoaallCTPNtheoPN(String manhap) {
//        int index = -1;
//        for (CTHoaDonDTO x : dscthd)
//        {
//            index++;
//            if(x.getMahd().equals(ma))
//            {
//                dscthd.remove(index);
//                index--;
//            }
//        }
        CTNhapDAO data = new CTNhapDAO();
        data.Xoaall(manhap);
    }
}

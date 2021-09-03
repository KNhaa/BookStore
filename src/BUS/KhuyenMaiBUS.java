/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author DELL
 */

//import DAO.KhuyenMaiDipDAO;
//import DAO.KhuyenMaiTheoHoaDonDAO;
//import DAO.KhuyenMaiTheoSanPhamDAO;
import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
//import DTO.KhuyenMaiDipDTO;
//import DTO.KhuyenMaiTheoHoaDonDTO;
//import DTO.KhuyenMaiTheoSanPhamDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class KhuyenMaiBUS {
    
    public static ArrayList<KhuyenMaiDTO> dskm;
   // public static ArrayList<KhuyenMaiTheoHoaDonDTO> dskmthd;
  //  public static ArrayList<KhuyenMaiTheoSanPhamDTO> dskmtsp;
    
    public KhuyenMaiBUS() {
    }

    public void docDSKMD() {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        if (dskm == null) {
            dskm = new ArrayList<KhuyenMaiDTO>();
        }
        dskm = data.docdskhuyenmai();
    }
    
   
    
    
    
//    public KhuyenMaiDipDTO getInfoRowOfKMD(String Ma) {
//        KhuyenMaiDipDTO KMD = new KhuyenMaiDipDTO("temp","temp");
//        docDSKMD();
//        for (KhuyenMaiDipDTO tempkmd : KhuyenMaiBUS.dskmd) {
//            if (tempkmd.getMakm().equals(Ma)) {
//                KMD = tempkmd;
//                break;
//            }
//        }
//        return KMD;
//    }
//            
//    public KhuyenMaiTheoHoaDonDTO getInfoRowOfKMT(String Ma) {
//        KhuyenMaiTheoHoaDonDTO KMTHD =  new KhuyenMaiTheoHoaDonDTO("temp","temp");
//        docDSKMTHD();
//        for (KhuyenMaiTheoHoaDonDTO tempkmthd : KhuyenMaiBUS.dskmthd) {
//            if (tempkmthd.getMakm().equals(Ma)) {
//                KMTHD = tempkmthd;
//                break;
//            }
//        }
//        return KMTHD;
//    }
//    
//    public KhuyenMaiTheoSanPhamDTO getInfoRowOfKMTSP(String Ma){
//        KhuyenMaiTheoSanPhamDTO KMTSP = new KhuyenMaiTheoSanPhamDTO("temp","temp");
//        docDSKMTSP();
//        for (KhuyenMaiTheoSanPhamDTO tempkmtsp : KhuyenMaiBUS.dskmtsp) {
//            if (tempkmtsp.getMakm().equals(Ma)) {
//                KMTSP = tempkmtsp;
//                break;
//            }
//        }
//        return KMTSP;
//    }
//
//    public String duyetMota(String makm)
//    {
//        for (KhuyenMaiDipDTO dskmd1 : dskmd) {
//            if(makm.equals(dskmd1.getMakm()))
//            {
//                KhuyenMaiDTO x = dskmd1;
//                return x.getTen();
//            }
//        }
//        
//        for (KhuyenMaiTheoHoaDonDTO dskmthd1 : dskmthd) {
//            if(makm.equals(dskmthd1.getMakm()))
//            {
//                KhuyenMaiDTO x = dskmthd1;
//                return x.getTen();
//            }
//        }
//        
//        for (KhuyenMaiTheoSanPhamDTO dskmtsp1 : dskmtsp) {
//            if(makm.equals(dskmtsp1.getMakm())) {
//                KhuyenMaiDTO x = dskmtsp1;
//                return x.getTen();
//            }
//        }
//        
//        return "Trống";
//    }
//    
     public int duyetTile(String makm)
    {
        for (KhuyenMaiDTO dskm : dskm) {
            if(makm.equals(dskm.getMakm()))
            return dskm.getTilegiam();
        }
        
        return 0;
    }

        public Date ChuyenDate(String fmd) throws ParseException {
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Date d = fm.parse(fmd);
        return d;
    }

//    public String trangthaiDSKMD(String Ngaybd,String Ngaykt) throws ParseException
//    {
//        Date now = new Date();
//        String s = "Chưa diễn ra";
//            if(now.after(ChuyenDate(Ngaybd)) && now.before(ChuyenDate(Ngaykt)))
//                return "Đang diễn ra";
//        return s;
//    }
    
    public String trangthaiDSKM(int hoadon,int hoadontong) 
    {
        String s = "Chưa diễn ra";
        if(hoadon >= hoadontong)
            return "Đang diễn ra";
        return s;
    }
    
//    public String trangthaiDSKMTSP(int soluong,int soluongtong)
//    {
//        String s = "Chưa diễn ra";
//        if(soluong >= soluongtong)
//            return "Đang diễn ra";
//        return s;
//    }        

//    public Object trangthaiDSKM(JTextField txtongtien, int quidinh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
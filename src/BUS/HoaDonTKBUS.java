/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.CTHDDTO;
import DTO.HoaDonDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class HoaDonTKBUS {
    public static ArrayList<HoaDonDTO> dshd;
      public Date ChuyenDate(String fmd) throws ParseException {
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Date d = fm.parse(fmd);
        return d;
    }

    public HoaDonTKBUS()
    {
        
    }
    public void docDSHD()
    {
        HoaDonDAO data=new HoaDonDAO();
        if(dshd==null)
            dshd=new ArrayList<HoaDonDTO>();
        dshd=data.docdshoadon();
    }
    
    public HoaDonDTO TimHDtheoCTHD(CTHDDTO cthd)
    {
        for(HoaDonDTO x:dshd)
        {
            if(x.getMahd().equals(cthd.getMahd()))
            {
                return x;
            } 
        }
        JOptionPane.showMessageDialog(null,"không tìm ra hóa đơn");
        return null;
    }
    public HoaDonDTO TimHDtheoMa(String mahd)
    {
        for(HoaDonDTO x:dshd)
        {
            if(x.getMahd().equals(mahd))
            {
                return x;
            }
        }
        JOptionPane.showMessageDialog(null,"Khong tim ra hoa don");
        return null;
    }
    public boolean ThemHD(HoaDonDTO hd)
    {
        String regex="^[0-9]{2}$";
        if(hd.getMahd().matches(regex)==false)
        {
            JOptionPane.showMessageDialog(null,"Ma hoa don khong hop le");
            return false;
        }
        for(HoaDonDTO x:dshd)
        {
            if(x.getMahd().equals(hd.getMahd()))
            {
                JOptionPane.showMessageDialog(null,"Ma hoa don da ton tai");
                return false;
            }
        }
    
    dshd.add(hd);
    HoaDonDAO data=new HoaDonDAO();
    data.Them(hd);
    return true;
    
    }
    public void XoaHD(HoaDonDTO hd)
    {
        int index=-1;
        for(HoaDonDTO x:dshd)
        {
            index++;
            if(x.getMahd().equals(hd.getMahd()))
            {
                break;
            }
        }
        dshd.remove(index);
        CTHDTKBUS bus=new CTHDTKBUS();
        bus.XoaallCTHDtheoHD(hd.getMahd());
        HoaDonDAO data=new HoaDonDAO();
        data.Xoa(hd.getMahd());
        
    }
    public void SuaHD(HoaDonDTO hd)
    {
        int index=-1;
        for(HoaDonDTO x:dshd)
        {
            if(x.getMahd().equals(hd.getMahd()))
            {
                break;
            }
        }
       // System.out.println("HD truoc khi set index" + hd.getSoluongtong());
        dshd.set(index, hd);
       // System.out.println("HD sau khi set index" + hd.getSoluong());
       HoaDonDAO data=new HoaDonDAO();
       data.Sua(hd);
    }
    public int Tonghoadon()
    {
        int s=0;
        for(HoaDonDTO x:dshd)
        {
            s+=x.getThuctra();
        }
        return s;
    }
    
      public int Tonghoadontheokh(String makh) {
        int s = 0;
        for (HoaDonDTO x : dshd) {
            if (makh.equals(x.getMakh())) {
                s += x.getThuctra();
            }
        }
        return s;
    }
      
    public ArrayList<HoaDonDTO> Thongkekh(String makh) {
        ArrayList<HoaDonDTO> dshdtheokh = new ArrayList<>();
        for (HoaDonDTO x : dshd) {
            if (x.getMakh().equals(makh)) {
                dshdtheokh.add(x);
            }
        }
        return dshdtheokh;
    }
     public ArrayList<HoaDonDTO> Thongkenv(String manv) {
        ArrayList<HoaDonDTO> dshdtheonv = new ArrayList<>();
        for (HoaDonDTO x : dshd) {
            if (x.getManv().equals(manv)) {
                dshdtheonv.add(x);
            }
        }
        return dshdtheonv;
 
     }
       public int Tonghoadontheonv(String manv) {
        int s = 0;
        for (HoaDonDTO x : dshd) {
            if (manv.equals(x.getManv())) {
                s += x.getThuctra();
            }
        }
        return s;
    }
        public ArrayList<HoaDonDTO> Timkiemtheothangnam(String thang, String nam) throws ParseException {
//        docDSHD();
        //System.out.println(nam);
        ArrayList<HoaDonDTO> dstk = new ArrayList<>();
        for (HoaDonDTO x : dshd) {
            
            if ((ChuyenDate(x.getNgaylaphd()).getMonth() + 1) == (Integer.valueOf(thang))
                    && (ChuyenDate(x.getNgaylaphd()).getYear() + 1900) == (Integer.valueOf(nam))) {
                System.out.println(x.getMahd());
                dstk.add(x);
            }
        }
        return dstk;
    }

    public  int checkquy(HoaDonDTO hd, String quy, String nam) throws ParseException {
//        docDSHD();
        String ngaybd;
        String ngaykt;
        if (quy.equals("1")) {
            ngaybd = nam + "-01-01";
            Date ngaybdtemp = ChuyenDate(ngaybd);
            ngaykt = nam + "-03-31";
            Date ngaykttemp = ChuyenDate(ngaykt);
            Date temp = ChuyenDate(hd.getNgaylaphd());
            if (temp.compareTo(ngaybdtemp) >= 0 && temp.compareTo(ngaykttemp) <= 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (quy.equals("2")) {
            ngaybd = nam + "-04-01";
            Date ngaybdtemp = ChuyenDate(ngaybd);
            ngaykt = nam + "-06-30";
            Date ngaykttemp = ChuyenDate(ngaykt);
            Date temp = ChuyenDate(hd.getNgaylaphd());
            if (temp.compareTo(ngaybdtemp) >= 0 && temp.compareTo(ngaykttemp) <= 0) {
                return 1;

            } else {
                return 0;

            }
        }
        if (quy.equals("3")) {
            ngaybd = nam + "-07-01";
            Date ngaybdtemp = ChuyenDate(ngaybd);
            ngaykt = nam + "-09-30";
            Date ngaykttemp = ChuyenDate(ngaykt);
            Date temp = ChuyenDate(hd.getNgaylaphd());
            if (temp.compareTo(ngaybdtemp) >= 0 && temp.compareTo(ngaykttemp) <= 0) {
                return 1;

            } else {
                
                return 0;

            }
        }
        if (quy.equals("4")) {
            ngaybd = nam + "-10-01";
            Date ngaybdtemp = ChuyenDate(ngaybd);
            ngaykt = nam + "-12-31";
            Date ngaykttemp = ChuyenDate(ngaykt);
            Date temp = ChuyenDate(hd.getNgaylaphd());
            if (temp.compareTo(ngaybdtemp) >= 0 && temp.compareTo(ngaykttemp) <= 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public ArrayList<HoaDonDTO> Timkiemtheoquynam(String quy, String nam) throws ParseException {
        docDSHD();
        ArrayList<HoaDonDTO> dstk = new ArrayList<>();
        for (HoaDonDTO x : dshd) 
        {
            if (checkquy(x, quy, nam) == 1)
            {
                dstk.add(x);
            }
        }
        return dstk;
    }
    public ArrayList<HoaDonDTO> Timkiemtheonam(String nam) throws ParseException {
//        docDSHD();
        ArrayList<HoaDonDTO> dstk = new ArrayList<>();
        for (HoaDonDTO x : dshd) {
            if ((ChuyenDate(x.getNgaylaphd()).getYear() + 1900) == (Integer.valueOf(nam))) {
                dstk.add(x);
            }
        }
        return dstk;
    }
}

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
public class HoaDonBUS {
    public static ArrayList<HoaDonDTO> dshd;
    
    public HoaDonBUS()
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
        String regex="^[0-9]{1,2}$";
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
        CTHDBUS bus=new CTHDBUS();
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
            s+=x.getTongtien();
        }
        return s;
    }
    public String Hdtieptheo() {
//        HoaDonDTO hd = dshd.get(dshd.size() - 1);
//        int a = Integer.parseInt(hd.getMahd());
//        a++;
//        String b=String.valueOf(a);
//        return b;
        HoaDonDAO hd=new HoaDonDAO();
        int a=hd.demhd()+1;
        String nextid=String.valueOf(a);
        return nextid;
    }
    
}

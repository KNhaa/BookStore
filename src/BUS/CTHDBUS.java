/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.CTHDBUS.dscthd;
import static BUS.HoaDonBUS.dshd;
import DAO.CTHDDAO;
import DAO.HoaDonDAO;
import DAO.SachDAO;
import DTO.CTHDDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class CTHDBUS {
    public static ArrayList<CTHDDTO> dscthd;
    public static ArrayList<CTHDDTO> dsall;
    public CTHDBUS()
    {
        
    }
    public void docCTHDtheoHD(String mahd)
    {
        CTHDDAO data=new CTHDDAO();
        if(dscthd==null)
            dscthd=new ArrayList<>();
         dscthd=data.docDSHDtheoHD(mahd);
    }
    public void docallCTHD()
    {
        CTHDDAO data=new CTHDDAO();
        if(dsall==null)
            dsall=new ArrayList<>();
        dsall=data.docallCTHD();
    }
    public boolean ThemCTHDtheoHD(CTHDDTO cthd)
    {
        String regex="[0-9]{1,2}$";
        if(cthd.getMahd().matches(regex)==false)
        {
            JOptionPane.showMessageDialog(null,"Ma hoa don khong hop le");
            return false;
        }
        //kiem tra ma hoa don 
      
        if(dscthd!=null)
        {
            for(CTHDDTO x:dscthd)
            {
                if(x.getMasach().equals(cthd.getMasach()))
                {
                    JOptionPane.showMessageDialog(null,"ma san pham da ton tai");
                    return false;
                }
            }
        }
        dscthd.add(cthd);
        CTHDDAO data=new CTHDDAO();
        data.Them(cthd);
        
        SachDAO sachdao = new SachDAO();
        int soluongcu = 0;
        int soluongmoi = 0;
        soluongcu = sachdao.getQuanity(cthd.getMasach());
        soluongmoi = soluongcu - cthd.getSoluong();
        sachdao.TangSoluong(cthd.getMasach(), soluongmoi); // cập nhật số lượng sách
        
        return true;
    }
    public void XoaCTHDtheoHD(CTHDDTO cthd)
    {
        int index=-1;
        System.out.println(dscthd.size());
        for(CTHDDTO x:dscthd)
        {
            index++;
            if(x.getMahd().equals(cthd.getMahd()) && x.getMasach().equals(cthd.getMasach()))
                break;
        }
        dscthd.add(cthd);
        CTHDDAO data=new CTHDDAO();
        data.Xoa(cthd);
    }
    // xóa HD thì xóa tất cả CTHD của HD đó
    public void XoaallCTHDtheoHD(String ma)
    {
        CTHDDAO data=new CTHDDAO();
        data.Xoaall(ma);
    }
    
    public void SuaCTHDtheoHD(CTHDDTO cthd)
    {
        int index=-1;
        for(CTHDDTO x:dscthd)
        {
            index++;
            if(x.getMahd().equals(cthd.getMahd())&& x.getMasach().equals(cthd.getMasach()))
                break;
        }
        System.out.println(cthd.getSoluong());
        dscthd.set(index, cthd);
        CTHDDAO data=new CTHDDAO();
        data.Sua(cthd);
    }
    
  
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.CTHDTKBUS.dscthd;
import DAO.CTHDDAO;
import DTO.CTHDDTO;
import DTO.HoaDonDTO;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class CTHDTKBUS {
    public static ArrayList<CTHDDTO> dscthd;
    public static ArrayList<CTHDDTO> dsall;
    public CTHDTKBUS()
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
        String regex="[0-9]{2}$";
        if(cthd.getMahd().matches(regex)==false)
        {
            JOptionPane.showMessageDialog(null,"Ma hoa don khong hop le");
            return false;
        }
        if(dscthd!=null)
        {
            for(CTHDDTO x:dscthd)
            {
                if(x.getMasach().equals(cthd.getMasach()))
                {
                    JOptionPane.showMessageDialog(null,"ma san pham da ton tai");
                }
            }
        }
        dscthd.add(cthd);
        CTHDDAO data=new CTHDDAO();
        data.Them(cthd);
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
//     public int ThunhapSP(String masp, ArrayList<CTHDDTO> temp)
//    {
//        int thunhap = 0;
//        for (CTHDDTO x : temp)
//        {
//            if(x.getMasach().equals(masp))
//            thunhap += ( x.getThanhtien() * x.getSoluong() );
//        }
//        return thunhap;
//    }
         public int ThunhapSP(String masp, ArrayList<CTHDDTO> temp, ArrayList<HoaDonDTO> temp1)
    {
       
        int thunhap = 0;
        for (HoaDonDTO x : temp1)
        {
            for (CTHDDTO y : temp)
            {
            if(x.getMahd().equals(y.getMahd())&&y.getMasach().equals(masp))
            {
//                   for(HoaDonDTO hd :HoaDonBUS())
                   
                         thunhap +=  x.getThuctra();}
            }
                    System.out.println("BUS.CTHDBUS.ThunhapSP()"+"vaf "+x.getMahd());}
        
        System.out.println("BUS.CTHDBUS.ThunhapSP()"+thunhap);
        return thunhap;
    }
    public int SoluongbanSP(String masp, ArrayList<CTHDDTO> temp)
    {
        int slban = 0;
        for (CTHDDTO x : temp)
        {
            if(x.getMasach().equals(masp))
            slban += x.getSoluong();
        }
        return slban;
    }
   public ArrayList<CTHDDTO> theonam (String nam) throws ParseException
    {
       // docallCTHD();
        HoaDonTKBUS bushd = new HoaDonTKBUS();
        ArrayList<CTHDDTO> temp = new ArrayList<>();
        for (HoaDonDTO hd : bushd.Timkiemtheonam(nam))
            for (CTHDDTO cthd : dsall )
            {
                if(cthd.getMahd().equals(hd.getMahd()))
                    temp.add(cthd);
            }
        
        return temp;
    }
    
    public ArrayList<CTHDDTO> theothangnam (String thang,String nam) throws ParseException
    {
      //  docallCTHD();
        HoaDonTKBUS bushd = new HoaDonTKBUS();
        ArrayList<CTHDDTO> temp = new ArrayList<>();
        ArrayList<HoaDonDTO> duyet = bushd.Timkiemtheothangnam(thang,nam);
        for (HoaDonDTO hd : duyet)
        {
            //System.out.println("???");
            for (CTHDDTO cthd : dsall )
            {
                if(cthd.getMahd().equals(hd.getMahd()))
                    
                    temp.add(cthd);
            }
            
        }
            
        
        return temp;
    }
    
    public ArrayList<CTHDDTO> theoquynam (String quy,String nam) throws ParseException
    {
    //    docallCTHD();
        HoaDonTKBUS bushd = new HoaDonTKBUS();
        ArrayList<CTHDDTO> temp = new ArrayList<>();
        for (HoaDonDTO hd : bushd.Timkiemtheoquynam(quy,nam))
            for (CTHDDTO cthd : dsall )
            {
                if(cthd.getMahd().equals(hd.getMahd()))
                    temp.add(cthd);
            }
        
        return temp;
    }
}
    

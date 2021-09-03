/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.CTHDDTO;
import DTO.SachDTO;
import DTO.SachTKDTO;
import DTO.ThongKeHDDTO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author acer
 */
public class ThongKeHDBUS {
    public static ArrayList <ThongKeHDDTO> dstkhd ;
    public static ArrayList <ThongKeHDDTO> dstkhdtheonam ;
    public static ArrayList <ThongKeHDDTO> dstkhdtheothangnam ;
    public static ArrayList <ThongKeHDDTO> dstkhdtheoquynam ;
    
    public ThongKeHDBUS (){}
    
    public void docDSTKHD ()
    {
        SachTKBUS bussp = new SachTKBUS();
        if (SachTKBUS.dssp == null) bussp.docDSSP();
        
        CTHDTKBUS buscthd = new  CTHDTKBUS();
        if (CTHDTKBUS.dsall == null) buscthd.docallCTHD();
         HoaDonTKBUS bushd= new  HoaDonTKBUS();
        if (HoaDonTKBUS.dshd == null) bushd.docDSHD();
        if(dstkhd == null)
        {
            dstkhd = new ArrayList<>();
        }
       for (SachDTO sp : SachTKBUS.dssp)
            {
                ThongKeHDDTO tkhd = new ThongKeHDDTO();
                tkhd.setMasach(sp.getMasach());
                tkhd.setTensach(sp.getTensach());
                tkhd.setTongthunhap(buscthd.ThunhapSP(sp.getMasach(),CTHDTKBUS.dsall,HoaDonTKBUS.dshd));
                tkhd.setTongluongban(buscthd.SoluongbanSP(sp.getMasach(),CTHDTKBUS.dsall));
                dstkhd.add(tkhd);
            }
    }
    public ArrayList <ThongKeHDDTO> Thongketop5 ()
    {
        ArrayList <ThongKeHDDTO> ds = dstkhd;
        Collections.sort(ds, (ThongKeHDDTO o1, ThongKeHDDTO o2) -> {
            if (o1.getTongthunhap() < o2.getTongthunhap()) {
                return 1;
            } else {
                if (o1.getTongthunhap() == o2.getTongthunhap()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        return ds;
        
    }
    
    public void docDSTKHDtheonam (String nam) throws ParseException
    {
        SachTKBUS bussp = new SachTKBUS();
        if (SachTKBUS.dssp == null) bussp.docDSSP();
        
        CTHDTKBUS buscthd = new  CTHDTKBUS();
 HoaDonTKBUS bushd= new  HoaDonTKBUS();
        if (HoaDonTKBUS.dshd == null) bushd.docDSHD();
        dstkhdtheonam = new ArrayList<>();
        for (SachDTO sp : SachTKBUS.dssp)
            {
                ThongKeHDDTO tkhd = new ThongKeHDDTO();
                tkhd.setMasach(sp.getMasach());
                tkhd.setTensach(sp.getTensach());
                tkhd.setTongthunhap(buscthd.ThunhapSP(sp.getMasach(),buscthd.theonam(nam),HoaDonTKBUS.dshd));
                tkhd.setTongluongban(buscthd.SoluongbanSP(sp.getMasach(),buscthd.theonam(nam)));
                dstkhdtheonam.add(tkhd);
            }
    }
    
    public void docDSTKHDtheothangnam (String thang,String nam) throws ParseException
    {
        SachTKBUS bussp = new SachTKBUS();
        if (SachTKBUS.dssp == null) bussp.docDSSP();
        HoaDonTKBUS bushd= new  HoaDonTKBUS();
        if (HoaDonTKBUS.dshd == null) bushd.docDSHD();
        CTHDTKBUS buscthd = new  CTHDTKBUS();
        ArrayList <CTHDDTO> duyet = buscthd.theothangnam(thang,nam);

        dstkhdtheothangnam = new ArrayList<>();
        for (SachDTO sp : SachTKBUS.dssp)
            {
                ThongKeHDDTO tkhd = new ThongKeHDDTO();
                tkhd.setMasach(sp.getMasach());
                tkhd.setTensach(sp.getTensach());
                tkhd.setTongthunhap(buscthd.ThunhapSP(sp.getMasach(),duyet,HoaDonTKBUS.dshd));
                tkhd.setTongluongban(buscthd.SoluongbanSP(sp.getMasach(),duyet));
                dstkhdtheothangnam.add(tkhd);
            }
        
    }
    
    public void docDSTKHDtheoquynam (String quy,String nam) throws ParseException
    {
        SachTKBUS bussp = new SachTKBUS();
        if (SachTKBUS.dssp == null) bussp.docDSSP();
         HoaDonTKBUS bushd= new  HoaDonTKBUS();
        if (HoaDonTKBUS.dshd == null) bushd.docDSHD();
        CTHDTKBUS buscthd = new  CTHDTKBUS();

        dstkhdtheoquynam = new ArrayList<>();
        for (SachDTO sp : SachTKBUS.dssp)
            {
                ThongKeHDDTO tkhd = new ThongKeHDDTO();
                tkhd.setMasach(sp.getMasach());
                tkhd.setTensach(sp.getTensach());
                tkhd.setTongthunhap(buscthd.ThunhapSP(sp.getMasach(),buscthd.theoquynam(quy,nam),HoaDonTKBUS.dshd));
                tkhd.setTongluongban(buscthd.SoluongbanSP(sp.getMasach(),buscthd.theoquynam(quy,nam)));
                dstkhdtheoquynam.add(tkhd);
            }
        
    }
}

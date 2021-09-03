/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SachDAO;
import DTO.SachDTO;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class SachBUS {

    public static ArrayList<SachDTO> dssp;

    public SachBUS() {
    }

    public void docDSSP() {
        SachDAO data = new SachDAO();
        if (dssp == null) {
            dssp = new ArrayList<SachDTO>();           
        }
        dssp = data.docdssach();
    }

    public boolean Them(SachDTO sp) {
        if(sp.getMasach().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Xin nhập mã SP");
            return false;
        }
        String regex = "^[0-9]{1,}$";
        if (sp.getMasach().matches(regex) == false) {
            JOptionPane.showMessageDialog(null,"Mã sách không hợp lệ");
            return false;
        }
        for (SachDTO x : dssp) {
            if (x.getMasach().equals(sp.getMasach())) {
                JOptionPane.showMessageDialog(null, "Mã sách bị trùng");
                return false;
            }
        }
        if(sp.getTensach().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Xin nhập tên sách");
            return false;
        }
        if(sp.getMaloai().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Xin chọn mã Loại");
            return false;
        }
        if(sp.getMancc().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Xin chọn mã NCC");
            return false;
        }
              
        if(sp.getManxb().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Xin chọn mã NXB");
            return false;
        }
        
        if(sp.getMatg().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Xin chọn mã Tác giả");
            return false;
        }
        
        
        
        
//        String sl = String.valueOf(sp.getSoluong());
//        //String pattern = "^[0-9]{1,}$";
//        if(sl.equals(""))
//        {
//            JOptionPane.showMessageDialog(null,"Xin nhập số lượng sách");
//            return false;
//        }
////        if(sl.matches(pattern)==false)
////        {
////            JOptionPane.showMessageDialog(null,"Chỉ được nhập số !!!");
////            return false;
////        }
//        
//        String gia = String.valueOf(sp.getDongia());
//        if(gia.equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "Xin nhập đơn giá sách");
//            return false;
//        }
                
             
        SachDAO data = new SachDAO();
        data.Them(sp);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        dssp.add(sp);
        return true;
    }
    public SachDTO getInfoRow(String Ma) {
        SachDTO sp = new SachDTO();
        docDSSP();
        for (SachDTO tempsp : SachBUS.dssp) {
            if (tempsp.getMasach().equals(Ma)) {
                sp = tempsp;
                break;
            }
        }
        return sp;
    }
    public boolean Xoa(String ma) {
        int index = -1;
        if ("".equals(ma)) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không được để trống");
            return false;
        } else {
            String pattern = "[0-9]{1,}$";
            if (!Pattern.matches(pattern, ma)) {
                JOptionPane.showMessageDialog(null, "Mã sản phẩm không hợp lệ");
                return false;
            } else {
                //docDSSP();
                boolean flag = false;
                for (SachDTO tempsp : SachBUS.dssp) {
                    if (tempsp.getMasach().equals(ma)) {
                        
                        flag = true;
                    }
                }
                if (flag == false) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm hành không tồn tại");
                    return false;
                }
            }
        }
        SachDAO data = new SachDAO();
        data.Xoa(ma);
        for (SachDTO tempsp : SachBUS.dssp)
        {
            index++;
            if (tempsp.getMasach().equals(ma)) {
                break;
            }
        }
//        System.out.println(sp.getMasp());
//        System.out.println("");
//        for(SanPhamDTO x : dssp)
//        {
//            System.out.println(x.getMasp());
//        }
        dssp.remove(index);
//        System.out.println("");
//        for(SanPhamDTO x : dssp)
//        {
//            System.out.println(x.getMasp());
//        }
//        System.out.println("");
        JOptionPane.showMessageDialog(null, "Xóa thành công");
        return true;
    }
    public boolean Sua(SachDTO sp)
    {
        
        int index = -1; 
        for(SachDTO tempsp : SachBUS.dssp)
        {
            index++;
            if((tempsp.getMasach()).equals(sp.getMasach()))
            {
//                System.out.println(tempsp.getMasp() +" ???? " +sp.getMasp());
                   System.out.println(index);
                break;
            }
        }
        //System.out.println(index);
        dssp.set(index, sp);
        SachDAO data = new SachDAO();
        data.Sua(sp);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
        return true;
    }
    public ArrayList Timkiemnangcao(int Giatu,int Giaden,int Soluongtu,int Soluongden)
    {
       ArrayList<SachDTO> dstk = new ArrayList<>();
       for (SachDTO x : dssp)
       {
           if ( (Giatu <= x.getDongia() && x.getDongia() <= Giaden) && (Soluongtu <= x.getSoluong() && x.getSoluong() <= Soluongden))
           {
               dstk.add(x);
           }
       }
       return dstk;
    }
    
    public SachDTO timSach(String masach)
    {
        for(SachDTO x : dssp)
        {
            if(x.getMasach().equals(masach))
            {
                return x;              
            }
        }
        return null;
    }
    
    /*rào
    public ArrayList DSloai()
    {
        ArrayList <String> chooseloai = new ArrayList<>();
        for (SachDTO x : dssp) {
            if(!chooseloai.contains(x.getHang()))
                chooseloai.add(x.getHang());
        }
        return chooseloai;
    }
    public ArrayList <SachDTO> Timkiemtheohang(String hang)
    {
        ArrayList <SachDTO> dshang = new ArrayList<>();
        for(SachDTO x : dssp)
        {
            if(hang.equals(x.getHang()))
                dshang.add(x);
        }
        return dshang;
    }
    
    kết thúc rào*/
//    public ArrayList Tim(String text,String type)
//    {
//        if ("".equals(text)) {
//            JOptionPane.showMessageDialog(null, "Điền thông tin muốn tìm");
//            return null;
//        } 
//        switch(type){
//            case "Theo Mã SP":type="MaSP";break;
//            case "Theo Tên SP":type="Ten";break;
//            case "Theo Hãng":type="Hang";break;
//            case "Theo Giá":type="Gia";break;
//            default : 
//        }
//        return null;
//        
//    }
    
    public String Sachtieptheo()
    {
        SachDAO sachdao = new SachDAO();
        int a = sachdao.demSach()+1;
        String nextid = String.valueOf(a);
        return nextid;
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangTKDAO;
import DAO.NhanVienTKDAO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class NhanVienTKBUS {

    public static ArrayList<NhanVienDTO> dsnv;
    private int row;

    public NhanVienTKBUS() {
    }

    public void readDSNV() {
        NhanVienTKDAO data = new NhanVienTKDAO();
        if (dsnv == null) {
            dsnv = new ArrayList<NhanVienDTO>();
        }
        dsnv = data.docdsnhanvien();
    }
     public void readDSNVTKe() {
        NhanVienTKDAO data = new NhanVienTKDAO();
        if (dsnv == null) {
            dsnv = new ArrayList<NhanVienDTO>();
        }
        dsnv = data.docdsnhanvientke();
    }
    public NhanVienDTO getInfoRow(String code) {
        NhanVienDTO nv = new NhanVienDTO();
        readDSNV();
        for (NhanVienDTO tempkh : NhanVienTKBUS.dsnv) {
            if (tempkh.getManv().equals(code)) {
                nv = tempkh;
                break;
            } 
        }
        return nv;
    }
    public boolean add(NhanVienDTO nv) {
       
        if ("".equals(nv.getManv())) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên không được để trống");
            return false;
        } else {
            //String makh=kh.getMakh().toString();
            //String pattern = "^[0-9]{2}$" ;
            String pattern = "^[0-9]{1,2}$" ;
 
            if(!Pattern.matches(pattern, nv.getManv()))
            {
                JOptionPane.showMessageDialog(null,"Mã nhân viên không hợp lệ");                
                return false;
            } else {
                readDSNV();
                for (NhanVienDTO tempkh : NhanVienTKBUS.dsnv)
                {
                    if(tempkh.getManv().equals(nv.getManv())){
                        JOptionPane.showMessageDialog(null,"Mã nhân viên bị trùng");
                        return false;
                    }
                }
            }
        }
        
        if("".equals(nv.getHonv()))
        {
            JOptionPane.showMessageDialog(null, "Họ nhân viên không được để trống");
            return false;
        }
        else
        {
           // String pattern ="^[\\d!@#$%^&*()\"{}<>~,+-_=?.\':;|]{1,}";
           String pattern= "^[^!@#$?<>.*:;,/\\-+=()\\d]{1,}$";
            if(!Pattern.matches(pattern,nv.getHonv()))
            {
                JOptionPane.showMessageDialog(null,"Họ không hợp lệ");
                
                return false;             
            }
//            else
//                JOptionPane.showMessageDialog(null,"Họ hợp lệ");
        }
        
        if ("".equals(nv.getTennv())) 
        {
            JOptionPane.showMessageDialog(null, "Xin nhập tên");
            return false;
        }
        else
        {
           // String pattern ="^[\\d!@#$%^&*()\"{}<>~,+-_=?.\':;|]{1,}";
           String pattern= "^[^!@#$?<>.*:;,/\\-+=()\\d]{1,}$";
            if(!Pattern.matches(pattern,nv.getTennv()))
            {
                JOptionPane.showMessageDialog(null,"Tên không hợp lệ");
                
                return false;             
            }
//            else
//                JOptionPane.showMessageDialog(null,"Họ hợp lệ");
        }
         if ("".equals(nv.getSdt())) 
        {
            JOptionPane.showMessageDialog(null, "Xin nhập SĐT");
            return false;
        }
            else 
            {
            //String pattern = "^[0-9]{10}$" ;
                String pattern ="\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})";
            if(!Pattern.matches(pattern, nv.getSdt()))
                {
                JOptionPane.showMessageDialog(null,"SĐT không hợp lệ");
                return false;
                 }
            }
            
        
        if ("".equals(nv.getDiachi())) {
            JOptionPane.showMessageDialog(null, "Xin nhập địa chỉ");
            return false;
        }
        else{
            String pattern= "^[^!@#$?<>*:;/\\-+=()]{10,}$";
            if(!Pattern.matches(pattern,nv.getDiachi()))
            {
                JOptionPane.showMessageDialog(null,"Địa chỉ không hợp lệ");               
                return false;             
            }
        }
        if ("".equals(nv.getLuong())) {
            JOptionPane.showMessageDialog(null, "Lương không được để trống");
            return false;
        } else {
            //String makh=kh.getMakh().toString();
            //String pattern = "^[0-9]{2}$" ;
            String pattern = "^[0-9]{1,9}$" ;
 
            if(!Pattern.matches(pattern, nv.getLuong()))
            {
                JOptionPane.showMessageDialog(null,"Lương  không hợp lệ");
                
                return false;
            
            }
        }
        
        NhanVienTKDAO data = new NhanVienTKDAO();
        data.add(nv);
        data.docdsnhanvien();
        JOptionPane.showMessageDialog(null,"Thêm thành công");     
        return true;
    }

    public boolean delete(String ma) {
        int index = -1;
        if ("".equals(ma)) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên không được để trống");
            return false;
        } else {
            String pattern = "^[0-9]{1,2}$";
            if (!Pattern.matches(pattern, ma)) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên không hợp lệ");
                return false;
            } else {
                readDSNV();
                boolean flag = false;
                for (NhanVienDTO tempnv : NhanVienTKBUS.dsnv) {
                    index++;
                    if (tempnv.getManv().equals(ma)) {
                        flag = true;
                        break;//check tồn tại khách hàng
                    }
                }
                if (flag == false) {
                    JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại");
                    return false;
                }
            }
        }
        NhanVienTKDAO data = new NhanVienTKDAO();
        data.delete(ma);
        dsnv.remove(index);
        JOptionPane.showMessageDialog(null,"Xoá thành công");
        return true;
    }

    public boolean update(NhanVienDTO nv) {
//        if ("".equals(kh.getMakh())) {
//            JOptionPane.showMessageDialog(null, "");
//            return false;
//        }
//        else {
//            String pattern = "^[0-9]{1,2}$" ;
//            if(!Pattern.matches(pattern, kh.getMakh())){
//                JOptionPane.showMessageDialog(null,"Mã khách hàng không hợp lệ");
//                return false;
//            } else {
//                readDSKH();
//                 for (KhachHangDTO tempkh : NhanVienBUS.dskh)
//                {
//                    if(tempkh.getMakh().equals(kh.getMakh())){
//                        JOptionPane.showMessageDialog(null,"Mã khách hàng hành bị trùng");
//                        return false;
//                    }
//                }
//            }
//        }
        if ("".equals(nv.getHonv())) {
            JOptionPane.showMessageDialog(null, "Xin nhập họ");
            return false;
        }
        else{
             String pattern= "^[^!@#$?<>.*:;,/\\-+=()\\d]{1,}$";
            if(!Pattern.matches(pattern,nv.getHonv()))
            {
                JOptionPane.showMessageDialog(null,"Họ không hợp lệ");
                
                return false;             
            }
        }
        
        if ("".equals(nv.getTennv())) {
            JOptionPane.showMessageDialog(null, "Xin nhập tên");
            return false;
        }
        else{
            String pattern= "^[^!@#$?<>.*:;,/\\-+=()\\d]{1,}$";
            if(!Pattern.matches(pattern,nv.getTennv()))
            {
                JOptionPane.showMessageDialog(null,"Tên không hợp lệ");
                
                return false;             
            }
        }
        if ("".equals(nv.getSdt())) {
            JOptionPane.showMessageDialog(null, "Xin nhập SĐT");
            return false;
        }else{
         String pattern ="\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})";
            if(!Pattern.matches(pattern, nv.getSdt()))
                {
                JOptionPane.showMessageDialog(null,"SĐT không hợp lệ");
                return false;
                 }
        }
        if ("".equals(nv.getDiachi())) {
            JOptionPane.showMessageDialog(null, "Xin nhập địa chỉ");
            return false;
        }else{
             String pattern= "^[^!@#$?<>*:;/\\-+=()]{15,}$";
            if(!Pattern.matches(pattern,nv.getDiachi()))
            {
                JOptionPane.showMessageDialog(null,"Địa chỉ không hợp lệ");               
                return false;             
            }
        }
       if ("".equals(nv.getLuong())) {
            JOptionPane.showMessageDialog(null, "Xin nhập lương");
            return false;
        }else {
            //String makh=kh.getMakh().toString();
            //String pattern = "^[0-9]{2}$" ;
            
            String pattern = "^[0-9]{1,9}$" ;
 
            if(!Pattern.matches(pattern, nv.getLuong()))
            {
                JOptionPane.showMessageDialog(null,"Lương  không hợp lệ");
                
                return false;
            
            }
        }
       
       
        int index = -1;
        for (NhanVienDTO x : dsnv)
        {
            index++;
             if(x.getManv().equals(nv.getManv()))
                 break;
        }
        NhanVienTKDAO data = new NhanVienTKDAO();
        data.update(nv);
        dsnv.set(index,nv);
        JOptionPane.showMessageDialog(null,"Sửa thành công");
        return true;
    }
    
      public String Timtennv(String ma)
    {
        for (NhanVienDTO nv : dsnv)
            if(nv.getManv().equals(ma))
                return nv.getHonv()+ " " + nv.getTennv();
        return " ";
    }
//    public ArrayList FindAD(int TuoiTu,int TuoiDen){
//        ArrayList<KhachHangDTO> dstk = new ArrayList<>();
//        try{
//            int tu,den;
//            if("Tuổi từ...".equals(TuoiTu)){
//                tu=1;
//            }
//            else{
//                tu=TuoiTu;
//            }
//            
//            if("Tuổi đến...".equals(TuoiDen)){
//                den=99;
//            }
//            else{
//                den=TuoiDen;
//            }
//            
//            for(KhachHangDTO x:dskh){
//                Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(x.getNgaysinh());
//                Date now=new Date();
//                SimpleDateFormat sdf =new SimpleDateFormat("yyyy");
//                String year1=sdf.format(date1);
//                String yearnow=sdf.format(now);
//                int Tuoi=Integer.parseInt(yearnow)-Integer.parseInt(year1);
//                if(Tuoi>=TuoiTu && Tuoi<=TuoiDen){
//                    dstk.add(x);
//                }
//            }
//        }catch(ParseException ex){
//            java.util.logging.Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE,null,ex);
//        }
//        return dstk;
      //}
    
}

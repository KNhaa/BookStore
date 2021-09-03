/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

//import static BUS.TaiKhoanBUS.dstaikhoan;
import DAO.TaiKhoanDAO;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class TaiKhoanBUS {

    public static ArrayList<TaiKhoanDTO> dstk;
    public static ArrayList<TaiKhoanDTO> dstkchuasai;

    public TaiKhoanBUS() {
    }

    public void docDSTaiKhoan() {
        TaiKhoanDAO data = new TaiKhoanDAO();
        if (dstk == null) {
            dstk = new ArrayList<TaiKhoanDTO>();
        }
        dstk = data.docdstaikhoan();
    }
    
    

    public void docDSTaiKhoanChuaXai() {
        TaiKhoanDAO data = new TaiKhoanDAO();
        if (dstkchuasai == null) {
            dstkchuasai = new ArrayList<TaiKhoanDTO>();
        }
        dstkchuasai = data.docdstaikhoanchuaxai();
    }

    public boolean Them(TaiKhoanDTO tk) {
        docDSTaiKhoan();
        for (TaiKhoanDTO temptk : TaiKhoanBUS.dstk) 
        {
            if (temptk.getTentaikhoan().equals(tk.getTentaikhoan())) 
            {
                JOptionPane.showMessageDialog(null, "Tên tài khoản bị trùng!");
                return false;
            }
        }  
        
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.Them(tk);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        return true;
            
    }

    

    public boolean Xoa(TaiKhoanDTO tk) {
        int index = -1;
        for (TaiKhoanDTO dstk1 : dstk) {
            index++;
            if (tk.getTentaikhoan().equals(dstk1.getTentaikhoan())) {
                break;
            }
        }
        dstk.remove(index);
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.Xoa(tk.getTentaikhoan());
        //JOptionPane.showMessageDialog(null,"Thêm thành công");
        return true;
    }

    public boolean Sua(TaiKhoanDTO tk) {
        int index = -1;
        for (TaiKhoanDTO dstk1 : dstk) {
            index++;
            if (tk.getTentaikhoan().equals(dstk1.getTentaikhoan())) {
                break;
            }
        }
        dstk.set(index, tk);
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.Sua(tk);
        JOptionPane.showMessageDialog(null, "Đã thành công");
        return true;
    }

    public boolean SuaTrangThai(String tk) {
        int index = -1;
        TaiKhoanDTO temp = new TaiKhoanDTO();
        //for (TaiKhoanDTO dstk1 : dstk) {
        for (TaiKhoanDTO dstk1 : dstkchuasai) {
            index++;
            if (tk.equals(dstk1.getTentaikhoan())) { //dstk1.setTrangthai(1);
                temp = dstk1;
                break;
            }
        }
        //dstk.set(index, temp);
        dstkchuasai.set(index, temp);
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.SuaTrangThai(temp.getTentaikhoan());
        JOptionPane.showMessageDialog(null, "Đã thành công");
        return true;
    }

    public TaiKhoanDTO Tim(String tentk) {
        for (TaiKhoanDTO tk : dstk) {
            if (tk.getTentaikhoan().equals(tentk)) {
                return tk;
            }
        }
        return null;
    }

    public boolean TimMK(String matkhau) {
        for (TaiKhoanDTO user : dstk) {
            if (user.getTentaikhoan().equals(matkhau)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Mật khẩu bị sai");
        return false;
    }

    public TaiKhoanDTO getInfoRow(String code) {
        TaiKhoanDTO tk = new TaiKhoanDTO();
        docDSTaiKhoan();
        for (TaiKhoanDTO temptk : TaiKhoanBUS.dstk) {
            if (temptk.getTentaikhoan().equals(code)) {
                tk = temptk;
                break;
            }
        }
        return tk;
    }

    public String returnMK(String tentk) {
        for (TaiKhoanDTO tk : dstk) {
            if (tk.getTentaikhoan().equals(tentk)) {
                return tk.getMatkhau();
            }
        }
        return null;
    }

    public String returnVT(String tentk) {
        for (TaiKhoanDTO tk : dstk) {
            if (tk.getTentaikhoan().equals(tentk)) {
                return tk.getVaitro();
            }
        }
        return null;
    }

    public boolean resetpass(TaiKhoanDTO tk) {
        NhanVienBUS busnv = new NhanVienBUS();
        if (NhanVienBUS.dsnv == null) {
            busnv.readDSNV();
        }
        for (NhanVienDTO nv : NhanVienBUS.dsnv) {
            if (tk.getTentaikhoan().equals(nv.getTentk())) {
                tk.setTentaikhoan(nv.getTentk());
//                tk.setMatkhau(nv.get.replace("-", ""));

                tk.setTrangthai(1);
                tk.setVaitro("user");
                Sua(tk);
                return true;
            }
        }
        return false;

    }

    public String timTaiKhoanVT(String ten, String password) // tìm tài khoản, nếu có trả về Vaitro, nếu không trả về null
    {
        docDSTaiKhoan();
        for (TaiKhoanDTO tk : dstk) {
            if (tk.getTentaikhoan().equals(ten) && tk.getMatkhau().equals(password)) {
                return tk.getVaitro();
            }
        }
        return null;
    }
    
    public TaiKhoanDTO timTaikhoan(String ten, String password) // tìm tài khoản
    {
        for (TaiKhoanDTO tk : dstk) {
            if (tk.getTentaikhoan().equals(ten) && tk.getMatkhau().equals(password)) {
                //return tk.getVaitro();
                return tk;
            }
        }
        return null;
    }
}

//public class TaiKhoanBUS {
//    public static ArrayList<TaiKhoanDTO> dstaikhoan;
//    public TaiKhoanBUS()
//    {
//        
//    }
//    
//    public void docDSTK()
//    {
//        TaiKhoanDAO tkdao = new TaiKhoanDAO();
//        if(dstaikhoan == null)
//        {
//            dstaikhoan = new ArrayList<TaiKhoanDTO>();
//        }
//        dstaikhoan = tkdao.docdstaikhoan();
//    }
//    
//    public String timTaiKhoan(String ten, String password) // tìm tài khoản, nếu có trả về Vaitro, nếu không trả về null
//    {       
//        for(TaiKhoanDTO tk : dstaikhoan)
//        {
//            if(tk.getTentaikhoan().equals(ten) && tk.getMatkhau().equals(password))
//                return tk.getVaitro();
//        }
//        return null;       
//    }   
//    
//}

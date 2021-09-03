/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TacGiaDAO;
import DTO.NCCDTO;
import DTO.TacGiaDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class TacGiaBUS {
    public static ArrayList<TacGiaDTO> dstacgia;

    public TacGiaBUS() {
    }

    public void docdstacgia() {
        TacGiaDAO data = new TacGiaDAO();
        if (dstacgia == null) {
            dstacgia = new ArrayList<TacGiaDTO>();         
        }
        dstacgia = data.docdstacgia();
    }
    
    public boolean Them(TacGiaDTO tacgia)
    {
        if(tacgia.getMatg().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Mã tác giả không được để trống");
            return false;
        }
        else
        {
            String pattern ="^[0-9]{1,}$";
            if(tacgia.getMatg().matches(pattern)==false)
            {
                JOptionPane.showMessageDialog(null, "Mã tác giả không hợp lệ");
                return false;
            }
            else
            {
                docdstacgia();
                for(TacGiaDTO temp : TacGiaBUS.dstacgia)
                {
                    if(tacgia.getMatg().equals(temp.getMatg()))
                    {
                        JOptionPane.showMessageDialog(null, "Mã tác giả bị trùng");
                        return false;
                    }
                }
                
            }
        }
        
        if(tacgia.getTentg().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Tên tác giả không được để trống");
            return false;
        }
        else
        {
            String pattern ="^[^!@#$?<>.*:;,/\\-+=()]{1,}$";
            if(tacgia.getTentg().matches(pattern)==false)
            {
                JOptionPane.showMessageDialog(null,"Tên tác giả không hợp lệ");
                return false;
            }
        }
        
        TacGiaDAO data = new TacGiaDAO();
        data.Them(tacgia);
        data.docdstacgia();
        JOptionPane.showMessageDialog(null, "Thêm tác giả thành công");
        return true;
    }
    
     public boolean Xoa(String ma) {
        int index = -1;
        if ("".equals(ma)) 
        {
            JOptionPane.showMessageDialog(null, "Mã tác giả không được để trống");
            return false;
        } 
        else 
        {
                docdstacgia();
                boolean flag = false;
                for (TacGiaDTO temptg : TacGiaBUS.dstacgia) 
                {
                    index++;
                    if (temptg.getMatg().equals(ma)) 
                    {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    //JOptionPane.showMessageDialog(null, "Mã khách hàng không tồn tại");
                    return false;
                }
        }
        
        TacGiaDAO data = new TacGiaDAO();
        data.Xoa(ma);
        dstacgia.remove(index);
        JOptionPane.showMessageDialog(null,"Xoá thành công");
        return true;
    }
     
     public boolean Sua(TacGiaDTO tacgia)
     {
         if ("".equals(tacgia.getMatg())) 
         {
            JOptionPane.showMessageDialog(null, "Mã tác giả không được để trống");
            return false;
         }
        if ("".equals(tacgia.getTentg())) {
            JOptionPane.showMessageDialog(null, "Tên tác giả không được để trống");
            return false;
        }
             
        int index = -1;
        for (TacGiaDTO temp : dstacgia)
        {
            index++;
             if(temp.getMatg().equals(tacgia.getMatg()))
                 break;
        }
        TacGiaDAO data = new TacGiaDAO();
        data.Sua(tacgia);
        dstacgia.set(index,tacgia);
        JOptionPane.showMessageDialog(null,"Sửa thành công");
        return true;
     }
     
     public TacGiaDTO getInfoRow(String code) {
        TacGiaDTO KH = new TacGiaDTO();
        docdstacgia();
        for (TacGiaDTO tempkh : TacGiaBUS.dstacgia) {
            if (tempkh.getMatg().equals(code)) {
                KH = tempkh;
                break;
            } 
        }
        return KH;
    }
      public String TGtieptheo()
    {
        TacGiaDAO pndao = new TacGiaDAO();
        int a = pndao.demTacGia()+1;       
        String nextid = String.valueOf(a);
        return nextid;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class NhanVienTKDAO {
     public ArrayList docdsnhanvien ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <NhanVienDTO> dsnhanvien= new ArrayList <NhanVienDTO> (); 
          try
          {
              String qry = "select * from nhanvien where trangthai= 1";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  NhanVienDTO nhanvien = new NhanVienDTO();
                  nhanvien.setManv(ConnectData.rs.getString(1));
                  nhanvien.setHonv(ConnectData.rs.getString(2));
                  nhanvien.setTennv(ConnectData.rs.getString(3));
                  nhanvien.setSdt(ConnectData.rs.getString(4));
                    
                    nhanvien.setDiachi(ConnectData.rs.getString(5));
                    nhanvien.setLuong(ConnectData.rs.getString(6));
                    nhanvien.setTentk(ConnectData.rs.getString(7));
                  dsnhanvien.add(nhanvien);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsnhanvien;
    }
      public ArrayList docdsnhanvientke ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <NhanVienDTO> dsnhanvien= new ArrayList <NhanVienDTO> (); 
          try
          {
              String qry = "select * from nhanvien ";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  NhanVienDTO nhanvien = new NhanVienDTO();
                  nhanvien.setManv(ConnectData.rs.getString(1));
                  nhanvien.setHonv(ConnectData.rs.getString(2));
                  nhanvien.setTennv(ConnectData.rs.getString(3));
                  nhanvien.setSdt(ConnectData.rs.getString(4));
                    
                    nhanvien.setDiachi(ConnectData.rs.getString(5));
                    nhanvien.setLuong(ConnectData.rs.getString(6));
                    nhanvien.setTentk(ConnectData.rs.getString(7));
                  dsnhanvien.add(nhanvien);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsnhanvien;
    }
     public void add(NhanVienDTO nv){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Insert into nhanvien value (";
            qry+="'"+nv.getManv()+"'";
            qry+=","+"'"+nv.getHonv()+"'";
            qry+=","+"'"+nv.getTennv()+"'";
            qry+=","+"'"+nv.getHonv()+"'";
            qry+=","+"'"+nv.getDiachi()+"'";
            qry+=","+"'"+nv.getLuong()+"'";
            qry+=","+"'"+nv.getTentk()+"'";
            qry+=","+1;
            qry+=")";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
    
    public void delete(String ma){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Update nhanvien set ";
            qry+="trangthai=0";
            qry+=" "+"where manv= '"+ma+"'";
            connect.st = (Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
     public void update(NhanVienDTO nv){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Update nhanvien set ";
            qry+= "honv="+"'"+nv.getHonv()+"'";
            qry+=",tennv="+"'"+nv.getTennv()+"'";
            qry+=",sdt="+"'"+nv.getSdt()+"'";
            qry+=",diachi="+"'"+nv.getDiachi()+"'";
             qry+=",luong="+"'"+nv.getLuong()+"'";
            qry+=" "+"where manv= '"+nv.getManv()+"'";
            connect.st = (Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
}

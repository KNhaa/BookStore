/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class KhachHangDAO {
    public ArrayList docdskhachhang()
    {
        
    MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <KhachHangDTO> dskhachhang = new ArrayList <KhachHangDTO> (); 
          try
          {
              String qry = "select * from khachhang where trangthai=1";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  KhachHangDTO khachhang = new KhachHangDTO();
                  khachhang.setMakh(ConnectData.rs.getString(1));
                  khachhang.setHokh(ConnectData.rs.getString(2));
                  khachhang.setTenkh(ConnectData.rs.getString(3));
                  khachhang.setSdt(ConnectData.rs.getString(4));
                   khachhang.setDiachi(ConnectData.rs.getString(5));
                  
                  dskhachhang.add(khachhang);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dskhachhang;
}
    
    public void add(KhachHangDTO kh){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Insert into khachhang value (";
            qry+="'"+kh.getMakh()+"'";
            qry+=","+"'"+kh.getHokh()+"'";
            qry+=","+"'"+kh.getTenkh()+"'";
            qry+=","+"'"+kh.getSdt()+"'";
            qry+=","+"'"+kh.getDiachi()+"'";
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
            String qry = "Update khachhang set ";
            qry+="trangthai=0";
            qry+=" "+"where makh= '"+ma+"'";
            connect.st = (Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
     public void update(KhachHangDTO kh){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Update khachhang set ";
            qry+= "hokh="+"'"+kh.getHokh()+"'";
            qry+=",tenkh="+"'"+kh.getTenkh()+"'";
            qry+=",sdt="+"'"+kh.getSdt()+"'";
            qry+=",diachi="+"'"+kh.getDiachi()+"'";
            qry+=" "+"where makh= '"+kh.getMakh()+"'";
            connect.st = (Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
     
     public int demKH()
    {
        
         try {
             int count=0;
             MySQLConnect connect = new MySQLConnect();
             String qry="select count(makh) from khachhang";
             connect.st = connect.conn.createStatement();
             connect.rs = connect.st.executeQuery(qry);
             while(connect.rs.next())
             {
                 count = connect.rs.getInt(1);
             }
             return count;              
         } catch (SQLException ex) {
             Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0;
        
    }
}

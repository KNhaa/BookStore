/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTNhapDTO;
import DTO.SachDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class SachDAO {
    public ArrayList docdssach ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <SachDTO> dssach = new ArrayList <SachDTO> (); 
          try
          {
              String qry = "select * from sach where trangthai=1";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  SachDTO sach = new SachDTO();
                  sach.setMasach(ConnectData.rs.getString(1));
                  sach.setTensach(ConnectData.rs.getString(2));
                  sach.setSoluong(ConnectData.rs.getInt(3));
                  sach.setDongia(ConnectData.rs.getInt(4));
                  sach.setMatg(ConnectData.rs.getString(5));
                  sach.setMaloai(ConnectData.rs.getString(6));
                  sach.setManxb(ConnectData.rs.getString(7));
                  sach.setMancc(ConnectData.rs.getString(8));
                  sach.setTrangthai(ConnectData.rs.getInt(9));
                  
                  dssach.add(sach);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dssach;
    }
    
    public void Them(SachDTO sach)
    {
        MySQLConnect connect = new MySQLConnect();
        try {          
            String qry = "insert into sach value(";
            qry += Integer.parseInt(sach.getMasach()) +",'";
            qry += sach.getTensach() +"',";
            qry += sach.getSoluong() +",";
            qry += sach.getDongia() +",";
            qry += Integer.parseInt(sach.getMatg()) +",";
            qry += Integer.parseInt(sach.getMaloai()) +",";
            qry += Integer.parseInt(sach.getManxb()) +",";
            qry += Integer.parseInt(sach.getMancc()) +",";
            qry += "1)";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }       
    }
    
    public void Xoa(String ma)
    {
        try {
            MySQLConnect connect = new MySQLConnect();
            String qry = "UPDATE sach SET trangthai=0";
            qry +="  WHERE masach ="+Integer.parseInt(ma);
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void Sua(SachDTO sach)
    {
        try {
            MySQLConnect connect = new MySQLConnect();
            String qry = "UPDATE sach SET ";
            qry += "tensach= '"+sach.getTensach()+"',";
            qry += "soluong="+sach.getSoluong()+",";
            qry += "dongia="+sach.getDongia()+",";
            qry += "matg="+Integer.parseInt(sach.getMatg())+",";
            qry +="maloai="+Integer.parseInt(sach.getMaloai())+",";
            qry +="manxb="+Integer.parseInt(sach.getManxb())+",";
            qry +="mancc="+Integer.parseInt(sach.getMancc());
            qry +=" WHERE masach="+Integer.parseInt(sach.getMasach());
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }
    
    public void TangSoluong(String masach, int soluongmoi) //cập nhật số lượng sách lúc nhập hàng/bán hàng
    {        
        try {
            MySQLConnect connect = new MySQLConnect();
            String qry = "UPDATE sach SET ";
            qry += " soluong ="+soluongmoi;
            qry +=" WHERE masach="+Integer.parseInt(masach);
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }    
    
    public int getQuanity(String masach)//lấy số lượng sách
    {
        int quanity=0;
        try {
            MySQLConnect connect = new MySQLConnect();
            String qry = "select  soluong from sach ";
            qry +=" where trangthai=1 and masach="+Integer.parseInt(masach);
            connect.st = connect.conn.createStatement();
            connect.rs= connect.st.executeQuery(qry);
            
            while(connect.rs.next())
            {
                quanity = connect.rs.getInt(1);
            }
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return quanity;
        
    }
    
    public int demSach()
    {
        
         try {
             int count=0;
             MySQLConnect connect = new MySQLConnect();
             String qry="select count(masach) from sach";
             connect.st = connect.conn.createStatement();
             connect.rs = connect.st.executeQuery(qry);
             while(connect.rs.next())
             {
                 count = connect.rs.getInt(1);
             }
             return count;              
         } catch (SQLException ex) {
             Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0;
        
    }
}

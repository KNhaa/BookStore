/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhapDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class PhieuNhapDAO {
     public ArrayList docdsphieunhap()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <PhieuNhapDTO> dsphieunhap= new ArrayList <PhieuNhapDTO> (); 
          try
          {
              String qry = "select * from phieunhap where trangthai=1";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);             
             while(ConnectData.rs.next())
              {
                  PhieuNhapDTO phieunhap = new PhieuNhapDTO();
                  phieunhap.setManhap(ConnectData.rs.getString(1));
                  phieunhap.setNgaynhap(ConnectData.rs.getString(2));
                  phieunhap.setTongtien(ConnectData.rs.getInt(3));
                  phieunhap.setManv(ConnectData.rs.getString(4));
                  phieunhap.setMancc(ConnectData.rs.getString(5));
                  dsphieunhap.add(phieunhap);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsphieunhap;
    }
     
     public void Them (PhieuNhapDTO pn)
     {
         MySQLConnect connect = new MySQLConnect();
          try {
            String qry = "Insert into phieunhap value (";
            qry += Integer.parseInt(pn.getManhap()) + ",'";
            qry += pn.getNgaynhap()+"',";
            qry += pn.getTongtien() +",";
            qry += Integer.parseInt(pn.getManv()) + ",";
            qry += Integer.parseInt(pn.getMancc()) + ",";
            qry += "1)";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
     }
     
     public void Sua(PhieuNhapDTO pn) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "UPDATE phieunhap SET";
            //qry += " manhap = " + Integer.parseInt(pn.getManhap()) + ",";
            qry +=" ngaynhap = '"+ pn.getNgaynhap() +"',";
            qry += "tongtien = " + pn.getTongtien() + ",";
            qry += "manv = " + Integer.parseInt(pn.getManv()) + ",";
            qry += "mancc = " + Integer.parseInt(pn.getMancc()) +" ";
            qry += "WHERE manhap = " +Integer.parseInt(pn.getManhap())+"";
            
            System.out.println(qry);
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
     
     
     public void Xoa(String ma) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "UPDATE phieunhap SET  trangthai=0 where manhap = '" + ma + "'";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            CTNhapDAO data = new CTNhapDAO();
            data.Xoaall(ma);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
     
    public int demPN()
    {
        
         try {
             int count=0;
             MySQLConnect connect = new MySQLConnect();
             String qry="select count(manhap) from phieunhap";
             connect.st = connect.conn.createStatement();
             connect.rs = connect.st.executeQuery(qry);
             while(connect.rs.next())
             {
                 count = connect.rs.getInt(1);
             }
             return count;              
         } catch (SQLException ex) {
             Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0;
        
    }

}

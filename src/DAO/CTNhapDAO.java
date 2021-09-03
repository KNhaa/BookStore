/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTNhapDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class CTNhapDAO {
    
     public ArrayList docDSHDtheoHD(String manhap) {
        MySQLConnect connect = new MySQLConnect();
        ArrayList <CTNhapDTO> dsctnhap= new ArrayList <CTNhapDTO> (); 
        try {
            String qry = "SELECT * FROM ctnhap WHERE manhap = " + Integer.parseInt(manhap) + " and trangthai=1";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.rs = connect.st.executeQuery(qry);
            while (connect.rs.next()) {
                CTNhapDTO ctpn = new CTNhapDTO();
                //ctpn.setMasach(String.valueOf(connect.rs.getInt(1)));
                ctpn.setMasach(connect.rs.getString(1));
                ctpn.setManhap(connect.rs.getString(2));              
                ctpn.setSoluong(connect.rs.getInt(3));
                ctpn.setGianhap(connect.rs.getInt(4));
                ctpn.setThanhtien(connect.rs.getInt(5));
                ctpn.setTrangthai(connect.rs.getInt(6));
                dsctnhap.add(ctpn);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dsctnhap;
    }
    
     public void Them(CTNhapDTO ctpn) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "Insert into ctnhap value (";
            qry += ctpn.getMasach()+ ",";
            qry += ctpn.getManhap()+ ",";
            qry += ctpn.getSoluong() + ",";
            qry += ctpn.getGianhap()+ ",";
            qry += ctpn.getThanhtien()+ ",";
            qry += " 1)";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
     
     public void Sua(CTNhapDTO ctpn) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "UPDATE ctnhap SET";
            qry += " soluong ="+ctpn.getSoluong()+", gianhap="+ctpn.getGianhap() ;
            qry += " thanhtien ="+ctpn.getThanhtien();
            qry += " WHERE masach =" + Integer.parseInt(ctpn.getMasach())+" and manhap ="+ Integer.parseInt(ctpn.getManhap())+ "'";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            //JOptionPane.showMessageDialog(null, qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
     public void Xoa(CTNhapDTO ctpn) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "Update ctnhap set trangthai=0 ";
            qry +=" where masach = "+ Integer.parseInt(ctpn.getMasach())+ " and manhap ="+ Integer.parseInt(ctpn.getManhap());
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
     
    public void Xoaall(String manhap) 
    {
        MySQLConnect connect = new MySQLConnect();
        try 
        {
            String qry ="Update ctnhap set trangthai = 0 where manhap = "+Integer.parseInt(manhap);        
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}

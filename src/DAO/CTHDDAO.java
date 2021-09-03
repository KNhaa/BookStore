/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTHDDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class CTHDDAO {
     public ArrayList docDSHDtheoHD(String mahd) {
        MySQLConnect connect = new MySQLConnect();
        ArrayList<CTHDDTO> dscthd = new ArrayList<CTHDDTO>();
        try {
            String qry = "Select * from ct_hd where mahd = '" + mahd + "' and trangthai=1";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.rs = connect.st.executeQuery(qry);
            while (connect.rs.next()) {
                CTHDDTO cthd = new CTHDDTO();
                cthd.setMahd(connect.rs.getString(1));
                cthd.setMasach(connect.rs.getString(2));
                cthd.setSoluong(connect.rs.getInt(3));
                cthd.setThanhtien(connect.rs.getInt(4));
                cthd.setTienkm(connect.rs.getInt(5));
                dscthd.add(cthd);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dscthd;
    }
      public ArrayList docallCTHD ()
    {
       MySQLConnect connect = new MySQLConnect();
        ArrayList<CTHDDTO> dsall = new ArrayList<CTHDDTO>();
        try {
            String qry = "Select * from ct_hd where trangthai=1";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.rs = connect.st.executeQuery(qry);
            while (connect.rs.next()) {
                CTHDDTO cthd = new CTHDDTO();
                cthd.setMahd(connect.rs.getString(1));
                cthd.setMasach(connect.rs.getString(2));
                cthd.setSoluong(connect.rs.getInt(3));
                cthd.setThanhtien(connect.rs.getInt(4));
                cthd.setTienkm(connect.rs.getInt(5));
                dsall.add(cthd);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dsall;
    }

    public void Them(CTHDDTO cthd) {
        MySQLConnect connect = new MySQLConnect();
        try {
            //cthd.getThanhtien()*cthd.getSoluong();
            String qry = "Insert into ct_hd value ('";
            qry += cthd.getMahd() + "','";
            qry += cthd.getMasach()+ "','";
            qry += cthd.getSoluong()+ "',";
            qry += cthd.getThanhtien()*cthd.getSoluong()+ ",";
            qry += cthd.getTienkm()+ "," +1+ ")";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void Xoa(CTHDDTO cthd) {
        MySQLConnect connect = new MySQLConnect();
        try {
            //String qry = "Delete from ct_hd where masach = '" + cthd.getMasach()+ "' and mahd = '" + cthd.getMahd() + "'";
            String qry="Update ct_hd set trangthai=0 ";
            qry+="where mahd='"+cthd.getMahd()+"' and masach='"+cthd.getMasach()+"'";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void Xoaall(String ma) {
        MySQLConnect connect = new MySQLConnect();
        try {
            //String qry = "Delete from ct_hd where mahd = '" + ma + "'";
            String qry="Update ct_hd set trangthai=0 ";
            qry+="where mahd='"+ma+"'";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void Sua(CTHDDTO cthd) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "Update ct_hd set";
            qry += " soluong = '" + cthd.getSoluong()+ "'";
            qry += " where masach = '" + cthd.getMasach()+ "' and mahd = '" + cthd.getMahd()+ "'";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
            //JOptionPane.showMessageDialog(null, qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}

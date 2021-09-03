/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class HoaDonDAO {
     public ArrayList docdshoadon()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <HoaDonDTO> dshoadon= new ArrayList <HoaDonDTO> (); 
          try
          {
              String qry = "select * from hoadon where trangthai=1";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);             
             while(ConnectData.rs.next())
              {
                  HoaDonDTO hoadon = new HoaDonDTO();
                  hoadon.setMahd(ConnectData.rs.getString(1));
                  hoadon.setNgaylaphd(ConnectData.rs.getString(2));
                  hoadon.setTongtien(ConnectData.rs.getInt(3));
                  hoadon.setTienkm(ConnectData.rs.getInt(4));
                 hoadon.setThuctra(ConnectData.rs.getInt(5));
                  hoadon.setMakm(ConnectData.rs.getString(6));
                  hoadon.setManv(ConnectData.rs.getString(7));
                  hoadon.setMakh(ConnectData.rs.getString(8));
                  dshoadon.add(hoadon);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dshoadon;
    }
     public void Them(HoaDonDTO hd) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "Insert into hoadon value ('";
            qry += hd.getMahd() + "','";
            qry += hd.getNgaylaphd()+ "',";
            qry += hd.getTongtien()+ ",";
            qry += hd.getTienkm()+ ",";
            qry += hd.getThuctra()+ ",'";     
            qry += hd.getMakm()+ "','";
            qry += hd.getManv()+ "','";
            qry += hd.getMakh()+ "'";
            qry+=","+1;
            qry+=")";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        //them
        connect.MySQLDisconnect();
    }

    public void Xoa(String ma) {
        MySQLConnect connect = new MySQLConnect();
        try {
            //String qry = "Delete from hoadon where mahd = '" + ma + "'";
            String qry="Update hoadon set trangthai=0  ";
            qry+="where mahd= '"+ma+"'";
            
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);

            CTHDDAO data = new CTHDDAO();
            data.Xoaall(ma);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void Sua(HoaDonDTO hd) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "Update hoadon set";
            qry += " mahd = '" + hd.getMahd()+ "',";
            qry += "ngaylap = '" + hd.getNgaylaphd()+ "',";
            qry += "tongtien = '" + hd.getTongtien()+ "',";
            qry += "tienkm = '" + hd.getTienkm()+ "',";
            qry += "thuctra = " + hd.getThuctra()+ ",";
            qry += "makm = " + hd.getMakm()+ ",";
            qry += "manv = " + hd.getManv()+ ",";
            qry += "makh = " + hd.getMakh()+ " ";
            qry += "where mahd = '" + hd.getMahd() + "'";
            System.out.println(qry);
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public int demhd()
    {
       
        try{
            int dem=0;
            String qry="select count(mahd) from hoadon";
             MySQLConnect connect = new MySQLConnect(); 
            connect.st = connect.conn.createStatement();
            connect.rs=connect.st.executeQuery(qry);
            while(connect.rs.next())
            {
                dem= connect.rs.getInt(1);
            }
            return dem;
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
         return 0;
    }
}

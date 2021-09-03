/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TaiKhoanDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class TaiKhoanDAO {
     public ArrayList docdstaikhoan ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <TaiKhoanDTO> dstaikhoan= new ArrayList <TaiKhoanDTO> (); 
          try
          {
              String qry = "select * from taikhoan";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  TaiKhoanDTO taikhoan = new TaiKhoanDTO();
                  taikhoan.setTentaikhoan(ConnectData.rs.getString(1));
                  taikhoan.setMatkhau(ConnectData.rs.getString(2));
                   taikhoan.setVaitro(ConnectData.rs.getString(3));
                  taikhoan.setTrangthai(ConnectData.rs.getInt(4));
                  
                  dstaikhoan.add(taikhoan);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dstaikhoan;
    }
     
     
     public ArrayList docdstaikhoanchuaxai()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <TaiKhoanDTO> dstaikhoankhoa= new ArrayList <TaiKhoanDTO> (); 
          try
          {
              String qry = "select * from taikhoan where trangthai=0";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  TaiKhoanDTO taikhoan = new TaiKhoanDTO();
                  taikhoan.setTentaikhoan(ConnectData.rs.getString(1));
                  taikhoan.setMatkhau(ConnectData.rs.getString(2));
                  taikhoan.setVaitro(ConnectData.rs.getString(3));
                  taikhoan.setTrangthai(ConnectData.rs.getInt(4));
                  dstaikhoankhoa.add(taikhoan);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dstaikhoankhoa;
    }
     public void Them(TaiKhoanDTO tk) {
       MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Insert into taikhoan value (";
            qry+="'"+tk.getTentaikhoan()+"'";
            qry+=","+"'"+tk.getMatkhau()+"'";
            qry+=","+"'"+tk.getVaitro()+"'";
           qry+=","+"'"+tk.getTrangthai()+"'";
            
            qry+=")";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
        public void Xoa(String tentk) {
        MySQLConnect connect = new MySQLConnect();
        try {
            String qry = "Update taikhoan set ";
            qry+="trangthai=0";
            qry+=" "+"where tentk= '"+tentk+"'";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
        public void Sua(TaiKhoanDTO tk) {
        MySQLConnect ConnectData = new MySQLConnect();
        try {
            String qry = "Update taikhoan set ";
            qry +="trangthai=0";
            qry+=" "+"where tentk= '"+tk.getTentaikhoan()+"'";
//            qry += "tentk = '" + tk.getTentaikhoan() + "',";
//            qry += "matkhau = '" + tk.getMatkhau() + "' ";
//            
//            qry += "where tentk = '" + tk.getVaitro() + "'";
            
            System.out.println(qry);
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
            System.out.println(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
         public void SuaTrangThai(String tentk) {
        MySQLConnect ConnectData = new MySQLConnect();
        try {
            //String qry="update taikhoan set trangthai=1 where tentk='"+tk.getTentaikhoan()+"'";
             String qry = "Update taikhoan set ";
            qry+="trangthai=1";
            qry+=" "+"where tentk= '"+tentk+"'";
            System.out.println(qry);
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
            System.out.println(qry);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}

//public class TaiKhoanDAO {
//     public ArrayList docdstaikhoan ()
//    {
//         MySQLConnect ConnectData = new MySQLConnect();
//         ArrayList <TaiKhoanDTO> dstaikhoan= new ArrayList <TaiKhoanDTO> (); 
//          try
//          {
//              String qry = "select * from taikhoan";
//            ConnectData.st = ConnectData.conn.createStatement();
//            ConnectData.rs = ConnectData.st.executeQuery(qry);
//              
//             while(ConnectData.rs.next())
//              {
//                  TaiKhoanDTO tacgia = new TaiKhoanDTO();
//                  tacgia.setTentaikhoan(ConnectData.rs.getString(1));
//                  tacgia.setMatkhau(ConnectData.rs.getString(2));
//                  tacgia.setVaitro(ConnectData.rs.getString(3));
//                  dstaikhoan.add(tacgia);
//             }
//        }
//        catch(SQLException e){
//            JOptionPane.showMessageDialog(null,e.toString());
//        }
//        ConnectData.MySQLDisconnect();
//        return dstaikhoan;
//    }
//}

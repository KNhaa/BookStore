/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TacGiaDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class TacGiaDAO {
    public ArrayList docdstacgia ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <TacGiaDTO> dstacgia = new ArrayList <TacGiaDTO> (); 
          try
          {
              String qry = "select * from tacgia where trangthai=1";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  TacGiaDTO tacgia = new TacGiaDTO();
                  tacgia.setMatg(ConnectData.rs.getString(1));
                  tacgia.setTentg(ConnectData.rs.getString(2));
                  dstacgia.add(tacgia);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dstacgia;
    }
    
    public void Them(TacGiaDTO tacgia)
    {
        MySQLConnect connect = new MySQLConnect();
        try {           
            String qry = "insert into tacgia value(";
            qry += Integer.parseInt(tacgia.getMatg())+",'";
            qry += tacgia.getTentg()+"',";
            qry += "1)";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Xoa(String ma){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Update tacgia set ";
            qry+="trangthai=0";
            qry+=" "+"where matg= '"+ma+"'";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
     public void Sua(TacGiaDTO tacgia){
        MySQLConnect connect = new MySQLConnect();
        try{
            String qry = "Update tacgia set ";
            qry+=" tentg='"+tacgia.getTentg()+"'";
            qry+="where matg="+Integer.parseInt(tacgia.getMatg());
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        connect.MySQLDisconnect();
    }
     
     public int demTacGia()
    {
        
         try {
             int count=0;
             MySQLConnect connect = new MySQLConnect();
             String qry="select count(matg) from tacgia";
             connect.st = connect.conn.createStatement();
             connect.rs = connect.st.executeQuery(qry);
             while(connect.rs.next())
             {
                 count = connect.rs.getInt(1);
             }
             return count;              
         } catch (SQLException ex) {
             Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0;
        
    }
}

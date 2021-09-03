/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoaiDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class LoaiDAO {
     public ArrayList docdsloai ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <LoaiDTO> dsloai = new ArrayList <LoaiDTO> (); 
          try
          {
              String qry = "select * from loaisach";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  LoaiDTO loai = new LoaiDTO();
                  loai.setMaloai(ConnectData.rs.getInt(1));
                  loai.setTenloai(ConnectData.rs.getString(2));
                  dsloai.add(loai);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsloai;
    }
}

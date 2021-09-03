/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NXBDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class NXBDAO {
     public ArrayList docdsnxb ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <NXBDTO> dsnxb= new ArrayList <NXBDTO> (); 
          try
          {
              String qry = "select * from nxb";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  NXBDTO nxb = new NXBDTO();
                  nxb.setManxb(ConnectData.rs.getInt(1));
                  nxb.setTennxb(ConnectData.rs.getString(2));             
                  dsnxb.add(nxb);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsnxb;
    }
}

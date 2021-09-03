/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NCCDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class NCCDAO {
     public ArrayList docdsncc ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <NCCDTO> dsncc = new ArrayList <NCCDTO> (); 
          try
          {
              String qry = "select * from nhacc";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  NCCDTO ncc = new NCCDTO();
                  ncc.setMancc(ConnectData.rs.getString(1));
                  ncc.setTenncc(ConnectData.rs.getString(2));
                  ncc.setDiachi(ConnectData.rs.getString(3));
                  ncc.setSdt(ConnectData.rs.getString(4));
                  dsncc.add(ncc);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsncc;
    }
}

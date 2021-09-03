/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//*
// *
// * @author lenovo-x220i
 
public class KhuyenMaiDAO {
     public ArrayList docdskhuyenmai()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <KhuyenMaiDTO> dskhuyenmai= new ArrayList <KhuyenMaiDTO> (); 
          try
          {
              String qry = "select * from khuyenmai";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  KhuyenMaiDTO khuyenmai = new KhuyenMaiDTO();
                  khuyenmai.setMakm(ConnectData.rs.getString(1));
                  khuyenmai.setTenkm(ConnectData.rs.getString(2));
                  khuyenmai.setQuidinh(ConnectData.rs.getInt(3));
                  khuyenmai.setTilegiam(ConnectData.rs.getInt(4));
                  dskhuyenmai.add(khuyenmai);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dskhuyenmai;
    }
}

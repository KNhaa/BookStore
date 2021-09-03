package BUS;

import javax.swing.JTable;

public class DuyetTraMaBUS {
    public DuyetTraMaBUS(){}
    public String TraMa(JTable JTb){
        int i = JTb.getSelectedRow();
        String Ma = JTb.getValueAt(i, 0).toString();
        return Ma;
    }
        
}
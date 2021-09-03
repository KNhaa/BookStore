/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKeGUI;

import BUS.HoaDonTKBUS;
import BUS.KhachHangTKBUS;
import BUS.NhanVienTKBUS;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ThongKeKHGUI extends JPanel {
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border bordertt = BorderFactory.createLineBorder(new Color(235, 235, 235), 1);
    Border bordertk = BorderFactory.createLineBorder(new Color(30, 30, 30), 1);
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font font = new Font("Segoe UI", Font.BOLD, 22);
    TitledBorder ttcontent2 = new TitledBorder("Thống kê khách hàng");
    JLabel chonkh;
    JComboBox cbkh;
    int choicekh;
    JTable table;
    DefaultTableModel model;
    public ThongKeKHGUI ()
    {
        this.setSize(930, 400);
        this.setBackground(new Color(33, 33, 33));
        this.setBorder(ttcontent2);
        this.setLayout(null);
        ttcontent2.setBorder(bordertt);
        ttcontent2.setTitleJustification(TitledBorder.LEFT);
        ttcontent2.setTitlePosition(TitledBorder.TOP);
        ttcontent2.setTitleColor(new Color(255, 255, 255));
        ttcontent2.setTitleFont(fontt);
        
        chonkh = new JLabel("Chọn khách hàng");
        chonkh.setBounds(400, 40, 250, 32);
        chonkh.setFont(font);
        chonkh.setForeground(new Color(255, 255, 255));
        
        ArrayList <String> choosekh = new ArrayList<>();
        
        KhachHangTKBUS buskh = new KhachHangTKBUS();
        if(KhachHangTKBUS.dskh == null) buskh.readDSKHTKe();       
        for(KhachHangDTO kh : KhachHangTKBUS.dskh)
        {
            choosekh.add(kh.getMakh());
        }
        
        String [] choose = choosekh.toArray(new String[choosekh.size()]);
        cbkh = new JComboBox(choose);
        cbkh.setBounds(650, 40, 100, 32);
        cbkh.setFont(font);
        cbkh.setBorder(border);
        cbkh.setBackground(new Color(255, 255, 255));
        
        this.add(chonkh);
        this.add(cbkh);
        
        Vector header = new Vector();
       // header.add("Mã KH");
        header.add("Họ và tên KH");
        header.add("Mã HĐ ");
        header.add("Tiền trả");
        model = new DefaultTableModel(header, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 3:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        //table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(40);

        //table.setAutoCreateRowSorter(true);
        JScrollPane bangnv = new JScrollPane(table);
        //bangnv.setBounds(30, 120, 1240, 470);
        bangnv.setBounds(10, 120, 900, 270);
 
        this.add(bangnv);

        this.repaint();
        this.revalidate();
        setEvent ();
    }
    public void setEvent()
    {
                
        KhachHangTKBUS buskh = new KhachHangTKBUS();
        if(KhachHangTKBUS.dskh == null) buskh.readDSKHTKe();
        
        HoaDonTKBUS bushd = new HoaDonTKBUS();
        if(HoaDonTKBUS.dshd == null) bushd.docDSHD();
        
        cbkh.addActionListener((ActionEvent e) -> {
            model.setRowCount(0);
            table.setModel(model);
            for (HoaDonDTO hd : bushd.Thongkekh(String.valueOf(cbkh.getSelectedItem()))) {
            Vector row = new Vector();
           // row.add(hd.getMakh());
            row.add(buskh.Timtenkh(hd.getMakh()));
            row.add(hd.getMahd());
            row.add(Chuyentien(String.valueOf(hd.getThuctra())));
            model.addRow(row);
        }
            Vector row1 = new Vector();
            row1.add("--------------------------");
            row1.add("--------------------------");
            row1.add("--------------------------");
            //row1.add("--------------------------");
            model.addRow(row1);
            Vector row2 = new Vector();
            row2.add("Tổng tiền mua");
            row2.add("");
            //row2.add("");
            row2.add(Chuyentien(String.valueOf(bushd.Tonghoadontheokh(String.valueOf(cbkh.getSelectedItem())))));
            model.addRow(row2);
            table.setModel(model);
        });
        
//        for (HoaDonDTO hd : bushd.Thongkekh("KH01"))
//        {
//            Vector row = new Vector();
//            row.add(hd.getMakh());
//            row.add(buskh.Timtenkh(hd.getMakh()));
//            row.add(hd.getMahd());
//            row.add(Chuyentien(String.valueOf(hd.getThuctra())));
//            model.addRow(row);
//        }
//        Vector row1 = new Vector();
//            row1.add("--------------------------");
//            row1.add("--------------------------");
//            row1.add("--------------------------");
//            row1.add("--------------------------");
//            model.addRow(row1);
//            Vector row2 = new Vector();
//            row2.add("Tổng tiền KH trả");
//            row2.add("");
//            row2.add("");
//           // row2.add(Chuyentien(String.valueOf(bushd.Tonghoadontheokh("KH01"))));
//           row2.add(Chuyentien(String.valueOf(bushd.Tonghoadontheokh(""))));
//            model.addRow(row2);
//            table.setModel(model);
//            table.setModel(model);
    }
    
    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }
    public static void main(String[] args) {
        ThongKeKHGUI a=new ThongKeKHGUI();
            //a.setVisible(true);
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }
}

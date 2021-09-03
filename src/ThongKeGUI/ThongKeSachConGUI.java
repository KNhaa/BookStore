/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKeGUI;


import BUS.SachTKBUS;
import DTO.SachDTO;
import DTO.SachTKDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ThongKeSachConGUI extends JPanel {

    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border bordertt = BorderFactory.createLineBorder(new Color(235, 235, 235), 1);
    Border bordertk = BorderFactory.createLineBorder(new Color(30, 30, 30), 1);
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font font = new Font("Segoe UI", Font.BOLD, 22);
    ArrayList<SachTKDTO> dshang = new ArrayList<SachTKDTO>();

    JLabel chonloai;
    JComboBox cbloai;
    //int chon;
    JLabel thongtin;
    JTable table;
    DefaultTableModel model;
    TitledBorder ttcontent2 = new TitledBorder("Thống Kê Sách");

    public ThongKeSachConGUI() {

//        this.setSize(1300, 600);
        this.setSize(930, 400);
        this.setBackground(new Color(33, 33, 33));
        this.setBorder(ttcontent2);
        this.setLayout(null);

        ttcontent2.setBorder(bordertt);
        ttcontent2.setTitleJustification(TitledBorder.LEFT);
        ttcontent2.setTitlePosition(TitledBorder.TOP);
        ttcontent2.setTitleColor(new Color(255, 255, 255));
        ttcontent2.setTitleFont(fontt);

        chonloai = new JLabel("Chọn loại");
        chonloai.setFont(font);
        chonloai.setForeground(new Color(255, 255, 255));
        chonloai.setBounds(30, 40, 100, 32);

        SachTKBUS bus = new SachTKBUS();
        bus.docDSSPTKe();

        ArrayList<String> chooseloai = bus.DSloai();

        String[] choose = chooseloai.toArray(new String[chooseloai.size()]);
        cbloai = new JComboBox(choose);
        cbloai.setBounds(150, 40, 250, 32);
        cbloai.setFont(font);
        cbloai.setBorder(border);
        cbloai.setBackground(new Color(255, 255, 255));

        thongtin = new JLabel("");
        thongtin.setFont(font);
        thongtin.setForeground(new Color(255, 255, 255));
        thongtin.setBounds(190, 80, 600, 32);

        this.add(chonloai);
        this.add(cbloai);
        this.add(thongtin);

        Vector header = new Vector();
        header.add("Mã Sách");
        header.add("Mã NXB");     
        header.add("Tên Sách");
        header.add("Giá Tiền");
        header.add("Số Lượng");
        model = new DefaultTableModel(header, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 5:
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

        table.setAutoCreateRowSorter(true);
        JScrollPane bangsp = new JScrollPane(table);
        bangsp.setBounds(10, 120, 900, 270);
        this.add(bangsp);


        table.setModel(model);
      
        thongtin.setText("Mời bạn chọn loại sách!");
        cbloai.addActionListener((ActionEvent e) -> {
            dshang = bus.Timkiemtheohang(String.valueOf(cbloai.getSelectedItem()) );
            
            model.setRowCount(0);
            table.setModel(model);
            for (SachTKDTO sp : dshang) {
                System.out.println("Ds hãng"+sp.getMasach());
                Vector row = new Vector();
                row.add(sp.getMasach());
                row.add(sp.getManxb());
               
                row.add(sp.getTensach());
                row.add(Chuyentien(String.valueOf(sp.getDongia())));
                row.add(sp.getSoluong());
                model.addRow(row);
            }
            table.setModel(model);
            thongtin.setText("Cửa hàng có "+table.getRowCount()+" quyển sách loại "+(String) cbloai.getSelectedItem());
        });
    }

    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }
     public static void main(String[] args) {
        ThongKeSachConGUI a=new ThongKeSachConGUI();
            //a.setVisible(true);
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }
}

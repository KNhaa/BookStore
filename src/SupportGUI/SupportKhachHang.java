/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;

//import BUS.DuyetTraMaBUS;
import BUS.DuyetTraMaBUS;
import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
//import Manager.GUI.BaoHanhGUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SupportKhachHang extends JFrame {
    JPanel topPnl,combobox;
    JTable table;
    JTextField txtimkiem; 
    DefaultTableModel model;
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    JButton chon,huy,timkiem;
    Font font = new Font("Segoe UI",Font.BOLD,18);
    public  SupportKhachHang(String type)
   // public  SupportKhachHang()
    {
       
        this.setSize(1000,600);
        
        this.setTitle("Danh Sách Khách Hàng");
         
        Vector header = new Vector();
        header.add("Mã KH");
        header.add("Họ");
        header.add("Tên");
        header.add("SĐT");
        header.add("Địa Chỉ");
        
        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(bordernull);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
//        table.getColumnModel().getColumn(5).setPreferredWidth(100);
//        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.getTableHeader().setBackground(new Color(66, 134, 244));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(30);
        JScrollPane bangsp = new JScrollPane(table);
        bangsp.setBounds(30, 90, 940,400);      
        add(bangsp);
        KhachHangBUS khbus = new KhachHangBUS();
        if(KhachHangBUS.dskh == null) khbus.readDSKH();
        // dsnvDTO = KhachHangBUS.dsnv;
        for (KhachHangDTO nv : KhachHangBUS.dskh){
            Vector row = new Vector();
            row.add(nv.getMakh());
            row.add(nv.getHokh());
            row.add(nv.getTenkh());
            row.add(nv.getSdt());
            row.add(nv.getDiachi());
            
            model.addRow(row);
        }
        table.setModel(model);
        
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(30, 30, 300, 32);
        txtimkiem.setBorder(border);
        
        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));
        
//        timkiem =new JButton(" ");
//        timkiem.setBounds(520,30,95,32);
//        timkiem.setBackground(new Color(30, 215, 96));
//        timkiem.setForeground(new Color(255,255,255));
//        timkiem.setIcon(hinhtimkiem);
//        timkiem.setCursor(new Cursor(HAND_CURSOR));
//        timkiem.setHorizontalTextPosition(SwingConstants.CENTER); // Dùng để canh giữa icon của Button
//        
//        String choose[]={"Theo Mã KH","Theo Họ","Theo Tên","Theo Giới Tính"};    
//        JComboBox cb = new JComboBox(choose);
//        cb.setBounds(350,30,150,32);
//        cb.setFont(new Font("Segoe UI",Font.BOLD,16));
//        cb.setBorder(border);
        
        chon = new JButton ("Chọn");
        chon.setFont(font);
        chon.setBounds(758,500,100,50);
        chon.setBackground(new Color(30, 215, 96));
        chon.setForeground(new Color(255,255,255));
        chon.setFocusPainted(false);
        chon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(type.equals("ThemHoaDon"))
                {
                    //ThemHDGUI.txmakh.setText(new DuyetTraMaBUS().TraMa(table));
                    SupportHoaDon.txmakh.setText(new DuyetTraMaBUS().TraMa(table));
                }
//                if(type.equals("SuaHoaDon"))
//                {
//                    SuaHDGUI.txmakh.setText(new DuyetTraMaBUS().TraMa(table));
//                }
//                if(type.equals("BaoHang"))
//                    BaoHanhGUI.txmakh.setText(new DuyetTraMaBUS().TraMa(table));
               setVisible(false);
            }
        });
        
        huy = new JButton ("Hủy");
        huy.setBounds(868,500,100,50);
        huy.setFont(font);
        huy.setBackground(new Color(30, 215, 96));
        huy.setForeground(new Color(255,255,255));
        huy.setFocusPainted(false);
        huy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        //add(cb);
        add(txtimkiem);
        //add(timkiem);
        add(chon);
        add(huy);
        
        //Tim kiếm
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        txtimkiem.getDocument().addDocumentListener( new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
       this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);

    }
}         
   
         
    
//        public static void main(String[] args) {
//        SupportKhachHang a= new SupportKhachHang();
//        
//    }



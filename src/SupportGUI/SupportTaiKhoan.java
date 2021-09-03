/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;

import AdminGUI.NhanVienGUI;
import BUS.DuyetTraMaBUS;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lenovo-x220i
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package GUI.DuyetGUI;

//import BUS.DuyetTraMaBUS;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
//import DTO.NhaCungCapDTO;
//import Manager.GUI.SanPhamGUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author acer
 */
public class SupportTaiKhoan extends JFrame {

    JPanel topPnl, combobox;
    JTable table;
    JTextField txtimkiem;
    DefaultTableModel model;
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    JButton chon, huy, timkiem;
    Font font = new Font("Segoe UI", Font.BOLD, 18);

    public SupportTaiKhoan() {//String text
        this.setSize(1000, 600);
        
        this.setTitle("Danh Sách Tài Khoản");

        Vector header = new Vector();
        header.add("Tên Tài Khoản");
        header.add("Mật Khẩu");
        header.add("Vai Trò");
        header.add("Trạng Thái");

        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(bordernull);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        TaiKhoanBUS bus = new TaiKhoanBUS();
//        if (TaiKhoanBUS.dstk == null) {
//            bus.docDSTaiKhoanChuaXai();
//        }
//        bus.docDSTaiKhoanChuaXai();
//        for (TaiKhoanDTO tk : TaiKhoanBUS.dstk) {
//            Vector row = new Vector();
//            row.add(tk.getTentaikhoan());
//            row.add(tk.getMatkhau());
//            row.add(tk.getVaitro());
//            row.add(tk.getTrangthai());
//            model.addRow(row);
//        }
        
        if (TaiKhoanBUS.dstkchuasai == null) {
            bus.docDSTaiKhoanChuaXai();
        }
        bus.docDSTaiKhoanChuaXai();
        for (TaiKhoanDTO tk : TaiKhoanBUS.dstkchuasai) {
            Vector row = new Vector();
            row.add(tk.getTentaikhoan());
            row.add(tk.getMatkhau());
            row.add(tk.getVaitro());
            row.add(tk.getTrangthai());
            model.addRow(row);
        }
        table.getTableHeader().setBackground(new Color(66, 134, 244));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(220);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.setModel(model);

        JScrollPane bangncc = new JScrollPane(table);
        bangncc.setBounds(30, 90, 940, 400);
        //pn2.add(bangncc);
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(30, 30, 300, 32);
        txtimkiem.setBorder(border);

        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));

        timkiem = new JButton(" ");
        timkiem.setBounds(520, 30, 95, 32);
        timkiem.setBackground(new Color(30, 215, 96));
        timkiem.setForeground(new Color(255, 255, 255));
        timkiem.setIcon(hinhtimkiem);
        timkiem.setCursor(new Cursor(HAND_CURSOR));
        timkiem.setHorizontalTextPosition(SwingConstants.CENTER); // Dùng để canh giữa icon của Button

        String choose[] = {"Tên TK", "Vai Trò", "Trạng Thái"};
        JComboBox cb = new JComboBox(choose);
        cb.setBounds(350, 30, 150, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);

        chon = new JButton("Chọn");
        chon.setFont(font);
        chon.setBounds(758, 500, 100, 50);
        chon.setBackground(new Color(30, 215, 96));
        chon.setForeground(new Color(255, 255, 255));
        chon.setFocusPainted(false);
        //chon.setOpaque(true);
        chon.addMouseListener(new MouseAdapter() {
//            @Override
            public void mouseClicked(MouseEvent e) {
//                if(text.equals("Nhân viên"))
//                {
                    NhanVienGUI.txtentk.setText(new DuyetTraMaBUS().TraMa(table));
                    setVisible(false);
//                }
            }
        });
        huy = new JButton("Hủy");
        huy.setVisible(true);
        huy.setBounds(868, 500, 100, 50);
        huy.setFont(font);
        huy.setBackground(new Color(30, 215, 96));
        huy.setForeground(new Color(255, 255, 255));
        huy.setFocusPainted(false);
        huy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        add(bangncc);
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
//    public static void main(String[] args) {
//        SupportTaiKhoan gui=new SupportTaiKhoan();
//        
//    }
}



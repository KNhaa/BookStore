/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;

/**
 *
 * @author lenovo-x220i
 */
import BUS.DuyetTraMaBUS;
import BUS.KhuyenMaiBUS;
import DTO.KhuyenMaiDTO;
import static SupportGUI.SupportHoaDon.txmakm;
import static SupportGUI.SupportHoaDon.txtongtien;
//import DTO.KhuyenMaiThuongDTO;
//import static GUI.DuyetGUI.ThemHDGUI.txmakm;
//import Manager.GUI.BaoHanhGUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public class SupportKhuyenMai extends JFrame {

    JPanel topPnl, combobox;
    JTable table;
    JTextField txtimkiem;
    DefaultTableModel model;
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    JButton chon, huy, timkiem;
    Font font = new Font("Segoe UI", Font.BOLD, 18);

    public SupportKhuyenMai(String type) throws ParseException {

        this.setSize(1000, 620);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Danh Sách Khuyến Mãi");
// Khuyen mai thuong         
        Vector header = new Vector();
        header.add("Mã KM");
        header.add("Tên KM");
        header.add("Qui Định");
        header.add("Tỉ Lệ Giảm");
        header.add("Trạng thái");
        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(bordernull);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        table.getTableHeader().setBackground(new Color(66, 134, 244));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(30);
        JScrollPane bangsp = new JScrollPane(table);
        bangsp.setBounds(30, 90, 940, 200);
        add(bangsp);
        KhuyenMaiBUS kmbus = new KhuyenMaiBUS();
        if (kmbus.dskm == null) {
            kmbus.docDSKMD();
        }
        for (KhuyenMaiDTO km : kmbus.dskm) {
            Vector row = new Vector();
            row.add(km.getMakm());
            row.add(km.getTenkm());
            row.add(km.getQuidinh());
            row.add(km.getTilegiam());
            if(type.equals("ThemHoaDon"))
            row.add(kmbus.trangthaiDSKM(Integer.valueOf(SupportHoaDon.txtongtien.getText()), km.getQuidinh())); 
        // row.add(kmbus.trangthaiDSKM(SupportHoaDon.txtongtien.getText(), km.getQuidinh())); 
           
            model.addRow(row);
            System.out.println(SupportHoaDon.txtongtien.getText()); 
            
        }
        table.setModel(model);
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                table2.clearSelection();
//            }
//        });

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

        String choose[] = {"Theo Mã KM", "Theo Tên", "Theo Tỉ lệ giảm"};
        JComboBox cb = new JComboBox(choose);
        cb.setBounds(350, 30, 150, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);

        chon = new JButton("Chọn");
        chon.setFont(font);
        chon.setBounds(758, 520, 100, 50);
        chon.setBackground(new Color(30, 215, 96));
        chon.setForeground(new Color(255, 255, 255));
        chon.setFocusPainted(false);
        chon.addMouseListener(new MouseAdapter() {
                public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                //int y = table2.getSelectedRow();
                if (i >= 0) {
                    if(String.valueOf(model.getValueAt(i, 4)).equals("Đang diễn ra"))
                    {
                        if (type.equals("ThemHoaDon")) {
                        SupportHoaDon.txmakm.setText(new DuyetTraMaBUS().TraMa(table));
                        KhuyenMaiBUS buskm = new KhuyenMaiBUS();
                        buskm.docDSKMD();
                       // buskm.docDSKMT();
                        int tile=buskm.duyetTile(txmakm.getText());
                       
                        SupportHoaDon.thanhtien = SupportHoaDon.tongtien - SupportHoaDon.tongtien * tile / 100;
                        SupportHoaDon.txthanhtien.setText(Chuyentien(String.valueOf(SupportHoaDon.thanhtien)));
                    }
//                    if (type.equals("SuaHoaDon")) {
//                        SuaHDGUI.txmakm.setText(new DuyetTraMaBUS().TraMa(table));
//                    }
                    setVisible(false);
                    }
                    else JOptionPane.showMessageDialog(null, "Hoạt động khuyễn mãi chưa diễn ra");
                }
//                if (y >= 0) {
//                    if(String.valueOf(model2.getValueAt(y, 5)).equals("Đang diễn ra"))
//                    {
//                        if (type.equals("ThemHoaDon")) {
//                        ThemHDGUI.txmakm.setText(new DuyetTraMaBUS().TraMa(table2));
//                    }
//                    if (type.equals("SuaHoaDon")) {
//                        SuaHDGUI.txmakm.setText(new DuyetTraMaBUS().TraMa(table2));
//                    }
//                    setVisible(false);
//                    }
//                    else JOptionPane.showMessageDialog(null, "Hoạt động khuyễn mãi chưa diễn ra");
//                    
//                }
//                
            }
        });

        huy = new JButton("Hủy");
        huy.setBounds(868, 520, 100, 50);
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
        add(cb);
        add(txtimkiem);
        add(timkiem);
        add(chon);
        add(huy);
        this.repaint();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
//        TableRowSorter<TableModel> rowSorter2 = new TableRowSorter<>(table2.getModel());
//        table2.setRowSorter(rowSorter2);
        txtimkiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                   // rowSorter2.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                   // rowSorter2.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                   // rowSorter2.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    //rowSorter2.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }
//    public static void main(String[] args) throws ParseException {
//        SupportKhuyenMai a=new SupportKhuyenMai("ThemHoaDon");
//    }
}
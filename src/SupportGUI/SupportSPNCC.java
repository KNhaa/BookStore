/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;


import BUS.DuyetTraMaBUS;
import BUS.SachBUS;
import DTO.SachDTO;
//import Manager.GUI.BaoHanhGUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
 * @author acer
 */
public class SupportSPNCC extends JFrame {
    JPanel topPnl,combobox;
    JTable table;
    JTextField txtimkiem; 
    DefaultTableModel model;
    Border border = BorderFactory.createLineBorder(new Color(85, 65, 118), 1);
    JButton chon,huy,timkiem;
    Font font = new Font("Segoe UI",Font.BOLD,18);
    public  SupportSPNCC(String mancc){
        
      
        this.setSize(1000,600);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Danh Sách Sản Phẩm");
        
        //JOptionPane.showMessageDialog(null, mancc);
        Vector header = new Vector();       
        header.add("Mã Sách");
        header.add("Mã NCC");
        header.add("Mã NXB");
        header.add("Mã loại");
        header.add("Tên sách");
        header.add("Giá nhập");
        
        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(250);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        //table.getTableHeader().setBackground(new Color(66, 134, 244));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(30);
        JScrollPane bangsp = new JScrollPane(table);
        bangsp.setBounds(30, 90, 940,400);       
        add(bangsp);
        
        SachBUS spbus = new SachBUS();
        if(SachBUS.dssp == null) spbus.docDSSP();
        for (SachDTO sp : SachBUS.dssp)
        {
            if(sp.getMancc().equals(mancc))
            {
                Vector row = new Vector();               
                row.add(sp.getMasach());
                row.add(sp.getMancc());
                row.add(sp.getManxb());
                row.add(sp.getMaloai());
                row.add(sp.getTensach());
            //int gianhap = sp.getGia() / 100 * 80;
                row.add(sp.getDongia()/100*80);
                model.addRow(row); 
            }
        }
        table.setModel(model);
        
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(30, 30, 300, 32);
        txtimkiem.setBorder(border);
        
        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));
        
        chon = new JButton ("Chọn");
        chon.setFont(font);
        chon.setBounds(758,500,100,50);
        chon.setBackground(new Color(30, 215, 96));
        chon.setForeground(new Color(255,255,255));
        chon.setFocusPainted(false);
        chon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int i = table.getSelectedRow();
               if(i >= 0)
               {
                    SupportPhieuNhap.txmasp.setText(new DuyetTraMaBUS().TraMa(table));
                    SupportPhieuNhap.txten.setText((String) table.getValueAt(i, 4));
                    SupportPhieuNhap.txgianhap.setText(String.valueOf(table.getValueAt(i, 5)));

                    setVisible(false);
               }
               else JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng");
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
       // add(timkiem);
        add(chon);
        add(huy);
        //timkiem
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
    }
}


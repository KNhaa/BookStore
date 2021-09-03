/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import Report.ExcelReport;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
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
public class KhachHangGUI extends JPanel {

    int choice = 0;

    DefaultTableModel model;
    JLabel lbmakh, lbten, lbho, lbsdt, lbdiachi, lbtimkiem,lbanh, lbicon, lbtop, hinhavatar, lbavatar;
    JLabel lbexit, lbinfokh, lbtknc;
    JTextField txmakh, txten, txho, txsdt, txdiachi, txtimkiem;
    JButton them, xoa, sua, reset, chonanh, chonmakh, back, tknc, tkncoff;
    JTable table;
   
    /*Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fonttknc = new Font("Segoe UI", Font.PLAIN, 15);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);*/
    Font font = new Font("Helvetica", Font.BOLD, 15);
    Font fonttknc = new Font("Helvetica", Font.PLAIN, 12);
    Font font1 = new Font("Helvetica", Font.BOLD, 22);
    Border border = BorderFactory.createLineBorder(new Color(33,33,33), 1);
    Border bordernull = BorderFactory.createEmptyBorder();
    //Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    Border borderinput = BorderFactory.createLineBorder(new Color(0,0,0), 2);
    JButton exit;
   
    int change = 0;
    ArrayList<KhachHangDTO> printList = new ArrayList<KhachHangDTO>();

    public KhachHangGUI() {

        //this.setSize(1350, 945);
        this.setSize(950, 700);
        this.setLayout(null);
        this.setBorder(border);
        //this.setBackground(new Color(33,33,33));
        //this.setBackground(new Color(238,229,211));
        this.setBackground(new Color(237,241,255));
//        lbtknc = new JLabel();
//        lbtknc.setBounds(340, 65, 450, 80);
//           lbtknc.setBackground(new Color(100,100,100));
//        lbtknc.setOpaque(true);
//        this.add(lbtknc);

       
       // ImageIcon hinhmuiten = new ImageIcon(getClass().getResource("/HinhAnh/muiten.png"));
        

       

        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));
        
      //  lbtknc.setVisible(false);

        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);

        ImageIcon hinhback = new ImageIcon(getClass().getResource("/HinhAnh/back.png"));
        ImageIcon hinhbackf = new ImageIcon(getClass().getResource("/HinhAnh/backf.png"));
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(70, 18, 250, 32);
        txtimkiem.setBorder(border);
        txtimkiem.addMouseListener(new MouseListener() {
            // SẢN PHẨM GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtimkiem.getFocusTraversalKeysEnabled()) {
                    //back.setIcon(hinhbackf);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        back = new JButton();
        back.setBounds(25, 25, 20, 20);
        back.setIcon(hinhback);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.setBorder(bordernull);
        back.setBackground(new Color(33,33,33));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                //back.setIcon(hinhback);
                txtimkiem.setText("");
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                KhachHangBUS khbus = new KhachHangBUS();
                khbus.readDSKH();
                printList = khbus.dskh;
                for (KhachHangDTO kh : printList) {
                    Vector row = new Vector();
                    row.add(kh.getMakh());
                    row.add(kh.getHokh());
                    row.add(kh.getTenkh());
                    row.add(kh.getSdt());
                    row.add(kh.getDiachi());
                   
                    model.addRow(row);
                }
                table.setModel(model);
            }
        });
        lbtop.add(back);

        String choose[] = {"Theo Mã ", "Theo Họ", "Theo Tên ", "Theo SĐT", "Theo Địa Chỉ"};
        JComboBox cb = new JComboBox(choose);
        cb.setBounds(340, 18, 130, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);
        cb.setBackground(new Color(255, 255, 255));



        tknc = new JButton();
        tknc.setBounds(490, 18, 30, 30);

        tknc.setBorder(bordernull);
        tknc.setFocusTraversalKeysEnabled(false);
        tknc.setBackground(new Color(33,33,33));
        tknc.addMouseListener(new MouseListener() {
            // SẢN PHẨM GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                lbtknc.setVisible(true);
                tknc.setVisible(false);
                tkncoff.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        tkncoff = new JButton();
        tkncoff.setBounds(490, 18, 30, 30);
        
        tkncoff.setBorder(bordernull);
        tkncoff.setFocusTraversalKeysEnabled(false);
        tkncoff.setBackground(new Color(33,33,33));
        tkncoff.setVisible(false);
        tkncoff.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbtknc.setVisible(false);
                tknc.setVisible(true);
                tkncoff.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        //lbtop.add(tkncoff);
        //lbtop.add(tknc);

        lbexit = new JLabel();
        lbexit.setBackground(new Color(33,33,33));
        //.setBounds(1170, 0, 180, 35);
        lbexit.setBounds(770, 0, 180, 35);
        
        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        exit = new JButton();
        exit.setBounds(120, 0, 60, 35);
        exit.setBackground(new Color(30, 30, 30));
        exit.setIcon(hinhexit);
        exit.setBorder(bordernull);
        exit.setFocusPainted(false);
        exit.setHorizontalTextPosition(SwingConstants.LEFT);
        exit.addMouseListener(new MouseListener() {
            // SẢN PHẨM GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(new Color(30, 30, 30));
            }

        });

        lbexit.add(exit);
        lbtop.add(lbexit);
        lbtop.add(cb);
        lbtop.add(txtimkiem);

        lbinfokh = new JLabel("Khách Hàng");
        lbinfokh.setBounds(30, 80, 200, 60);
        lbinfokh.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //lbinfokh.setForeground(new Color(30, 215, 96));
        lbinfokh.setForeground(new Color(33,33,33));

        lbmakh = new JLabel("Mã :", JLabel.LEFT);
        lbmakh.setBounds(30, 155, 60, 50);
        lbmakh.setFont(font1);
        //lbmakh.setForeground(new Color(255, 255, 255));
        lbmakh.setForeground(new Color(33,33,33));
        txmakh = new JTextField(18);
        txmakh.setEditable(false);
        KhachHangBUS khbus = new KhachHangBUS();
        txmakh.setText(khbus.Khtieptheo());
        
        txmakh.setFont(font);
        txmakh.setBounds(100, 165, 180, 30);
        txmakh.setBorder(border);
        txmakh.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txmakh.setBounds(95, 160, 200, 40);
                txmakh.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txmakh.setBorder(bordernull);
                if (txmakh.getText().equals("")) {
                    txmakh.setBounds(100, 165, 180, 30);
                } else {
                    txmakh.setBounds(95, 160, 200, 40);
                }
            }
        });

        lbho = new JLabel("Họ :", JLabel.LEFT);
        lbho.setBounds(30, 215, 60, 50);
        lbho.setFont(font1);
        //lbho.setForeground(new Color(255, 255, 255));
        lbmakh.setForeground(new Color(33,33,33));
        txho = new JTextField(18);
        txho.setFont(font);
        txho.setBounds(100, 225, 180, 30);
        txho.setBorder(border);
        txho.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txho.setBounds(95, 220, 200, 40);
                txho.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txho.setBorder(bordernull);
                if (txho.getText().equals("")) {
                    txho.setBounds(100, 225, 180, 30);
                } else {
                    txho.setBounds(95, 220, 200, 40);
                }
            }
        });

        lbten = new JLabel("Tên :", JLabel.LEFT);
        lbten.setBounds(30, 275, 60, 50);
        lbten.setFont(font1);
        lbten.setForeground(new Color(33,33,33));
        txten = new JTextField(18);
        txten.setFont(font);
        txten.setBounds(100, 285, 180, 30);
        txten.setBorder(border);
        txten.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txten.setBounds(95, 280, 200, 40);
                txten.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txten.setBorder(bordernull);
                if (txten.getText().equals("")) {
                    txten.setBounds(100, 280, 180, 30);
                } else {
                    txten.setBounds(95, 285, 200, 40);
                }
            }
        });

      
        lbdiachi = new JLabel("Địa Chỉ: ", JLabel.LEFT);
        lbdiachi.setBounds(390, 215, 100, 50);
        lbdiachi.setFont(font1);
        lbdiachi.setForeground(new Color(33,33,33));
        txdiachi = new JTextField(18);
        txdiachi.setFont(font);
        txdiachi.setBounds(540, 225, 180, 30);
        txdiachi.setBorder(border);
        txdiachi.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txdiachi.setBounds(535, 220, 200, 40);
                txdiachi.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txdiachi.setBorder(bordernull);
                if (txdiachi.getText().equals("")) {
                    txdiachi.setBounds(540, 225, 180, 30);
                } else {
                    txdiachi.setBounds(535, 220, 200, 40);
                }
            }
        });

       

        lbsdt = new JLabel("SĐT: ", JLabel.LEFT);
        //lbsdt.setBounds(850, 155, 100, 50);
        lbsdt.setBounds(390, 155, 100, 50);
        lbsdt.setFont(font1);
        lbsdt.setForeground(new Color(33,33,33));
        txsdt = new JTextField(18);
        txsdt.setFont(font);
        txsdt.setBounds(540, 165, 180, 30);
        txsdt.setBorder(border);
        txsdt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txsdt.setBounds(540, 160, 200, 40);
                txsdt.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txsdt.setBorder(bordernull);
                if (txsdt.getText().equals("")) {
                    txsdt.setBounds(545, 165, 180, 30);
                } else {
                    txsdt.setBounds(540, 160, 200, 40);
                }
            }
        });

        chonanh = new JButton("Load");
        chonanh.setBounds(100, 850, 200, 50);
        chonanh.setBackground(new Color(255, 255, 255));
        //chonanh.setForeground(new Color(25, 20, 20));
        chonanh.setFont(new Font("Segoe UI", Font.BOLD, 18));
        chonanh.setCursor(new Cursor(HAND_CURSOR));

        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        them = new JButton();
        //them.setBounds(770, 340, 130, 50);
        them.setBounds(200, 340, 130, 50);
       them.setBackground(new Color(33,33,33));
        them.setBorder(bordernull);
       them.setIcon(hinhthem);
        them.setFocusPainted(false);
        them.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                them.setIcon(hinhthem1);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                them.setIcon(hinhthem);
            }

        });
        

        ImageIcon hinhxoa = new ImageIcon(getClass().getResource("/HinhAnh/xoa.png"));
        ImageIcon hinhxoa1 = new ImageIcon(getClass().getResource("/HinhAnh/xoa1.png"));
        xoa = new JButton();
        xoa.setBounds(350, 340, 110, 50);
        xoa.setBackground(new Color(33,33,33));
        xoa.setBorder(bordernull);
        xoa.setIcon(hinhxoa);
        xoa.setFocusPainted(false);
        xoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                xoa.setIcon(hinhxoa1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                xoa.setIcon(hinhxoa);
            }

        });
        xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng", "Xóa", dialogButton);
                if(dialogResult == 0)
                {
                String Ma = txmakh.getText();
                KhachHangBUS bus = new KhachHangBUS();
                if (!bus.delete(Ma)) {
                    return;
                }
                int i = table.getSelectedRow();
                model.removeRow(i);
                table.setModel(model);              
                KhachHangBUS khbus = new KhachHangBUS();
                txmakh.setText(khbus.Khtieptheo());
                txho.setText("");
                txten.setText("");
                
                txsdt.setText("");
                txdiachi.setText("");
               
                }
            }
        });
        
        ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
        ImageIcon hinhsua1 = new ImageIcon(getClass().getResource("/HinhAnh/sua1.png"));
        sua = new JButton();
        //sua.setBounds(1025, 340, 110, 50);
        sua.setBounds(480, 340, 110, 50);
        sua.setBackground(new Color(33,33,33));
        sua.setBorder(bordernull);
        sua.setIcon(hinhsua);
        sua.setFocusPainted(false);
        sua.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (change == 0) {
                    sua.setIcon(hinhsua1);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (change == 0) {
                    sua.setIcon(hinhsua);
                }
            }

        });

        ImageIcon hinhreset = new ImageIcon(getClass().getResource("/HinhAnh/reset.png"));
        ImageIcon hinhreset1 = new ImageIcon(getClass().getResource("/HinhAnh/reset1.png"));
        reset = new JButton();
        //reset.setBounds(1140, 340, 125, 50);
        reset.setBounds(610, 340, 125, 50);
        reset.setBackground(new Color(33,33,33));
        reset.setBorder(bordernull);
        reset.setIcon(hinhreset);
        reset.setFocusPainted(false);
        reset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                txmakh.setText("");
//                txmakh.setEditable(true);
                txmakh.setEditable(false);
                KhachHangBUS khbus = new KhachHangBUS();
                txmakh.setText(khbus.Khtieptheo());
                txho.setText("");
                txten.setText("");
                
                txsdt.setText("");
                txdiachi.setText("");
                                               
                txmakh.setBounds(100, 165, 180, 30);
                txho.setBounds(100, 225, 180, 30);
                txten.setBounds(100, 285, 180, 30);
                txsdt.setBounds(540, 165, 180, 30);
                txdiachi.setBounds(540, 225, 180, 30);
                them.setVisible(true);
                xoa.setVisible(true);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                reset.setIcon(hinhreset1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reset.setIcon(hinhreset);
            }

        });
        them.setContentAreaFilled(false);
        xoa.setContentAreaFilled(false);
        sua.setContentAreaFilled(false);
        reset.setContentAreaFilled(false);
        chonanh.setContentAreaFilled(false);
        tknc.setContentAreaFilled(false);
        tknc.setFocusPainted(false);
        tkncoff.setContentAreaFilled(false);
        tkncoff.setFocusPainted(false);

        Vector header = new Vector();
        header.add("Mã KH");
        header.add("Họ");
        header.add("Tên");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        

        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
       
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(35);
        
        JScrollPane bangsp = new JScrollPane(table);
        //bangsp.setBounds(30, 420, 1290, 300);
        bangsp.setBounds(30, 420, 840, 260);
        KhachHangBUS bus = new KhachHangBUS();
        if (KhachHangBUS.dskh == null) {
            bus.readDSKH();
            
        }
        for (KhachHangDTO kh : KhachHangBUS.dskh) {
            Vector row = new Vector();
            row.add(kh.getMakh());
            row.add(kh.getHokh());
            row.add(kh.getTenkh());
            row.add(kh.getSdt());
            row.add(kh.getDiachi());
           
            model.addRow(row);
        }
        table.setModel(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int i = table.getSelectedRow();
                String code = (table.getValueAt(i, 0).toString());
                KhachHangBUS bus = new KhachHangBUS();
                KhachHangDTO kh = bus.getInfoRow(code);
                txmakh.setText(kh.getMakh());
                txmakh.setEditable(false);
                txten.setText(kh.getTenkh());
                txho.setText(kh.getHokh());
                txsdt.setText(kh.getSdt());
                txdiachi.setText(kh.getDiachi());
             
                txmakh.setBounds(100, 165, 180, 30);
                txho.setBounds(100, 225, 180, 30);
                txten.setBounds(100, 285, 180, 30);
                txsdt.setBounds(540, 165, 180, 30);
                txdiachi.setBounds(540, 225, 180, 30);
                
                them.setVisible(false);
                //them.setEnabled(false);
               
            }
        });

        //add event
        them.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khách hàng", "Thêm", dialogButton);
                if(dialogResult == 0)
                {
                    KhachHangDTO kh = new KhachHangDTO();

                kh.setMakh(txmakh.getText());
                kh.setHokh(txho.getText());
                kh.setTenkh(txten.getText());
                kh.setSdt(txsdt.getText());
                kh.setDiachi(txdiachi.getText());
                
                KhachHangBUS bus = new KhachHangBUS();
                if (!bus.add(kh)) {
                    return;
                }
                Vector row = new Vector();
                row.add(kh.getMakh());
                row.add(kh.getHokh());
                row.add(kh.getTenkh());
                row.add(kh.getSdt());
                row.add(kh.getDiachi());
               
                model.addRow(row);
                table.setModel(model);
                KhachHangBUS khbus = new KhachHangBUS();
                txmakh.setText(khbus.Khtieptheo());
                txho.setText("");
                txten.setText("");                
                txsdt.setText("");
                txdiachi.setText("");
            }
                }
                
        });
        sua.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (change == 0) {
                    change = 1;
                    txmakh.setEditable(false);
                    ImageIcon hinhxacnhan = new ImageIcon(getClass().getResource("/HinhAnh/xacnhan.png"));
                    sua.setIcon(hinhxacnhan);
                    them.setVisible(false);
                    xoa.setVisible(false);
                    KhachHangBUS khbus = new KhachHangBUS();
                    txmakh.setText(khbus.Khtieptheo());
                    txho.setText("");
                    txten.setText("");
                    txsdt.setText("");
                    txdiachi.setText("");
                    
                  //  JOptionPane.showMessageDialog(null, "Chọn dòng cần sửa trên table rồi ấn xác nhận để sửa");
                } else {
                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        try {
                            KhachHangDTO kh = new KhachHangDTO();
                            kh.setMakh(txmakh.getText());
                            kh.setHokh(txho.getText());
                            kh.setTenkh(txten.getText());
                            kh.setSdt(txsdt.getText());
                            kh.setDiachi(txdiachi.getText());
                           
                            KhachHangBUS bus = new KhachHangBUS();
                            if (!bus.update(kh)) {
                                return;
                            } else {
                                Vector row = new Vector();
                                row.add(kh.getMakh());
                                row.add(kh.getHokh());
                                row.add(kh.getTenkh());
                                row.add(kh.getSdt());
                                row.add(kh.getDiachi());
                               
                                model.removeRow(i);
                                model.insertRow(i, row);
                                table.setModel(model);
                                KhachHangBUS khbus = new KhachHangBUS();
                                txmakh.setText(khbus.Khtieptheo());
                                txho.setText("");
                                txten.setText("");
                               
                                txsdt.setText("");
                                txdiachi.setText("");
                                
                                txmakh.setEditable(true);
                                change = 0;
                                them.setEnabled(true);
                                xoa.setEnabled(true);

                                ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
                                sua.setIcon(hinhsua);
                                change = 0;
                            }
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, e.toString());
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng");
                    }

                }

            }
        });
        
       

        this.add(lbtop);
        this.add(lbinfokh);
        this.add(lbmakh);
        this.add(txmakh);
        this.add(lbho);
        this.add(txho);
        this.add(lbten);
        this.add(txten);
        this.add(lbsdt);
        this.add(txsdt);
        this.add(lbdiachi);
        this.add(txdiachi);
        
        this.add(them);
        this.add(xoa);
        this.add(sua);
        this.add(reset);
        this.add(bangsp);

        //Tim kiếm
        cb.addActionListener((ActionEvent e) -> {
            choice = cb.getSelectedIndex();
        });

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        txtimkiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", choice));
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", choice));
                }
            }

            @Override

            public void changedUpdate(DocumentEvent e) {

            }
        });
        //this.repaint();
        this.setVisible(true);
    }
    
    /*public static void main(String[] args) {
        {
           
            KhachHangGUI a=new KhachHangGUI();
            //a.setVisible(true);
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
            
        }
    }*/
}


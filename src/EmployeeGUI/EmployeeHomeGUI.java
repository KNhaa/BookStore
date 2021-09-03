/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeGUI;

import javax.swing.JPanel;
import BUS.NhanVienBUS;
//import BUS.UserBUS;
import DTO.NhanVienDTO;
//import DTO.UserDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
/**
 *
 * @author DELL
 */
public class EmployeeHomeGUI extends JPanel{
   JLabel lbtop, lbexit, lbavatar, hinhavatar;
    JButton exit;
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
    
    JLabel lbcanhan;
    JLabel lbmanv,lbsdt,lbho,lbten,lbdiachi,lbluong;
    JTextField txmanv, txsdt, txho,txten,txdiachi,txluong;
    //Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    Border borderinput = BorderFactory.createLineBorder(new Color(31,73,91), 2);
    
    //JLabel lbtaikhoan;
    //JLabel lbid,lbpass,lbnewpass,lbrepass;
    //JTextField txid;
    //JPasswordField pass,newpass,repass;
    //JButton xacnhan;
    
    public EmployeeHomeGUI(String id)
    {
        this.setLayout(null);
        this.setSize(950, 700);
        this.setBorder(border);
        //this.setBackground(new Color(33, 33, 33));
        this.setBackground(new Color(237,241,255));
        
        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);
        
//        lbexit = new JLabel();
//        lbexit.setBackground(new Color(33, 33, 33));
//        lbexit.setBounds(1170, 0, 180, 35);
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

//        lbexit.add(exit);
//        lbtop.add(lbexit);
        lbexit.add(exit);
        lbtop.add(lbexit);        
        
        lbcanhan = new JLabel("THÔNG TIN CÁ NHÂN");
        lbcanhan.setBounds(30, 80, 400, 60);
        lbcanhan.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lbcanhan.setForeground(new Color(33,33,33));
        
        lbmanv = new JLabel("Mã NV: ", JLabel.LEFT);
        lbmanv.setBounds(30, 155, 120, 50);
        lbmanv.setFont(font1);
        lbmanv.setForeground(new Color(33, 33, 33));
        txmanv = new JTextField(18);
        txmanv.setFont(font);
        txmanv.setBounds(160, 165, 180, 30);
        txmanv.setBorder(border);
        txmanv.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txmanv.setBounds(155, 160, 200, 40);
                txmanv.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txmanv.setBorder(bordernull);
                if (txmanv.getText().equals("")) {
                    txmanv.setBounds(160, 165, 180, 30);
                } else {
                    txmanv.setBounds(155, 160, 200, 40);
                }
            }
        });
        
        lbsdt = new JLabel("SĐT: ", JLabel.LEFT);
        lbsdt.setBounds(30, 225, 120, 50);       
        lbsdt.setFont(font1);
        lbsdt.setForeground(new Color(33, 33, 33));
        txsdt = new JTextField(18);
        txsdt.setFont(font);
        txsdt.setBounds(160, 235, 180, 30);
        txsdt.setBorder(border);
        txsdt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txsdt.setBounds(155, 230, 200, 40);
               txsdt.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txsdt.setBorder(bordernull);
                if (txsdt.getText().equals("")) {
                    txsdt.setBounds(160, 235, 180, 30);
                } else {
                    txsdt.setBounds(155, 230, 200, 40);
                }
            }
        });
        
        lbho = new JLabel("Họ: ", JLabel.LEFT);
        lbho.setBounds(390, 155, 120, 50);
        lbho.setFont(font1);
        lbho.setForeground(new Color(33, 33, 33));
        txho = new JTextField(18);
        txho.setFont(font);
        txho.setBounds(520, 165, 180, 30);
        txho.setBorder(border);
        txho.setEditable(false);
        txho.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txho.setBounds(515, 160, 200, 40);
                txho.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txho.setBorder(bordernull);
                if (txho.getText().equals("")) {
                    txho.setBounds(520, 165, 180, 30);
                } else {
                    txho.setBounds(515, 160, 200, 40);
                }
            }
        });
        
        lbten = new JLabel("Tên: ", JLabel.LEFT);
        lbten.setBounds(390, 225, 120, 50);
        lbten.setFont(font1);
        lbten.setForeground(new Color(33, 33, 33));
        txten = new JTextField(18);
        txten.setFont(font);
        txten.setBounds(520, 235, 180, 30);
        txten.setBorder(border);
        txten.setEditable(false);
        txten.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txten.setBounds(515, 230, 200, 40);
                txten.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txten.setBorder(bordernull);
                if (txten.getText().equals("")) {
                    txten.setBounds(520, 235, 180, 30);
                } else {
                    txten.setBounds(515, 230, 200, 40);
                }
            }
        });
                    
        
        lbluong = new JLabel("Lương: ", JLabel.LEFT);
        lbluong.setBounds(30, 295, 120, 50);
        lbluong.setFont(font1);
        lbluong.setForeground(new Color(33, 33, 33));
        txluong = new JTextField(18);
        txluong.setFont(font);
        txluong.setBounds(160, 305, 400, 30);
        txluong.setBorder(border);
        txluong.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txluong.setBounds(160, 300, 400, 30);
                txluong.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txluong.setBorder(bordernull);
                if (txluong.getText().equals("")) {
                    txluong.setBounds(160, 305, 400, 30);
                } else {
                    txluong.setBounds(1035, 300, 200, 40);
                }
            }
        });
        
        lbdiachi = new JLabel("Địa chỉ :", JLabel.LEFT);
        lbdiachi.setBounds(30, 365, 120, 50);
        lbdiachi.setFont(font1);
        lbdiachi.setForeground(new Color(33, 33, 33));
        txdiachi = new JTextField(18);
        txdiachi.setFont(font);       
        txdiachi.setBounds(160, 375, 400, 30);
        txdiachi.setBorder(border);
        txdiachi.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txdiachi.setBounds(155, 370, 400, 40);
                txdiachi.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txdiachi.setBorder(bordernull);
                if (txdiachi.getText().equals("")) {
                    txdiachi.setBounds(160, 375, 400, 30);
                } else {
                    txdiachi.setBounds(155, 370, 400, 40);
                }
            }
        });
        
        this.add(lbtop);
        
        this.add(lbcanhan);
        this.add(lbmanv); this.add(txmanv);
        this.add(lbsdt); this.add(txsdt);
        this.add(lbho); this.add(txho);
        this.add(lbten); this.add(txten);    
        this.add(lbluong); this.add(txluong);
        this.add(lbdiachi); this.add(txdiachi);           
        setEvent(id);
    }
    public void setEvent (String id)
    {   
        NhanVienBUS busnv = new NhanVienBUS();
        busnv.readDSNV();
        NhanVienDTO nv = new NhanVienDTO();
        for(NhanVienDTO temp: NhanVienBUS.dsnv)
        {
            if(temp.getManv().equals(id))
                nv = temp;               
        }
        
        txmanv.setText(nv.getManv());
        txmanv.setEditable(false);
        
        txsdt.setText(nv.getSdt());
        txsdt.setEditable(false);       
        txho.setText(nv.getHonv());
        txho.setEditable(false);       
        txten.setText(nv.getTennv());        
        txdiachi.setText(nv.getDiachi());
        txdiachi.setEditable(false);       
        txluong.setText(String.valueOf(nv.getLuong()));
        txluong.setEditable(false);       
        txmanv.setText(nv.getManv());
        txmanv.setEditable(false);
             
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author DELL
 */
public class AdminHomeGUI extends Panel{
    JLabel lbtop, lbexit, lbinfo, avatar;
    JPanel panel;
    JButton exit;
    public AdminHomeGUI()
    {
        this.setLayout(null);
        this.setSize(950, 700);      
        this.setBackground(new Color(237,241,255));
        
        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);
        
        lbexit = new JLabel();
        lbexit.setBackground(new Color(33,33,33));
        lbexit.setBounds(770, 0, 180, 35);

        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        exit = new JButton();
        exit.setBounds(120, 0, 60, 35);
        exit.setBackground(new Color(30, 30, 30));
        exit.setIcon(hinhexit);       
        exit.setFocusPainted(false);
        exit.setHorizontalTextPosition(SwingConstants.LEFT);
        exit.addMouseListener(new MouseListener() {
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
        
        lbinfo = new JLabel("TIỆM SÁCH ABC");
        lbinfo.setBounds(300, 80, 400, 60);
        lbinfo.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lbinfo.setForeground(new Color(31,73,91));
        
        panel = new JPanel();
        panel.setBounds(20, 150, 900, 500);
        panel.setBackground(new Color(237,241,255));
        panel.setLayout(null);
        
        ImageIcon iconsp = new ImageIcon("src/HinhAnh/books.png");
        avatar = new JLabel(iconsp, JLabel.CENTER);
        avatar.setBounds(0, 10, 890, 490);
        panel.add(avatar);
        
        this.add(lbtop);
        this.add(lbinfo);
        this.add(panel);
    }
}

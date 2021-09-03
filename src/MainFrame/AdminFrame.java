package MainFrame;

import AdminGUI.AdminHomeGUI;
import AdminGUI.HoaDonGUI;
import AdminGUI.KhachHangGUI;
import AdminGUI.NhanVienGUI;
import AdminGUI.PhieuNhapGUI;
import AdminGUI.SachGUI;
import AdminGUI.TacGiaGUI;
import AdminGUI.TaiKhoanGUI;
import ThongKeGUI.ThongKeAGUI;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminFrame extends JFrame {

    DefaultTableModel model;
    JPanel pn1, pntop, pnleft, pnsanpham;
    JPanel pncontent;
    JLabel lbsanpham, lbhoadon, lbkhachhang, lbtacgia, lbthoat, lbhome, lbthongke, /*lbthongke_hid,*/ lbpnh, 
    /*lbkm, lbkm_hid,*/ lbnhanvien,lbsetting,lbsetting_hid,lbabc, lbdangxuat,/*lbtheme,*/ lbacc, lbqltk, patt; /*tka, tkb;*/
    JLabel hinhhome, hinhsp, hinhkh, hinhhd, hinhbh, hinhtk, hinhpnh, /*hinhkm,*/ hinhnhanvien, hinhdangxuat,hinhtheme, hinhqltk,hinhsetting,hinhsetting_hid,ba_cham/*, kmthuong, kmdip*/;
    JPanel c1, c2, c3, c4, c5, c6, /*c7,*/ c8, c9,c10,c11;
    JButton exit;
    SachGUI spGUI;
    //Color color_background =new Color(18, 18, 18);
    Color color_background =new Color(31,73,91);
    Color color_font_hover=new Color(179, 179, 179);
    Color color_font_no_hover=new Color(255, 255, 255);
    Color color_part=new Color(30, 215, 96); //maudo

    Border border = BorderFactory.createLineBorder(color_background);
    Border nullborder = BorderFactory.createLineBorder(null);
    Image bg;
    Font font= new Font("Segoe UI", Font.BOLD, 20);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
    public AdminFrame() {
        ImageIcon img = new ImageIcon("src/HinhAnh/employee.png");
        this.setIconImage(img.getImage());
        this.setUndecorated(true);
        //this.setSize(1600, 945);
        this.setSize(1200,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void ShowBang() {
        // Panel left
        pnleft = new JPanel();        
        pnleft.setBounds(0, 0, 250, 700);
        pnleft.setBackground(color_background); //18,18,18( tím)
        pnleft.setLayout(null);

        ImageIcon imghome = new ImageIcon(getClass().getResource("/HinhAnh/hinhhome.png"));
        ImageIcon imghomef = new ImageIcon(getClass().getResource("/HinhAnh/hinhhomef.png"));
        ImageIcon imgsp = new ImageIcon(getClass().getResource("/HinhAnh/sanpham.png"));
        ImageIcon imgspf = new ImageIcon(getClass().getResource("/HinhAnh/sanphamf.png"));
        ImageIcon imgkh = new ImageIcon(getClass().getResource("/HinhAnh/khachhang.png"));
        ImageIcon imgkhf = new ImageIcon(getClass().getResource("/HinhAnh/khachhangf.png"));
        ImageIcon imghoadon = new ImageIcon(getClass().getResource("/HinhAnh/hoadon.png"));
        ImageIcon imghoadonf = new ImageIcon(getClass().getResource("/HinhAnh/hoadonf.png"));
        ImageIcon imgbaohanh = new ImageIcon(getClass().getResource("/HinhAnh/baohanh.png"));
        ImageIcon imgbaohanhf = new ImageIcon(getClass().getResource("/HinhAnh/baohanhf.png"));
        ImageIcon imgpnh = new ImageIcon(getClass().getResource("/HinhAnh/pnh.png"));
        ImageIcon imgpnhf = new ImageIcon(getClass().getResource("/HinhAnh/pnhf.png"));
        ImageIcon imgkm = new ImageIcon(getClass().getResource("/HinhAnh/km.png"));
        ImageIcon imgkmf = new ImageIcon(getClass().getResource("/HinhAnh/kmf.png"));
        ImageIcon imgnhanvien = new ImageIcon(getClass().getResource("/HinhAnh/nhanvien.png"));
        ImageIcon imgnhanvienf = new ImageIcon(getClass().getResource("/HinhAnh/nhanvienf.png"));
        ImageIcon imgthongke = new ImageIcon(getClass().getResource("/HinhAnh/thongke.png"));
        ImageIcon imgthongkef = new ImageIcon(getClass().getResource("/HinhAnh/thongkef.png"));
        ImageIcon imgdangxuat = new ImageIcon(getClass().getResource("/HinhAnh/dangxuat.png"));
        ImageIcon imgdangxuatf = new ImageIcon(getClass().getResource("/HinhAnh/dangxuatf.png"));
        ImageIcon imgqltk = new ImageIcon(getClass().getResource("/HinhAnh/qltk.png"));
        ImageIcon imgqltkf = new ImageIcon(getClass().getResource("/HinhAnh/qltkf.png"));
        ImageIcon imgsetting = new ImageIcon(getClass().getResource("/HinhAnh/setting.png"));
        ImageIcon imgsettingf = new ImageIcon(getClass().getResource("/HinhAnh/settingf.png"));   
        ImageIcon imgtheme = new ImageIcon(getClass().getResource("/HinhAnh/theme.png")); 
        ImageIcon imgthemef = new ImageIcon(getClass().getResource("/HinhAnh/themef.png")); 
        ImageIcon hinh3dot = new ImageIcon(getClass().getResource("/HinhAnh/3dot.png"));

        
        pntop = new JPanel();
        pntop.setBounds(250,0, 950, 65);
        pntop.setOpaque(true);
        pntop.setLayout(null);
        
     
        lbthoat = new JLabel();
        lbthoat.setBackground(new Color(33,33,33));
        lbthoat.setBackground(Color.CYAN);
        lbthoat.setBounds(770, 0, 180, 35);
        
        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        exit = new JButton();
        exit.setBounds(120, 0, 60, 35);
        exit.setBackground(new Color(30, 30, 30));
        exit.setIcon(hinhexit);
        exit.setBorder(null);
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

        lbthoat.add(exit);
        pntop.add(lbthoat);
    
        hinhtheme = new JLabel();
        hinhtheme.setBounds(20,780, 40, 40);
        hinhtheme.setBackground(color_background);
        hinhtheme.setIcon(imgtheme);
        hinhtheme.setOpaque(true);
        hinhtheme.setVisible(false);
        
        hinhqltk = new JLabel();
        hinhqltk.setBounds(20,730, 40, 40);
        hinhqltk.setBackground(color_background);
        hinhqltk.setIcon(imgqltk);
        hinhqltk.setOpaque(true);
        hinhqltk.setVisible(false);

        lbqltk = new JLabel("Tài Khoản");
        lbqltk.setFont(font);
        lbqltk.setForeground(color_font_no_hover);
        //lbqltk.setBounds(73, 730, 200, 40);
        lbqltk.setBounds(73, 550, 200, 40);
        lbqltk.setVisible(false);
        
        hinhdangxuat = new JLabel();
        hinhdangxuat.setBounds(20, 830, 40, 40);
        hinhdangxuat.setIcon(imgdangxuat);
        hinhdangxuat.setBackground(color_background);
        hinhdangxuat.setOpaque(true);
        hinhdangxuat.setVisible(false);
        
        lbdangxuat = new JLabel("Đăng Xuất");
        lbdangxuat.setFont(font);
        lbdangxuat.setForeground(color_font_no_hover);
        //lbdangxuat.setBounds(73, 830, 200, 40);
        lbdangxuat.setBounds(73, 600, 200, 40);
        lbdangxuat.setVisible(false);

        pnleft.add(hinhtheme);
        pnleft.add(hinhqltk);
        pnleft.add(lbqltk);
        pnleft.add(hinhdangxuat);
        pnleft.add(lbdangxuat);
       
        c11 = new JPanel(); // cái | xanh xanh bên rìa trái ở menu       
        c11.setBounds(0, 650, 10, 40);
        c11.setBackground(color_background);
        hinhsetting_hid = new JLabel();
        hinhsetting_hid.setIcon(imgsetting);       
        hinhsetting_hid.setBounds(20, 650, 40, 40);
        lbsetting_hid = new JLabel("Cài đặt");
        lbsetting_hid.setForeground(color_font_no_hover);
        lbsetting_hid.setBackground(color_background);
        lbsetting_hid.setFont(new Font("Segoe UI", Font.BOLD, 20));        
        lbsetting_hid.setBounds(73, 650, 200, 40);
        lbsetting_hid.setCursor(new Cursor(HAND_CURSOR));
        lbsetting_hid.setOpaque(true);
        lbsetting_hid.setVisible(true);
        lbsetting_hid.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                lbsetting_hid.setVisible(false);
                lbsetting.setVisible(true);
                hinhqltk.setVisible(false);
                lbqltk.setVisible(false);
                hinhtheme.setVisible(false);
                //lbtheme.setVisible(false);
                hinhdangxuat.setVisible(false);
                lbdangxuat.setVisible(false);
                hinhsetting.setIcon(imgsetting);
                hinhqltk.setIcon(imgqltk);
                hinhdangxuat.setIcon(imgdangxuat);
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
      
        
        ba_cham = new JLabel(" Tiệm sách ABC");
        //ba_cham.setBounds(30, 25, 30, 30);
        ba_cham.setBounds(30, 25, 200, 30);
        ba_cham.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ba_cham.setForeground(new Color(255, 255, 255));
        ba_cham.setIcon(hinh3dot);
        this.add(ba_cham);

        c1 = new JPanel();
        c1.setBounds(0, 75, 10, 40);
        c1.setBackground(color_background);
        lbhome = new JLabel("Trang chủ");
        lbhome.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbhome.setForeground(color_font_no_hover);
        lbhome.setBackground(color_background);
        hinhhome = new JLabel();
        hinhhome.setIcon(imghome);
        hinhhome.setBounds(20, 75, 40, 40);
        lbhome.setBounds(73, 75, 200, 40);
        lbhome.setCursor(new Cursor(HAND_CURSOR));
        lbhome.setOpaque(true);
        lbhome.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pncontent.removeAll();
                //pncontent.setBounds(250, 65, 1350, 945);
                pncontent.setBounds(250, 0, 950, 700);
                pncontent.add(new AdminHomeGUI());
                pncontent.setLayout(null);
                pncontent.setBorder(null);                

                c1.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c8.setBackground(color_background);
                c9.setBackground(color_background);

                hinhhome.setIcon(imghomef);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhtk.setIcon(imgthongke);

                lbhome.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);


                c8.setBounds(0, 375, 10, 40);             
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);
               
                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbhome.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbhome.setForeground(color_font_no_hover);
            }

        });

        c2 = new JPanel();
        c2.setBounds(0, 125, 10, 40);
        c2.setBackground(color_background);
        hinhsp = new JLabel();
        hinhsp.setIcon(imgsp);
        hinhsp.setBounds(20, 125, 40, 40);
        lbsanpham = new JLabel("Sản Phẩm");
        lbsanpham.setForeground(color_font_no_hover);
        lbsanpham.setBackground(color_background);
        lbsanpham.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbsanpham.setBounds(73, 125, 200, 40);
        lbsanpham.setCursor(new Cursor(HAND_CURSOR));
        lbsanpham.setOpaque(true);
        lbsanpham.addMouseListener(new MouseListener() {
            // SẢN PHẨM GUI
            @Override
            public void mouseClicked(MouseEvent e) {
//                SachGUI spGUI = new SachGUI();
                spGUI = new SachGUI();
                pncontent.removeAll();                
                pncontent.add(spGUI);               
                pncontent.setBounds(250, 0, 950, 700);
                pncontent.repaint();
                spGUI.revalidate();
                spGUI.repaint();
                
                 
                
                c2.setBackground(color_part);
                c1.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c8.setBackground(color_background);
                c9.setBackground(color_background);

                hinhhome.setIcon(imghome);
                hinhsp.setIcon(imgspf);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhtk.setIcon(imgthongke);

                lbsanpham.setForeground(color_font_hover);
                lbhome.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);

                
                c8.setBounds(0, 375, 10, 40);               
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);

                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);
               
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbsanpham.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbsanpham.setForeground(color_font_no_hover);
            }

        });

        c3 = new JPanel();
        c3.setBounds(0, 175, 10, 40);
        c3.setBackground(color_background);
        hinhkh = new JLabel();
        hinhkh.setIcon(imgkh);
        hinhkh.setBounds(20, 175, 40, 40);
        lbkhachhang = new JLabel("Khách Hàng");
        lbkhachhang.setForeground(color_font_no_hover);
        lbkhachhang.setBackground(color_background);
        lbkhachhang.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbkhachhang.setBounds(73, 175, 200, 40);
        lbkhachhang.setCursor(new Cursor(HAND_CURSOR));
        lbkhachhang.setOpaque(true);
        lbkhachhang.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                KhachHangGUI khGUI = new KhachHangGUI();
                pncontent.removeAll();
                pncontent.add(khGUI);
                //pncontent.setBounds(250, 0, 1350, 945);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                khGUI.revalidate();
                khGUI.repaint();

                c3.setBackground(color_part);
                c2.setBackground(color_background);
                c1.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c8.setBackground(color_background);
                c9.setBackground(color_background);

                hinhkh.setIcon(imgkhf);
                hinhsp.setIcon(imgsp);
                hinhhome.setIcon(imghome);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhtk.setIcon(imgthongke);

                lbkhachhang.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);
                
                c8.setBounds(0, 375, 10, 40);               
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);
                
                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);               
                hinhtk.setBounds(20, 425, 40, 40);               
                lbthongke.setBounds(73, 425, 200, 40);
                //lbthongke_hid.setBounds(73, 425, 200, 40);
              
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbkhachhang.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbkhachhang.setForeground(color_font_no_hover);
            }
        });
        
        
        c4 = new JPanel();
        c4.setBounds(0, 225, 10, 40);
        c4.setBackground(color_background);
        hinhhd = new JLabel();
        hinhhd.setIcon(imghoadon);
        hinhhd.setBounds(20, 225, 40, 40);
        lbhoadon = new JLabel("Hóa Đơn");
        lbhoadon.setForeground(color_font_no_hover);
        lbhoadon.setBackground(color_background);
        lbhoadon.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbhoadon.setBounds(73, 225, 200, 40);
        lbhoadon.setCursor(new Cursor(HAND_CURSOR));
        lbhoadon.setOpaque(true);
        lbhoadon.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                HoaDonGUI hdGUI = new HoaDonGUI();
                pncontent.removeAll();
                pncontent.add(hdGUI);
                //pncontent.setBounds(250, 0, 1350, 945);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                hdGUI.revalidate();
                hdGUI.repaint();

                c4.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c1.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c8.setBackground(color_background);
                c9.setBackground(color_background);

                hinhhd.setIcon(imghoadonf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhome.setIcon(imghome);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhtk.setIcon(imgthongke);

                lbhoadon.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);

                
                c8.setBounds(0, 375, 10, 40);               
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);

                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);               
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbhoadon.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbhoadon.setForeground(color_font_no_hover);
            }
        });

        c5 = new JPanel();
        c5.setBounds(0, 275, 10, 40);
        c5.setBackground(color_background);
        hinhbh = new JLabel();
        hinhbh.setIcon(imgbaohanh);
        hinhbh.setBounds(20, 275, 40, 40);
        lbtacgia = new JLabel("Tác giả");
        lbtacgia.setForeground(color_font_no_hover);
        lbtacgia.setBackground(color_background);
        lbtacgia.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbtacgia.setBounds(73, 275, 200, 40);
        lbtacgia.setCursor(new Cursor(HAND_CURSOR));
        lbtacgia.setOpaque(true);
        lbtacgia.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TacGiaGUI tgGUI = new TacGiaGUI();
                pncontent.removeAll();
                pncontent.add(tgGUI);
                //pncontent.setBounds(250, 0, 1350, 945);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                tgGUI.revalidate();
                tgGUI.repaint();
               

                c5.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c1.setBackground(color_background);
                c6.setBackground(color_background);
                c8.setBackground(color_background);
                c9.setBackground(color_background);

                hinhbh.setIcon(imgbaohanhf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhhome.setIcon(imghome);
                hinhpnh.setIcon(imgpnh);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhtk.setIcon(imgthongke);

                lbtacgia.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);
              
                c8.setBounds(0, 375, 10, 40);               
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);
               
                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);
              
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbtacgia.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbtacgia.setForeground(color_font_no_hover);
            }
        });

        c6 = new JPanel();
        c6.setBounds(0, 325, 10, 40);
        c6.setBackground(color_background);
        hinhpnh = new JLabel();
        hinhpnh.setIcon(imgpnh);
        hinhpnh.setBounds(20, 325, 40, 40);
        lbpnh = new JLabel("Nhập Hàng");
        lbpnh.setForeground(color_font_no_hover);
        lbpnh.setBackground(color_background);
        lbpnh.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbpnh.setBounds(73, 325, 200, 40);
        lbpnh.setCursor(new Cursor(HAND_CURSOR));
        lbpnh.setOpaque(true);
        lbpnh.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                PhieuNhapGUI pnhGUI = new PhieuNhapGUI();
                pncontent.removeAll();
                pncontent.add(pnhGUI);
                //pncontent.setBounds(250, 0, 1350, 945);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                pnhGUI.revalidate();
                pnhGUI.repaint();
                
                c6.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c1.setBackground(color_background);
                c8.setBackground(color_background);
                c9.setBackground(color_background);

                hinhpnh.setIcon(imgpnhf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhtk.setIcon(imgthongke);

                lbpnh.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);
               
                c8.setBounds(0, 375, 10, 40);              
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);

                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbpnh.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbpnh.setForeground(color_font_no_hover);
            }
        });
       
        c8 = new JPanel();
        c8.setBounds(0, 375, 10, 40);
        c8.setBackground(color_background);
        hinhnhanvien = new JLabel();
        hinhnhanvien.setIcon(imgnhanvien);
        hinhnhanvien.setBounds(20, 375, 40, 40);
        lbnhanvien = new JLabel("Nhân Viên");
        lbnhanvien.setForeground(color_font_no_hover);
        lbnhanvien.setBackground(color_background);
        lbnhanvien.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbnhanvien.setBounds(73, 375, 200, 40);
        lbnhanvien.setCursor(new Cursor(HAND_CURSOR));
        lbnhanvien.setOpaque(true);
        lbnhanvien.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVienGUI nvGUI = new NhanVienGUI();
                pncontent.removeAll();
                pncontent.add(nvGUI);
                //pncontent.setBounds(250, 0, 1350, 945);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                nvGUI.revalidate();
                nvGUI.repaint();
                
                c8.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c1.setBackground(color_background);
                c9.setBackground(color_background);

                hinhnhanvien.setIcon(imgnhanvienf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);
                hinhhome.setIcon(imghome);
                hinhtk.setIcon(imgthongke);

                lbnhanvien.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbthongke.setForeground(color_font_no_hover);
               
                c8.setBounds(0, 375, 10, 40);               
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);

                c9.setBounds(0, 425, 10, 40);
                hinhtk.setIcon(imgthongke);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);
              
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbnhanvien.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbnhanvien.setForeground(color_font_no_hover);
            }
        });

        c9 = new JPanel();
        c9.setBounds(0, 425, 10, 40);
        c9.setBackground(color_background);
        hinhtk = new JLabel();
        hinhtk.setIcon(imgthongke);
        hinhtk.setBounds(20, 425, 40, 40);
        lbthongke = new JLabel("Thống Kê");
        lbthongke.setForeground(color_font_no_hover);
        lbthongke.setBackground(color_background);
        lbthongke.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbthongke.setBounds(73, 425, 200, 40);
        lbthongke.setCursor(new Cursor(HAND_CURSOR));
        lbthongke.setOpaque(true);
        lbthongke.setVisible(true);
        lbthongke.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //lbthongke.setVisible(false);
                ThongKeAGUI tkaGUI = new ThongKeAGUI();
                pncontent.removeAll();
                pncontent.add(tkaGUI);               
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                tkaGUI.revalidate();
                tkaGUI.repaint();
                
                c9.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c8.setBackground(color_background);
                c1.setBackground(color_background);

                hinhtk.setIcon(imgthongkef);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);
                hinhnhanvien.setIcon(imgnhanvien);
                hinhhome.setIcon(imghome);

                lbthongke.setForeground(color_font_hover);
                lbsanpham.setForeground(color_font_no_hover);
                lbkhachhang.setForeground(color_font_no_hover);
                lbtacgia.setForeground(color_font_no_hover);
                lbhoadon.setForeground(color_font_no_hover);
                lbpnh.setForeground(color_font_no_hover);
                lbnhanvien.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
            
                c8.setBounds(0, 375, 10, 40);                
                hinhnhanvien.setBounds(20, 375, 40, 40);
                lbnhanvien.setBounds(73, 375, 200, 40);

                c9.setBounds(0, 425, 10, 40);
                hinhtk.setBounds(20, 425, 40, 40);
                lbthongke.setBounds(73, 425, 200, 40);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbthongke.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbthongke.setForeground(color_font_no_hover);
            }
        });

        c10 = new JPanel();
        c10.setBounds(0, 890, 10, 40);
        c10.setBackground(color_background);
        hinhsetting = new JLabel();
        hinhsetting.setIcon(imgsetting);
        hinhsetting.setBounds(20, 650, 40, 40);
        lbsetting = new JLabel("Cài đặt");
        lbsetting.setForeground(color_font_no_hover);
        lbsetting.setBackground(color_background);
        lbsetting.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbsetting.setBounds(73, 650, 200, 40);
        lbsetting.setCursor(new Cursor(HAND_CURSOR));
        lbsetting.setOpaque(true);
        lbsetting.setVisible(true);   
        lbsetting.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbsetting.setVisible(false);
                lbsetting_hid.setVisible(true);
                hinhqltk.setVisible(true);
                lbqltk.setVisible(true);
                hinhtheme.setVisible(true);
                hinhdangxuat.setVisible(true);
                lbdangxuat.setVisible(true);
                hinhsetting.setIcon(imgsettingf);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
               lbsetting.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbsetting.setForeground(color_font_no_hover);
            }

        });
        
        lbdangxuat.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                hinhqltk.setIcon(imgqltk);
                hinhdangxuat.setIcon(imgdangxuatf);
                Dangxuat();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbdangxuat.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbdangxuat.setForeground(color_font_no_hover);
            }
        });
        lbqltk.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TaiKhoanGUI user = new TaiKhoanGUI();
                pncontent.removeAll();
                pncontent.add(user);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                user.revalidate();
                user.repaint();
                hinhqltk.setIcon(imgqltkf);
                hinhdangxuat.setIcon(imgdangxuat);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbqltk.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbqltk.setForeground(color_font_no_hover);
            }
        });
        
        pnleft.add(hinhhome);
        pnleft.add(c1);
        pnleft.add(hinhsp);
        pnleft.add(c2);
        pnleft.add(hinhkh);
        pnleft.add(c3);
        pnleft.add(hinhhd);
        pnleft.add(c4);
        pnleft.add(hinhbh);
        pnleft.add(c5);
        pnleft.add(hinhpnh);
        pnleft.add(c6);       
        pnleft.add(hinhnhanvien);
        pnleft.add(c8);
        pnleft.add(hinhtk);
        pnleft.add(c9);
        pnleft.add(c10);
        pnleft.add(hinhsetting);

        pnleft.add(lbhome);
        pnleft.add(lbsanpham);
        pnleft.add(lbkhachhang);
        pnleft.add(lbhoadon);
        pnleft.add(lbtacgia);
        pnleft.add(lbpnh);
        pnleft.add(lbnhanvien);
        pnleft.add(lbthongke);
        pnleft.add(lbsetting);
        pnleft.add(lbsetting_hid);
        this.add(pnleft);

        pncontent = new JPanel();
        pncontent.setBounds(250, 0, 950, 700);
        pncontent.setLayout(null);
        pncontent.setBorder(null);
        pncontent.add(new AdminHomeGUI()); 
        this.add(pncontent);
        this.repaint();
        this.setVisible(true);
        
             
    }
    
    public void Dangxuat()
    {
        LoginFrame temp = new LoginFrame();
                temp.ShowBang();
                this.setVisible(false);
    }
    
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel( "com.seaglasslookandfeel.SeaGlassLookAndFeel" );
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
        AdminFrame test = new AdminFrame();
            test.ShowBang();
    }
}


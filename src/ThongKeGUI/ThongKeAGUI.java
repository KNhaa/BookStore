/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKeGUI;

import BUS.HoaDonTKBUS;
import BUS.KhachHangTKBUS;
import BUS.NhanVienTKBUS;
import BUS.SachTKBUS;
import ThongKeGUI.ThongKeHDGUI;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/**
 *
 * @author acer
 */
public class ThongKeAGUI extends JPanel {

    //Phần top
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    JLabel lbtop, lbexit, lbavatar, hinhavatar;
    JButton thunho, phongto, exit;
    Border bordernull = BorderFactory.createEmptyBorder();

    //Phần content trên
    TitledBorder ttcontent1 = new TitledBorder("ABCDXYZ");
    Border bordertt = BorderFactory.createLineBorder(new Color(235, 235, 235), 1);
    Border bordertk = BorderFactory.createLineBorder(new Color(30, 30, 30), 1);
    JPanel pntongsp, pntongnv, pntongkh, pndoanhthu;
    JLabel lbtongsp, lbtongnv, lbtongkh, lbtongdoanhthu;
    JLabel icon1, icon2, icon3, icon4;
    JLabel solieutongsp, solieutongnv, solieutongkh, solieutongdoanhthu;
    JPanel content1;
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font font = new Font("Segoe UI", Font.BOLD, 22);

    JPanel panelsp;

    //Phần content chính
//    TitledBorder ttcontent2 = new TitledBorder("Tiêu đề 2");
//    JPanel content2;
//    JTable table;
//    DefaultTableModel model;
//    JLabel timkiemnc;
//    JComboBox cbtheo;
//    JComboBox cbthang;
//    JComboBox cbmua;
//    JComboBox cbnam;
//    JButton timkiem;
//    JTextField txtimkiem;
//    JLabel hienthi;
//    JComboBox cbhienthi;
    public ThongKeAGUI() {
        this.setSize(1350, 945);
        this.setLayout(null);
        this.setSize(1350, 945);
        this.setBorder(border);
        this.setBackground(new Color(33, 33, 33));
        //this.setBackground(new Color(237,241,255));
        this.setView();
    }

    public void setView() {
        //GIAO DIỆN TOP START
        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 1350, 65);
        lbtop.setBackground(new Color(18, 18, 18));
        lbtop.setOpaque(true);

        lbexit = new JLabel();
        lbexit.setBackground(new Color(33, 33, 33));
        //lbexit.setBounds(1170, 0, 180, 35);
        lbexit.setBounds(770, 0, 180, 35);

       
        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        exit = new JButton();
        exit.setBounds(120, 0, 60, 35);
        exit.setBackground(new Color(30, 30, 30));
        exit.setIcon(hinhexit);
        exit.setBorder(bordernull);
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
        this.add(lbtop);
        //GIAO DIỆN TOP END 

        //CONTENT 1 START
        content1 = new JPanel();
        content1.setBounds(25, 80, 1300, 200);
        content1.setBackground(new Color(33, 33, 33));
        content1.setLayout(null);
        //content1.setBorder(ttcontent1);
        ttcontent1.setBorder(bordertt);
        ttcontent1.setTitleJustification(TitledBorder.LEFT);
        ttcontent1.setTitlePosition(TitledBorder.TOP);
        ttcontent1.setTitleColor(new Color(255, 255, 255));
        ttcontent1.setTitleFont(fontt);

        pntongsp = new JPanel();
        pntongsp.setBounds(20, 30, 200, 150);
        pntongsp.setBackground(new Color(235, 235, 235));
        pntongsp.setLayout(null);
        pntongsp.setBorder(bordertk);
        pntongsp.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panelsp.removeAll();
                panelsp.add(new ThongKeSachConGUI());
                panelsp.setBounds(10, 300, 930, 400);
                panelsp.repaint();
                panelsp.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pntongsp.setBackground(new Color(134, 174, 195));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pntongsp.setBackground(new Color(235, 235, 235));
            }
        });

        

        ImageIcon iconsp = new ImageIcon("src/HinhAnh/thongkesp.png");
        icon1 = new JLabel(iconsp, JLabel.CENTER);
        icon1.setBounds(0, 20, 100, 150);
        lbtongsp = new JLabel("Tổng sản phẩm", JLabel.CENTER);       
        lbtongsp.setBounds(0, 0, 200, 75);   
        lbtongsp.setFont(font);
        solieutongsp = new JLabel("50", JLabel.CENTER);
        solieutongsp.setBounds(40, 75, 200, 75);   
        solieutongsp.setFont(font);

        pntongsp.add(icon1);
        pntongsp.add(lbtongsp);
        pntongsp.add(solieutongsp);

        pntongnv = new JPanel();
        //pntongnv.setBounds(340, 30, 300, 150);       
        pntongnv.setBounds(230, 30, 200, 150);
        pntongnv.setBackground(new Color(235, 235, 235));
        pntongnv.setLayout(null);
        pntongnv.setBorder(bordertk);
        pntongnv.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panelsp.removeAll();
                panelsp.add(new ThongKeNVGUI());
                panelsp.setBounds(10, 300, 930, 600);
                panelsp.repaint();
                panelsp.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pntongnv.setBackground(new Color(134, 174, 195));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pntongnv.setBackground(new Color(235, 235, 235));
            }
        });
        ImageIcon iconnv = new ImageIcon("src/HinhAnh/thongkenv.png");
        icon2 = new JLabel(iconnv, JLabel.CENTER);
        icon2.setBounds(0, 20, 100, 150);
        lbtongnv = new JLabel("Tổng Nhân Viên", JLabel.CENTER);
        lbtongnv.setBounds(0, 0, 200, 75);
        lbtongnv.setFont(font);
        solieutongnv = new JLabel("50", JLabel.CENTER);       
        solieutongnv.setBounds(40, 75, 200, 75);
        solieutongnv.setFont(font);

        pntongnv.add(icon2);
        pntongnv.add(lbtongnv);
        pntongnv.add(solieutongnv);

        pntongkh = new JPanel();        
        pntongkh.setBounds(440, 30, 200, 150);
        pntongkh.setBackground(new Color(235, 235, 235));
        pntongkh.setLayout(null);
        pntongkh.setBorder(bordertk);
        pntongkh.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panelsp.removeAll();
                panelsp.add(new ThongKeKHGUI());
                panelsp.setBounds(10, 300, 930, 600);
                panelsp.repaint();
                panelsp.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pntongkh.setBackground(new Color(134, 174, 195));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pntongkh.setBackground(new Color(235, 235, 235));
            }
        });
        ImageIcon iconkh = new ImageIcon("src/HinhAnh/thongkekh.png");
        icon3 = new JLabel(iconkh, JLabel.CENTER);
        icon3.setBounds(0, 20, 100, 150);
        lbtongkh = new JLabel("Tổng Khách Hàng", JLabel.CENTER);
        lbtongkh.setBounds(0, 0, 200, 75);
        lbtongkh.setFont(font);
        solieutongkh = new JLabel("50", JLabel.CENTER);
        solieutongkh.setBounds(40, 75, 200, 75);
        solieutongkh.setFont(font);

        pntongkh.add(icon3);
        pntongkh.add(lbtongkh);
        pntongkh.add(solieutongkh);

        pndoanhthu = new JPanel();
        //pntongkh.setBounds(440, 30, 200, 150);
        pndoanhthu.setBounds(650, 30, 230, 150);
        pndoanhthu.setBackground(new Color(235, 235, 235));
        pndoanhthu.setLayout(null);
        pndoanhthu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panelsp.removeAll();
                panelsp.add(new ThongKeHDGUI());
                panelsp.setBounds(10, 300, 930, 400);
                panelsp.repaint();
                panelsp.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //pndoanhthu.setBackground(new Color(30, 210, 96));
                pndoanhthu.setBackground(new Color(134, 174, 195));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pndoanhthu.setBackground(new Color(235, 235, 235));
            }
        });
        pndoanhthu.setBorder(bordertk);
        ImageIcon icondt = new ImageIcon("src/HinhAnh/thongkedoanhthu.png");
        icon4 = new JLabel(icondt, JLabel.CENTER);
        icon4.setBounds(0, 20, 80, 150);
        lbtongdoanhthu = new JLabel("Tổng Doanh Thu", JLabel.CENTER);
        lbtongdoanhthu.setBounds(0, 0, 250, 75);
        lbtongdoanhthu.setFont(font);
        solieutongdoanhthu = new JLabel("12.343.200.000 đ", JLabel.CENTER);
        solieutongdoanhthu.setBounds(40, 75, 200, 75);
        solieutongdoanhthu.setFont(font);

        pndoanhthu.add(icon4);
        pndoanhthu.add(lbtongdoanhthu);
        pndoanhthu.add(solieutongdoanhthu);

        content1.add(pntongsp);
        content1.add(pntongnv);
        content1.add(pntongkh);
        content1.add(pndoanhthu);

        this.add(content1);

        panelsp = new JPanel();
        panelsp.setBounds(25, 300, 1300, 600);
        panelsp.setBackground(new Color(35, 35, 35));
        panelsp.setLayout(null);

        this.add(panelsp);
        setEvent();
        repaint();
        //revalidate();
    }

    public void setEvent() {
        SachTKBUS bussp = new SachTKBUS();
        if (SachTKBUS.dssp == null) bussp.docDSSP();
        solieutongsp.setText(String.valueOf(SachTKBUS.dssp.size()));
        
        NhanVienTKBUS busnv = new NhanVienTKBUS();
        if (NhanVienTKBUS.dsnv == null) busnv.readDSNV();
        solieutongnv.setText(String.valueOf(NhanVienTKBUS.dsnv.size()));
        
        KhachHangTKBUS buskh = new KhachHangTKBUS();
        if (KhachHangTKBUS.dskh == null) buskh.readDSKH();
        solieutongkh.setText(String.valueOf(KhachHangTKBUS.dskh.size()));        
        HoaDonTKBUS bushd = new HoaDonTKBUS();
        if(HoaDonTKBUS.dshd == null) bushd.docDSHD();
        solieutongdoanhthu.setText(Chuyentien(String.valueOf(bushd.Tonghoadon())));
    }
    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }
    public static void main(String[] args) {
        ThongKeAGUI a=new ThongKeAGUI();
            //a.setVisible(true);
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }
    
}

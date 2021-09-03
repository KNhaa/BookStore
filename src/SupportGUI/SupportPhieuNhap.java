/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import AdminGUI.PhieuNhapGUI;
import BUS.CTPhieuNhapBUS;

import BUS.PhieuNhapBUS;
import BUS.SachBUS;
import DAO.CTNhapDAO;
import DTO.CTNhapDTO;
import DTO.HoaDonDTO;
import DTO.PhieuNhapDTO;
import EmployeeGUI.NhapHangGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class SupportPhieuNhap extends JFrame {

    //thuộc tính hóa đơn
    JLabel lbmapnh, lbmancc, lbmanv, lbngaydat, lbtongtien, lbthanhtien, lbsoluongtong;
    static JTextField txmapnh, txmancc, txmanv, txngaydat, txtongtien, txthanhtien, txsoluongtong;
    JPanel pnpn, pnctpn;
    JButton dongpnh, chonnv, chonncc, xacnhan, thoat;//Nút thoát là nút hủy nha
    

    public static int tongtien = 0;
    public static int soluongtong = 0;
    int change = 0; //Tắt đóng mã hóa đơn
    //thuộc tính chi tiết hóa đơn
    JLabel lbmasp, lbten, lbdongia, lbsoluong, lbsoluongmacdinh;
    static JTextField txmasp, txten, txgianhap, txsoluong, txsoluongmacdinh;
    JButton chonsp, them, xoa, sua, reset;
    JTable table;
    DefaultTableModel model;
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fontBut = new Font("Segoe UI", Font.BOLD, 18);
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font fontinput = new Font("Segoe UI", Font.PLAIN, 17);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    ArrayList <CTNhapDTO> ctpnthem= new ArrayList <CTNhapDTO> ();

    //ArrayList <SanPhamDTO> dssphd = new ArrayList<>();
    public SupportPhieuNhap() {
        this.setUndecorated(true);
        this.setSize(1000, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
         //this.setTitle("THÊM HÓA ĐƠN");
    }

    public void setView(String id) {
        pnpn = new JPanel();
        pnpn.setBounds(50, 30, 900, 250);
        pnpn.setLayout(null);
        TitledBorder tthd = new TitledBorder("Thêm Phiếu Nhập Hàng");
        tthd.setBorder(border);
        tthd.setTitleJustification(TitledBorder.LEFT);
        tthd.setTitlePosition(TitledBorder.TOP);
        tthd.setTitleColor(new Color(249, 6, 59));
        tthd.setTitleFont(fontt);
        pnpn.setBorder(tthd);
        
        

        //Trái ( thông tin mã )
        lbmapnh = new JLabel("Mã PNH :");
        lbmapnh.setBounds(20, 50, 90, 18);
        lbmapnh.setFont(font);

        lbmancc = new JLabel("Mã NCC :");
        lbmancc.setBounds(20, 100, 80, 18);
        lbmancc.setFont(font);
        lbmanv = new JLabel("Mã NV :");
        lbmanv.setBounds(20, 150, 80, 18);
        lbmanv.setFont(font);
//        lbsltong = new JLabel("SL Tổng :");
//        lbsltong.setBounds(20, 200, 80, 22);
//        lbsltong.setFont(font);

        txmapnh = new JTextField();
        txmapnh.setBounds(100, 45, 150, 30);
        txmapnh.setFont(fontinput);
        txmapnh.setEditable(false);
        txmancc = new JTextField();
        txmancc.setBounds(100, 95, 150, 30);
        txmancc.setFont(fontinput);
        txmancc.setEditable(false);
        txmanv = new JTextField();
        txmanv.setBounds(100, 145, 150, 30);
        txmanv.setFont(fontinput);
        txmanv.setEditable(false);
        if (id.equals("Manager")) {
        } else {
            txmanv.setText(id);
        }
//        txsltong = new JTextField();
//        txsltong.setBounds(100, 195, 150, 30);
//        txsltong.setFont(fontinput);
//        txsltong.setEditable(false);

        dongpnh = new JButton("...");
        dongpnh.setBackground(new Color(30, 215, 96));
        dongpnh.setForeground(new Color(255, 255, 255));
        dongpnh.setBounds(270, 45, 40, 30);
        dongpnh.setFont(fontBut);
        chonncc = new JButton("...");
        chonncc.setBackground(new Color(30, 215, 96));
        chonncc.setForeground(new Color(255, 255, 255));
        chonncc.setBounds(270, 95, 40, 30);
        chonncc.setFont(fontBut);
        chonnv = new JButton("...");
        chonnv.setForeground(new Color(255, 255, 255));
        chonnv.setBackground(new Color(30, 215, 96));
        chonnv.setBounds(270, 145, 40, 30);
        chonnv.setFont(fontBut);
        if (id.equals("Manager")) {
        } else {
            chonnv.setEnabled(false);
        }


        //Phải
        lbngaydat = new JLabel("Ngày đặt :");
        lbngaydat.setBounds(350, 50, 120, 24);
        lbngaydat.setFont(font);
        lbtongtien = new JLabel("Tổng tiền :");
        lbtongtien.setBounds(350, 100, 120, 24);
        lbtongtien.setFont(font);


        txngaydat = new JTextField();
        txngaydat.setBounds(470, 45, 150, 30);
        txngaydat.setEditable(false);
        txngaydat.setFont(fontinput);

        txtongtien = new JTextField();
        txtongtien.setBounds(470, 95, 150, 30);
        txtongtien.setEditable(false);
        txtongtien.setFont(fontinput);
      
        pnpn.add(lbmapnh);
        pnpn.add(txmapnh);
        pnpn.add(lbmancc);
        pnpn.add(txmancc);
        pnpn.add(lbmanv);
        pnpn.add(txmanv);
        //pnpn.add(lbsltong);
        //pnpn.add(txsltong);
        pnpn.add(lbngaydat);
        pnpn.add(txngaydat);
        pnpn.add(lbtongtien);
        pnpn.add(txtongtien);

       // pnpn.add(dongpnh);
        pnpn.add(chonncc);
        pnpn.add(chonnv);

        pnpn.repaint();
        xacnhan = new JButton("Xác nhận");
        xacnhan.setFont(font);
        xacnhan.setBounds(670, 125, 150, 50);
        xacnhan.setBackground(new Color(30, 215, 96));
        xacnhan.setForeground(new Color(255, 255, 255));
        xacnhan.addMouseListener(new MouseListener() {

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
                xacnhan.setBackground(new Color(249, 6, 59));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                xacnhan.setBackground(new Color(30, 210, 96));
            }
        });
        thoat = new JButton("Hủy");
        thoat.setFont(font);
        thoat.setBounds(670, 50, 150, 50);
        thoat.setBackground(new Color(30, 215, 96));
        thoat.setForeground(new Color(255, 255, 255));
        thoat.addMouseListener(new MouseListener() {

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
                thoat.setBackground(new Color(249, 6, 59));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                thoat.setBackground(new Color(30, 210, 96));
            }
        });
        pnpn.add(thoat);
        pnpn.add(xacnhan);

        //Chi tiết hóa đơn
        pnctpn = new JPanel();
        pnctpn.setLayout(null);
        pnctpn.setBounds(50, 300, 900, 500);
        tthd.setBorder(border);
        TitledBorder ttctpnh = new TitledBorder("Chi tiết");
        ttctpnh.setBorder(border);
        ttctpnh.setTitleJustification(TitledBorder.LEFT);
        ttctpnh.setTitlePosition(TitledBorder.TOP);
        ttctpnh.setTitleColor(new Color(249, 6, 59));
        ttctpnh.setTitleFont(fontt);
        pnctpn.setBorder(ttctpnh);
        //Thông tin chi tiết
        lbmasp = new JLabel("Mã SP : ");
        lbmasp.setBounds(20, 40, 80, 18);
        lbmasp.setFont(font);
        txmasp = new JTextField();
        txmasp.setEditable(false);
        txmasp.setBounds(100, 35, 60, 30);
        txmasp.setFont(fontinput);

        lbten = new JLabel("Tên : ");
        lbten.setBounds(200, 40, 50, 18);
        lbten.setFont(font);
        txten = new JTextField();
        txten.setEditable(false);
        txten.setBounds(250, 35, 200, 30);
        txten.setFont(fontinput);

        lbdongia = new JLabel("Giá nhập : ");
        lbdongia.setBounds(470, 40, 100, 25);
        lbdongia.setFont(font);
        txgianhap = new JTextField();
        txgianhap.setEditable(false);
        txgianhap.setBounds(550, 35, 100, 30);
        txgianhap.setFont(fontinput);

        lbsoluong = new JLabel("SL : ");
        lbsoluong.setBounds(670, 40, 50, 18);
        lbsoluong.setFont(font);
        txsoluong = new JTextField();
        txsoluong.setBounds(700, 35, 50, 30);
        txsoluong.setFont(fontinput);
 //       txsoluong.setEditable(false);

        chonsp = new JButton("...");
        chonsp.setBounds(760, 35, 40, 30);
        chonsp.setBackground(new Color(30, 215, 96));
        chonsp.setForeground(new Color(255, 255, 255));

        them = new JButton("Thêm");
        them.setForeground(new Color(255, 255, 255));
        them.setBackground(new Color(30, 215, 96));
        them.setBounds(20, 80, 90, 40);
        them.setFont(fontBut);
        xoa = new JButton("Xóa");
        xoa.setForeground(new Color(255, 255, 255));
        xoa.setBackground(new Color(30, 215, 96));
        xoa.setBounds(120, 80, 90, 40);
        xoa.setFont(fontBut);
        sua = new JButton("Sửa");
        sua.setForeground(new Color(255, 255, 255));
        sua.setBackground(new Color(30, 215, 96));
        //sua.setBounds(220, 80, 90, 40);
        sua.setFont(fontBut);
        reset = new JButton("Reset");
        reset.setForeground(new Color(255, 255, 255));
        reset.setBackground(new Color(30, 215, 96));
        //reset.setBounds(220, 80, 90, 40);
        reset.setBounds(220, 80, 90, 40);
        //reset.setBounds(320, 80, 90, 40);
        reset.setFont(fontBut);
//        lbsoluongmacdinh = new JLabel("SL mặc định : ");
//        lbsoluongmacdinh.setBounds(433, 80, 150, 40);
//        lbsoluongmacdinh.setFont(font);
//        txsoluongmacdinh = new JTextField();
//        txsoluongmacdinh.setBounds(550, 85, 50, 30);
//        txsoluongmacdinh.setFont(fontinput);
//        txsoluongmacdinh.setEditable(false);

        Vector header = new Vector();
        header.add("Mã SP");      
        header.add("Số Lượng");
        header.add("Giá nhập");
        header.add("Thành Tiền");
        
        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.getTableHeader().setBackground(new Color(66, 134, 244));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBorder(bordernull);
        table.setRowHeight(30);
        JScrollPane bangcthd = new JScrollPane(table);
        bangcthd.setBounds(20, 130, 860, 350);

        pnctpn.add(lbmasp);
        pnctpn.add(txmasp);
        pnctpn.add(lbten);
        pnctpn.add(txten);
        pnctpn.add(lbdongia);
        pnctpn.add(txgianhap);
        pnctpn.add(lbsoluong);
        pnctpn.add(txsoluong);
//        pnctpn.add(lbsoluongmacdinh);
//        pnctpn.add(txsoluongmacdinh);
        pnctpn.add(chonsp);
        pnctpn.add(them);
        pnctpn.add(xoa);
        //pnctpn.add(sua);
        pnctpn.add(reset);
       
        pnctpn.add(bangcthd);

        pnpn.repaint();
        pnctpn.repaint();
        this.add(pnpn);
        this.add(pnctpn);

        this.repaint();
        this.validate();
        setEvent(id);
    }

    public int Chuyenint(String fm) throws ParseException {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        Number d = fmmoney.parse(fm);
        BigDecimal bd = new BigDecimal(d.toString());
        int a = bd.intValue();
        return a;
    }

    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }

    public String ChuyenString(Date date) {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String fmd = fm.format(date);
        return fmd;
    }

    public Date ChuyenDate(String fmd) throws ParseException {
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Date d = fm.parse(fmd);
        return d;
    }

    public void setEvent(String id) {

        PhieuNhapBUS buspn = new PhieuNhapBUS();
        buspn.docDSPN();
        
        CTPhieuNhapBUS busctpn = new CTPhieuNhapBUS();
        CTPhieuNhapBUS.dsctpn = new ArrayList<>();
        txmapnh.setText(buspn.Pntieptheo());
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        txngaydat.setText(fm.format(date));
        dongpnh.addActionListener((ActionEvent e) -> {

            if (change == 0) {
                change = 1;
                txmapnh.setEditable(false);
            } else {
                change = 0;
                txmapnh.setEditable(true);
            }

        });   
        chonncc.addActionListener((ActionEvent e) -> {
            SupportNCC duyetncc = new SupportNCC ("PhieuNhap");
        });
//        chonnv.addActionListener((ActionEvent e) -> {
//            DuyetNVGUI duyetnv = new DuyetNVGUI("PhieuNhap");
//        });
        chonsp.addActionListener((ActionEvent e) -> {
            if(txmancc.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn NCC");
                SupportNCC duyetncc = new SupportNCC ("PhieuNhap");
            }
            else {SupportSPNCC duyetsp = new SupportSPNCC(txmancc.getText());}
            
        });
        
        //thêm chi tiết phiếu nhập
        //tui nghĩ là phần thêm CTPN này sai là vì PN chưa tạo
        //phải tạo PN xong rồi mới tạo CTPN
        //nên tui nghĩ là mỗi lần ấn nút thêm CTPN thì sẽ thêm CTPN vào 1 ArrayList
        //khi nào ấn nút XÁC NHẬN thì lúc đó sẽ tạo PN và sẽ lần lượt thêm các CTPN từ ArrayList
        
        //Phần này đang làm lại
        them.addActionListener((ActionEvent e) -> {
            if ("".equals(txmapnh.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập mã PN để có thể bắt đầu thêm");
            } else if ("".equals(txmasp.getText())) {
                JOptionPane.showMessageDialog(null, "Chọn thông tin sản phẩm cần nhập");
            } else if ("".equals(txsoluong.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập số lượng sản phẩm cần nhập"); 
                txsoluong.requestFocus();
            } else if (txmapnh.isEditable() == true) {
                JOptionPane.showMessageDialog(null, "Đóng mã PN rồi mới nhập chi tiết");
            } else {
                               
                String pattern ="^[0-9]{1,}$";
                if(txsoluong.getText().matches(pattern)==false)
                {
                    JOptionPane.showMessageDialog(null, "Chỉ được nhập số"); 
                    return;
                }
                CTNhapDTO ctpn = new CTNhapDTO();
                ctpn.setManhap(txmapnh.getText());
                ctpn.setMasach(txmasp.getText());             
                ctpn.setGianhap(Integer.valueOf(txgianhap.getText()));
                ctpn.setSoluong(Integer.valueOf(txsoluong.getText()));
                ctpn.setThanhtien(Integer.valueOf(txgianhap.getText())*Integer.valueOf(txsoluong.getText()));//giá*số lượng
                
                if(ctpnthem.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Mảng trống");
                    ctpnthem.add(ctpn);
                    JOptionPane.showMessageDialog(null, "mã sách vào mảng: "+ctpn.getMasach());
                        Vector row = new Vector();
                        row.add(ctpn.getMasach());
                        //row.add(txten.getText());
                        row.add(ctpn.getSoluong());
                        row.add(Chuyentien(String.valueOf(ctpn.getGianhap())));
                        row.add(Chuyentien(String.valueOf(ctpn.getThanhtien())));
                        tongtien += ctpn.getThanhtien();
                        txtongtien.setText(Chuyentien(String.valueOf(tongtien)));
                        model.addRow(row);
                        table.setModel(model);
                }
                else
                {
                    int trung=0;
                    for (int i=0; i<ctpnthem.size(); i++)
                    {
                    CTNhapDTO tempctpn = new CTNhapDTO();
                    tempctpn = ctpnthem.get(i);
                        if(tempctpn.getMasach().equals(ctpn.getMasach()))
                        {
                            JOptionPane.showMessageDialog(null, "Mã sách bị trùng");
                            trung=1;
                            break;
                        }
                    }
                    if(trung==0)
                    {
                         ctpnthem.add(ctpn);
                        JOptionPane.showMessageDialog(null, "mã sách vào mảng: "+ctpn.getMasach());
                        Vector row = new Vector();
                        row.add(ctpn.getMasach());
                        //row.add(txten.getText());
                        row.add(ctpn.getSoluong());
                        row.add(Chuyentien(String.valueOf(ctpn.getGianhap())));
                        row.add(Chuyentien(String.valueOf(ctpn.getThanhtien())));
                        tongtien += ctpn.getThanhtien();
                        txtongtien.setText(Chuyentien(String.valueOf(tongtien)));
                        model.addRow(row);
                        table.setModel(model);
                    }
                       
                }
            }
                
            
        });
        
        xoa.addActionListener((ActionEvent e) -> {
            int i = table.getSelectedRow();
            if (i >= 0) {
                CTNhapDTO ctpn = new CTNhapDTO();
                ctpn.setManhap(txmapnh.getText());
                ctpn.setMasach(String.valueOf(model.getValueAt(i, 0)));
                ctpn.setSoluong(Integer.parseInt(model.getValueAt(i, 1).toString()));
                try {
                    ctpn.setGianhap(Chuyenint(model.getValueAt(i, 2).toString()));
                    ctpn.setThanhtien(Chuyenint(model.getValueAt(i, 3).toString()));
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
                
                //gỡ CTPN muốn xóa ra khỏi ArrayList ctpnthem
                for(int j=0; j<ctpnthem.size(); j++)
                {
                    CTNhapDTO temp = new CTNhapDTO();
                    temp = ctpnthem.get(j);
                    if(temp.getMasach().equals(ctpn.getMasach()))
                    {
                        ctpnthem.remove(j);
                        break;
                    }                   
                }                
                JOptionPane.showMessageDialog(null,ctpnthem.size());
                
                //busctpn.XoaCTPNtheoPN(ctpn);
                model.removeRow(i);
                table.setModel(model);
                tongtien -= ctpn.getThanhtien();
                txtongtien.setText(Chuyentien(String.valueOf(tongtien)));                
                txmasp.setText("");
                txten.setText("");
                txgianhap.setText("");
                txsoluong.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Chọn dòng để xóa");
            }
        });
        
        reset.addActionListener((ActionEvent e)->
        {
//            for(int i=0; i<ctpnthem.size(); i++)
//            {
//                ctpnthem.remove(i);
//            }
            tongtien=0; //trả tổng tiền về 0
            txtongtien.setText("");
            txmancc.setText("");
            txmasp.setText("");
            txten.setText("");
            txgianhap.setText("");
            txsoluong.setText("");
                       
            ctpnthem.clear();
            
            model.setNumRows(0);
            table.setModel(model);
            
                
        });
        
        //sau khi ấn nút xác nhận sẽ tạo mã phiếu nhập và tạo chi tiết phiếu nhập từ mảng
        xacnhan.addActionListener((ActionEvent e) -> {
            int chuyendoi = 1;
            if (model.getRowCount() == 0) {
                chuyendoi = 0;
                JOptionPane.showMessageDialog(null, "Cần có thông tin trong bảng chi tiết");
            }
            if (chuyendoi == 1) {
                int output = JOptionPane.showConfirmDialog(null, "Có chắc muốn tạo phiếu nhập này", "", JOptionPane.YES_NO_OPTION);
                if (output == JOptionPane.YES_OPTION) {
                    PhieuNhapDTO pn = new PhieuNhapDTO();
                    pn.setManhap(txmapnh.getText());
                    pn.setMancc(txmancc.getText());
                    pn.setManv(txmanv.getText());
                    //pn.setSltong(Integer.valueOf(txsltong.getText()));
                    try {
                        pn.setTongtien(Chuyenint(txtongtien.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(SupportPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pn.setNgaynhap(txngaydat.getText());                   

                    //Thêm phiếu nhập
                    if (PhieuNhapBUS.dspn == null) {
                        buspn.docDSPN();
                    }
                    buspn.ThemPN(pn);
                    
                    //Thêm chi tiết phiếu nhập
                    CTNhapDTO ctpn = new CTNhapDTO();
                    CTPhieuNhapBUS ctnhapbus = new CTPhieuNhapBUS();
                    for(int i=0; i<ctpnthem.size(); i++)
                    {
                        ctpn=ctpnthem.get(i);
                        ctnhapbus.ThemCTHDtheoHD(ctpn);
                    }
                    //Thêm PN vào bảng GUI
                    Vector row = new Vector();
                    row.add(pn.getManhap());
                    row.add(pn.getMancc());
                    row.add(pn.getManv());
                    row.add(pn.getNgaynhap());
                    row.add(Chuyentien(String.valueOf(pn.getTongtien())));
                                    
                    
                    if (id.equals("Manager")) {
                        PhieuNhapGUI.modelHD.addRow(row);
                        PhieuNhapGUI.tableHD.setModel(PhieuNhapGUI.modelHD);
                    } else {
                        NhapHangGUI.modelHD.addRow(row);
                        NhapHangGUI.tableHD.setModel(NhapHangGUI.modelHD);
                    }
                    
//                    SachBUS spbus = new SachBUS();                   
//                    spbus.docDSSP();
                    tongtien=0;
                    this.setVisible(false);

                } else if (output == JOptionPane.NO_OPTION) {
//                    change = 0;
//                    txmapnh.setEditable(true);
                }
            }
        });
        thoat.addActionListener((ActionEvent e) -> {
            int output = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy toàn bộ PN và CTPN hiện tại", "", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                if (table.getRowCount() >= 0) // Nếu có thông tin đang thêm
                {                    
                    busctpn.XoaallCTPNtheoPN(txmapnh.getText());
                    this.setVisible(false);
                }
                tongtien=0;
            }
            

        });

    }

//    public static void main(String[] args) {
//        ThemPNHGUI test = new ThemPNHGUI();
//        test.setView("NV01");
//    }
}

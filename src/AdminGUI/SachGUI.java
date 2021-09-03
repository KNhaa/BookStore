/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

//import BUS.SanPhamBUS;
//import DTO.SanPhamDTO;
////import GUI.DuyetGUI.DuyetNCC;
//import Report.ReportExcel;
import BUS.SachBUS;
import DTO.SachDTO;
import Report.ExcelReport;
import SupportGUI.SupportLoai;
import SupportGUI.SupportNCC;
import SupportGUI.SupportNXB;
import SupportGUI.SupportTacGia;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author acer
 */
public class SachGUI extends JPanel implements ActionListener {

    public static JTextField txmancc, txmasp, txgia, txloai, txsoluong, txten, txtg,txnxb, txtimkiem;
    JLabel lbmasp, lbgia, lbloai, lbmancc, lbmanxb, lbsoluong, lbten, lbmatg;
    JLabel lbtimkiem, lbicon, lbinfosp, lbtknc, muiten, muiten1;
    JLabel lbtop, lbexit, lbavatar, hinhavatar;
    JButton them, xoa, sua, reset, timkiem, chonncc, back, tknc, tkncoff,inan,chonloai, chontg, chonnxb;
    JButton exit;
      
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font font1 = new Font("Segoe UI", Font.BOLD, 22);
    Font fonttxt = new Font("Segoe UI", Font.PLAIN, 20);
    Font fonttknc = new Font("Segoe UI", Font.PLAIN, 15);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(31,73,91),2);
    String linkanh = "";
    Image i; // dữ liệu hình ảnh
    JTable table;
    int choice = 0;
    DefaultTableModel model;
    //Tìm kiếm nâng cao
    JLabel lbgiatk, lbsoluongtk;
    JTextField txgiatu, txgiaden, txsltu, txslden;
    int change = 0; // thuộc tính thay đổi nút sửa và xacnhan nếu = 0 thì là sửa = 1 là xác nhận

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

    public SachGUI() {
        //this.setSize(1350, 945);
        this.setSize(950,700);
        this.setLayout(null);
        //this.setSize(1350, 945);
        this.setBorder(border);
        //this.setBackground(new Color(33, 33, 33));
        this.setBackground(new Color(237,241,255));

        lbtknc = new JLabel(); //Label tim kiem nang cao
        lbtknc.setBounds(340, 65, 450, 145);
        lbtknc.setBackground(new Color(100,100,100));
        lbtknc.setOpaque(true);
        this.add(lbtknc);

        txgiatu = new JTextField();
        txgiatu.setText("Giá từ...");
        txgiatu.setFont(fonttknc);
        txgiatu.setBounds(20, 20, 150, 40);
        txgiatu.setBorder(border);
        txgiatu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txgiatu.setBorder(borderinput);
                if (txgiatu.getText().equals("Giá từ...")) {
                    txgiatu.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                txgiatu.setBorder(border);
                if (txgiatu.getText().equals("")) {
                    txgiatu.setText("Giá từ...");
                }
            }
        });

        txgiaden = new JTextField();
        txgiaden.setText("Giá đến...");
        txgiaden.setFont(fonttknc);
        txgiaden.setBounds(220, 20, 150, 40);
        txgiaden.setBorder(border);
        txgiaden.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txgiaden.setBorder(borderinput);
                if (txgiaden.getText().equals("Giá đến...")) {
                    txgiaden.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                txgiaden.setBorder(border);
                if (txgiaden.getText().equals("")) {
                    txgiaden.setText("Giá đến...");
                }
            }
        });

        ImageIcon hinhmuiten = new ImageIcon(getClass().getResource("/HinhAnh/muiten.png"));
        muiten = new JLabel();
        muiten.setIcon(hinhmuiten);
        muiten.setFont(fonttknc);
        muiten.setBounds(180, 25, 40, 30);
        muiten.setBorder(bordernull);
        muiten.setFocusTraversalKeysEnabled(false);
        muiten.setForeground(new Color(255, 255, 255));

        lbtknc.add(txgiatu);
        lbtknc.add(muiten);
        lbtknc.add(txgiaden);

        txsltu = new JTextField();
        txsltu.setText("Số Lượng từ...");
        txsltu.setFont(fonttknc);
        txsltu.setBounds(20, 85, 150, 40);
        txsltu.setBorder(border);
        txsltu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txsltu.setBorder(borderinput);
                if (txsltu.getText().equals("Số Lượng từ...")) {
                    txsltu.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                txsltu.setBorder(border);
                if (txsltu.getText().equals("")) {
                    txsltu.setText("Số Lượng từ...");
                }
            }
        });

        txslden = new JTextField();
        txslden.setText("Số Lượng đến...");
        txslden.setFont(fonttknc);
        txslden.setBounds(220, 85, 150, 40);
        txslden.setBorder(border);
        txslden.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txslden.setBorder(borderinput);
                if (txslden.getText().equals("Số Lượng đến...")) {
                    txslden.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                txslden.setBorder(border);
                if (txslden.getText().equals("")) {
                    txslden.setText("Số Lượng đến...");
                }
            }
        });

        ImageIcon hinhmuiten1 = new ImageIcon(getClass().getResource("/HinhAnh/muiten1.png"));
        muiten1 = new JLabel();
        muiten1.setIcon(hinhmuiten1);
        muiten1.setFont(fonttknc);
        muiten1.setBounds(180, 90, 40, 30);
        muiten1.setBorder(bordernull);
        muiten1.setFocusTraversalKeysEnabled(false);
        muiten1.setForeground(new Color(255, 255, 255));

        lbtknc.add(txsltu);
        lbtknc.add(muiten1);
        lbtknc.add(txslden);

        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));
        timkiem = new JButton();
        timkiem.setBounds(380, 0, 70, 145);
        timkiem.setBackground(new Color(30, 210, 96));
        timkiem.setIcon(hinhtimkiem);
        timkiem.setFont(new Font("Segoe UI", Font.BOLD, 20));
        timkiem.setFocusPainted(false);
        timkiem.setCursor(new Cursor(HAND_CURSOR));
        timkiem.setBorder(bordernull);
        timkiem.addMouseListener(new MouseListener() {
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
               timkiem.setBackground(new Color(249,6,59));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               timkiem.setBackground(new Color(30,210,96));
            }
        });
        
    
        lbtknc.add(timkiem);
        lbtknc.setVisible(false);

        lbtop = new JLabel();
        //lbtop.setBounds(0, 0, 1350, 65);
        lbtop.setBounds(0, 0, 950, 65);
        //lbtop.setBackground(new Color(18, 18, 18));
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
                    back.setIcon(hinhbackf);
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
        //back.setBackground(new Color(33, 33, 33));
        back.setBackground(new Color(237,241,255));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                back.setIcon(hinhback);
                txtimkiem.setText("");
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                for (SachDTO sp : SachBUS.dssp) {
                    Vector row = new Vector();
                    row.add(sp.getMasach());
                     row.add(sp.getMatg());
                    row.add(sp.getMaloai());
                    row.add(sp.getManxb());
                    row.add(sp.getMancc());
                    row.add(sp.getTensach());                    
                    row.add(Chuyentien(String.valueOf(sp.getDongia())));
                    row.add(sp.getSoluong());
                    model.addRow(row);
                }
                table.setModel(model);
            }
        });
        lbtop.add(back);       
        String choose[] = {"Theo Mã SP", "Theo Tác Giả","Theo Mã loại", "Theo NXB", "Theo NCC", 
            "Theo Tên SP", "Theo Giá", "Theo Số Lượng"};
        
        JComboBox cb = new JComboBox(choose);
        cb.setBounds(340, 18, 130, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);
        cb.setBackground(new Color(255, 255, 255));

        ImageIcon hinhnutxuong = new ImageIcon(getClass().getResource("/HinhAnh/nutxuong.png"));
        ImageIcon hinhnutxuongf = new ImageIcon(getClass().getResource("/HinhAnh/nutxuongf.png"));
        ImageIcon hinhnutlen = new ImageIcon(getClass().getResource("/HinhAnh/nutlen.png"));
        ImageIcon hinhnutlenf = new ImageIcon(getClass().getResource("/HinhAnh/nutlenf.png"));
        tknc = new JButton();
        tknc.setBounds(490, 18, 30, 30);
        tknc.setIcon(hinhnutxuong);
        tknc.setBorder(bordernull);
        tknc.setFocusTraversalKeysEnabled(false);
        tknc.setBackground(new Color(33, 33, 33));
        tknc.addMouseListener(new MouseListener() {
            // SẢN PHẨM GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                lbtknc.setVisible(true);
                tknc.setVisible(false);
                tkncoff.setVisible(true);
                txloai.setVisible(false);
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
        tkncoff.setIcon(hinhnutlenf);
        tkncoff.setBorder(bordernull);
        tkncoff.setFocusTraversalKeysEnabled(false);
        //tkncoff.setBackground(new Color(33, 33, 33));
        tkncoff.setBackground(new Color(237,241,255));
        tkncoff.setVisible(false);
        tkncoff.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbtknc.setVisible(false);
                tknc.setVisible(true);
                tkncoff.setVisible(false);
                txloai.setVisible(true);
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

        lbtop.add(tkncoff);
        lbtop.add(tknc);
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
        lbtop.add(cb);
        lbtop.add(lbexit);
        lbtop.add(txtimkiem);

        //lbtop.add(timkiem);
        lbinfosp = new JLabel("Sản Phẩm");
        lbinfosp.setBounds(30, 80, 200, 60);
        lbinfosp.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //lbinfosp.setForeground(new Color(30, 215, 96));
        lbinfosp.setForeground(new Color(31,73,91));

        lbmasp = new JLabel("Mã :", JLabel.LEFT);
        lbmasp.setBounds(30, 155, 60, 50);
        lbmasp.setFont(font1);
        //lbmasp.setForeground(new Color(255, 255, 255));
        lbmasp.setForeground(new Color(33,33,33));
        txmasp = new JTextField(18);
        txmasp.setFont(font);
        txmasp.setEditable(false);
        SachBUS sachbus = new SachBUS();        
        txmasp.setText(sachbus.Sachtieptheo());
        txmasp.setBounds(100, 165, 60, 30);
        //     txmasp.setBounds(95, 160, 200, 40);
        
        txmasp.setBorder(border);
        txmasp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txmasp.setBounds(95, 160, 60, 40);
                txmasp.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txmasp.setBorder(bordernull);
                if (txmasp.getText().equals("")) {
                    txmasp.setBounds(100, 165, 60, 30);
                } else {
                    txmasp.setBounds(95, 160, 60, 40);
                }
            }
        });
        
        

        lbten = new JLabel("Tên :", JLabel.LEFT);
        //lbten.setBounds(30, 225, 60, 50);
        lbten.setBounds(30, 295, 60, 50);
        lbten.setFont(font1);
        //lbten.setForeground(new Color(255,255,255));
        lbten.setForeground(new Color(33, 33, 33));
        txten = new JTextField(18);
        txten.setFont(font);
        txten.setBounds(100, 300, 450, 30);
        txten.setBorder(border);
        txten.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txten.setBounds(95, 300, 450, 40);
                txten.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txten.setBorder(bordernull);
                if (txten.getText().equals("")) {
                    txten.setBounds(100, 300, 450, 30);
                } else {
                    txten.setBounds(95, 300, 450, 40);
                }
            }
        });

        lbloai = new JLabel("Mã Loại :", JLabel.LEFT);
        lbloai.setBounds(290, 155, 100, 50);
        lbloai.setFont(font1);
        //lbloai.setForeground(new Color(255, 255, 255));
        lbloai.setForeground(new Color(33, 33, 33));
        txloai = new JTextField(18);
        txloai.setFont(font);
        txloai.setEditable(false);
        txloai.setBounds(420, 165, 60, 30);
        txloai.setBorder(border);

        chonloai = new JButton("...");
        chonloai.setFont(font);
        chonloai.setBounds(505,  165, 40, 30);
        chonloai.setForeground(new Color(255, 255, 255));
        chonloai.setBackground(new Color(134, 174, 195));
        chonloai.setCursor(new Cursor(HAND_CURSOR));

        lbmancc = new JLabel("Mã NCC :", JLabel.LEFT);
        lbmancc.setBounds(290, 225, 120, 50);
        lbmancc.setFont(font1);
        lbmancc.setForeground(new Color(33, 33, 33));
        txmancc = new JTextField(18);
        txmancc.setFont(font);
        txmancc.setBounds(420, 235, 60, 30);
        txmancc.setBorder(border);
        txmancc.setEditable(false);


        chonncc = new JButton("...");
        chonncc.setFont(font);
        chonncc.setBounds(505, 235, 40, 30);
        chonncc.setForeground(new Color(255, 255, 255));
        chonncc.setBackground(new Color(134, 174, 195));
        chonncc.setCursor(new Cursor(HAND_CURSOR));
        
        lbmatg = new JLabel("Mã TG :", JLabel.LEFT);
//        lbmatg.setBounds(290, 155, 100, 50);
        lbmatg.setBounds(600, 155, 100, 50);
        lbmatg.setFont(font1);
        //lbmatg.setForeground(new Color(255, 255, 255));
        lbmatg.setForeground(new Color(33, 33, 33));
        txtg = new JTextField(18);
        txtg.setFont(font);
        txtg.setEditable(false);
        //txtg.setBounds(420, 165, 60, 30);
        txtg.setBounds(730, 165, 60, 30);
        txtg.setBorder(border);
        
        chontg = new JButton("...");
        chontg.setFont(font);
        chontg.setBounds(815,  165, 40, 30);
        chontg.setForeground(new Color(255, 255, 255));
        chontg.setBackground(new Color(134, 174, 195));       
        chontg.setCursor(new Cursor(HAND_CURSOR));
        
       /*Chọn NXB */
        lbmanxb = new JLabel("Mã NXB :", JLabel.LEFT);
//        lbmanxb.setBounds(600, 155, 100, 50);
        lbmanxb.setBounds(600, 230, 100, 50);
        lbmanxb.setFont(font1);
        //lbmanxb.setForeground(new Color(255, 255, 255));
        lbmanxb.setForeground(new Color(33, 33, 33));
        txnxb = new JTextField(18);
        txnxb.setFont(font);
        txnxb.setEditable(false);
        txnxb.setBounds(730, 235, 60, 30);
        txnxb.setBorder(border);
        
        chonnxb = new JButton("...");
        chonnxb.setFont(font);
        chonnxb.setBounds(815,  235, 40, 30);
        chonnxb.setForeground(new Color(255, 255, 255));
        chonnxb.setBackground(new Color(134, 174, 195));
        chonnxb.setCursor(new Cursor(HAND_CURSOR));
        
//505, 235, 40, 30
        lbgia = new JLabel("Giá :", JLabel.LEFT);
        lbgia.setBounds(600, 295, 60, 50);
        lbgia.setFont(font1);
        lbgia.setForeground(new Color(33,33,33));
        txgia = new JTextField(18);
        txgia.setFont(font);
        txgia.setBounds(730, 295, 125, 35);
        txgia.setBorder(border);
        txgia.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txgia.setBounds(730, 295, 125, 35);
                txgia.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txgia.setBorder(bordernull);
                if (txgia.getText().equals("")) {
                    txgia.setBounds(735, 295, 125, 35);
                } else {
                    txgia.setBounds(730, 295, 125, 35);
                }
            }
        });

        lbsoluong = new JLabel("SL :", JLabel.LEFT);
        lbsoluong.setBounds(30, 225, 60, 50);
        lbsoluong.setFont(font1);
        lbsoluong.setForeground(new Color(33, 33, 33));
        txsoluong = new JTextField(18);
        txsoluong.setFont(font);
        
        txsoluong.setBounds(100, 230, 60, 30);
        txsoluong.setBorder(border);
        txsoluong.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txsoluong.setBounds(100, 230, 60, 30);
                txsoluong.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txsoluong.setBorder(bordernull);
                if (txsoluong.getText().equals("")) {
                    txsoluong.setBounds(100, 230, 60, 30);
                } else {
                    txsoluong.setBounds(100, 230, 60, 30);
                }
            }
        });

        lbicon = new JLabel("abcjoior");
        lbicon.setBounds(45, 380, 300, 400);
        lbicon.setBackground(new Color(33, 33, 33));        
        lbicon.setBorder(border);
        lbicon.setOpaque(true);

        ImageIcon load = new ImageIcon(getClass().getResource("/HinhAnh/loadhinh.png"));
        ImageIcon load1 = new ImageIcon(getClass().getResource("/HinhAnh/loadhinh1.png"));
       
        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        them = new JButton();
        them.setBounds(270, 330, 130, 70);
        them.setBackground(new Color(33, 33, 33));
        them.setBorder(bordernull);
        them.setIcon(hinhthem);
        them.setFocusPainted(false);
        them.setContentAreaFilled(false);
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
        xoa.setBounds(410, 330, 110, 70);
        xoa.setBackground(new Color(33, 33, 33));
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

        ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
        ImageIcon hinhsua1 = new ImageIcon(getClass().getResource("/HinhAnh/sua1.png"));
        sua = new JButton();
        sua.setBounds(525, 330, 110, 70);
        sua.setBackground(new Color(33, 33, 33));
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
        ImageIcon hinhreset1 = new ImageIcon(getClass().getResource("/HinhAnh/reset2.png"));
        reset = new JButton();
        reset.setBounds(640, 320, 110, 90);
        reset.setBackground(new Color(33, 33, 33));
        reset.setBorder(bordernull);
        reset.setIcon(hinhreset);
        reset.setFocusPainted(false);
        reset.addMouseListener(new MouseListener() {
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
                reset.setIcon(hinhreset1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reset.setIcon(hinhreset);
            }

        });
        ImageIcon hinhxuat1 = new ImageIcon(getClass().getResource("/HinhAnh/in4.png"));
        ImageIcon hinhxuat_h = new ImageIcon(getClass().getResource("/HinhAnh/in42.png"));
        inan = new JButton();
        inan.setIcon(hinhxuat1);
        inan.setBounds(130, 330, 170, 70);
        inan.setBorder(bordernull);
        inan.setBackground(new Color(33, 33, 33));
        inan.setFocusPainted(false);
        inan.addMouseListener(new MouseListener()
                {

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
                inan.setIcon(hinhxuat_h);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                inan.setIcon(hinhxuat1);
            }
                    
                });
        inan.setContentAreaFilled(false);
        them.setContentAreaFilled(false);
        xoa.setContentAreaFilled(false);
        sua.setContentAreaFilled(false);
        reset.setContentAreaFilled(false);
       
        tknc.setContentAreaFilled(false);
        tknc.setFocusPainted(false);
        tkncoff.setContentAreaFilled(false);
        tkncoff.setFocusPainted(false);

        Vector header = new Vector();       
        header.add("Mã SP");
        header.add("Mã TG");
        header.add("Mã Loại");
        header.add("Mã NXB");
        header.add("Mã NCC");
        header.add("Tên");
        header.add("Giá");
        header.add("SL");
        
        
        
//        model = new DefaultTableModel(header, 0) {
//            @Override
//            public Class getColumnClass(int column) {
//                switch (column) {
//                    case 5:
//                        return Integer.class;
//                    default:
//                        return String.class;
//                }
//            }
//        };
        model = new DefaultTableModel(header,0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//         header.add("Mã SP");
//        header.add("Mã Tác giả");
//        header.add("Mã Loại");
//        header.add("Mã NXB");
//        header.add("Mã NCC");
//        header.add("Tên");
//        header.add("Giá");
//        header.add("Số lượng");
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(25);
        table.getColumnModel().getColumn(2).setPreferredWidth(25);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(4).setPreferredWidth(25);
        table.getColumnModel().getColumn(5).setPreferredWidth(160);
        table.getColumnModel().getColumn(6).setPreferredWidth(90);
        table.getColumnModel().getColumn(7).setPreferredWidth(40);
        //table.getTableHeader().setBackground(new Color(66, 134, 244));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        //table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(25);

        //table.setAutoCreateRowSorter(true);
        JScrollPane bangsp = new JScrollPane(table);
       // bangsp.setBounds(390, 400, 935, 520);
        bangsp.setBounds(10, 400, 930, 280);
        bangsp.getVerticalScrollBar().setBackground(new Color(255,255,255));
        SachBUS bus = new SachBUS();
            bus.docDSSP();
        
//        System.out.println("");
//        for (SanPhamDTO x : SanPhamBUS.dssp) {
//            System.out.println(x.getMasp() + " " +x.getHang());
//        }
//        System.out.println("");
            
//        header.add("Mã SP");
//        header.add("Mã Tác giả");
//        header.add("Mã Loại");
//        header.add("Mã NXB");
//        header.add("Mã NCC");
//        header.add("Tên");
//        header.add("Giá");
//        header.add("Số lượng");
            
        for (SachDTO sp : SachBUS.dssp) {
            Vector row = new Vector();
            row.add(sp.getMasach());
            row.add(sp.getMatg());
            row.add(sp.getMaloai());
            row.add(sp.getManxb());
            row.add(sp.getMancc());
            row.add(sp.getTensach());
            row.add(Chuyentien(String.valueOf(sp.getDongia())));
            row.add(sp.getSoluong());
            model.addRow(row);
        }
        table.setModel(model);
        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String Ma = table.getValueAt(i, 0).toString();

                    SachBUS bus = new SachBUS();
                    SachDTO sp = bus.getInfoRow(Ma);
                    
                    txten.setBounds(100, 300, 430, 30);
                    txmasp.setBounds(100, 165, 60, 30);
                    txmasp.setEditable(false);
                    txloai.setBounds(420, 165, 60, 30);
                    txtg.setBounds(730, 165, 60, 30);
                    txmancc.setBounds(420, 235, 60, 30);
                    txnxb.setBounds(730, 235, 60, 30);
                    txgia.setBounds(730, 295, 125, 35);                    
                    txsoluong.setBounds(100, 230, 60, 30);
                    
                    txten.setText(sp.getTensach());
                    txmasp.setText(sp.getMasach());
                    txloai.setText(sp.getMaloai());
                    txtg.setText(sp.getMatg());
                    txmancc.setText(sp.getMancc());
                    txnxb.setText(sp.getManxb());                
                    txgia.setText(String.valueOf(sp.getDongia()));
                    txsoluong.setText(String.valueOf(sp.getSoluong()));
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

        table.setModel(model);
        this.add(lbtop);
        this.add(lbinfosp);
        this.add(lbmasp);
        this.add(txmasp);
        this.add(lbloai);
        this.add(txloai);
        this.add(lbmancc);
        this.add(txmancc);
        this.add(chonncc);
        this.add(chonloai);
        this.add(lbmatg);
        this.add(txtg);
        this.add(chontg);
        this.add(lbmanxb);
        this.add(txnxb);
        this.add(chonnxb);
        this.add(lbten);
        this.add(txten);
        this.add(lbgia);
        this.add(txgia);
        this.add(lbsoluong);
        this.add(txsoluong);
       //this.add(lbicon);
     
        this.add(them);
        this.add(xoa);
        this.add(sua);
        this.add(inan);
//        this.add(preview);
        this.add(reset);
//        this.add(next); ;
        this.add(bangsp);

        inan.addActionListener(this);
        them.addActionListener(this);
        xoa.addActionListener(this);
        sua.addActionListener(this);
        reset.addActionListener(this);
        timkiem.addActionListener(this);
        chonncc.addActionListener(this);//
        chonloai.addActionListener(this);
        chonnxb.addActionListener(this);
        chontg.addActionListener(this);
       

        //Tim kiếm theo gì đó
        cb.addActionListener((ActionEvent e) -> {
            choice = cb.getSelectedIndex();
            System.out.println(choice);
        });

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        txtimkiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    String text = txtimkiem.getText();
                    if (choice == 6) { // theo giá
                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choice));
                        }
                    }
                    if (choice == 7) { // theo số lượng
                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter("^" + text + "$", choice));
                        }
                    }
                    if (choice != 6 && choice != 7) {
                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, choice));
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Khi tìm kiếm theo giá buộc phải nhập số");
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    String text = txtimkiem.getText();
                    if (choice == 6) {
                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choice));
                        }
                    }
                    if (choice == 7) {
                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter("^" + text + "$", choice));
                        }
                    }
                    if (choice != 6 && choice != 7) {
                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", choice));
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Khi tìm kiếm theo giá buộc phải nhập số");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        
        //this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton temp = (JButton) e.getSource();

        if (temp == chonncc) {
            SupportNCC NCC = new SupportNCC("SanPham");
            NCC.setLocationRelativeTo(null);
        }
        
        if(temp == chonloai)
        {
            SupportLoai Loai = new SupportLoai("SanPham");
            Loai.setLocationRelativeTo(null);           
        }
        
        if(temp == chonnxb)
        {
            SupportNXB NXB = new SupportNXB("SanPham");
            NXB.setLocationRelativeTo(null);
        }
        
        if(temp == chontg)
        {
            SupportTacGia Tacgia = new SupportTacGia("SanPham");
            Tacgia.setLocationRelativeTo(null);
        }
        
        if(temp == inan)
        {
            ExcelReport excel = new ExcelReport();
            excel.ExportExcel("DSSach", table);
            
        }
        if (temp == reset) {
            //lbicon.setIcon(null);
            //txmasp.setText("");
            SachBUS sachbus = new SachBUS();        
            txmasp.setText(sachbus.Sachtieptheo());
            txmancc.setText("");
            txtg.setText("");
            txnxb.setText("");
            txloai.setText("");
            txten.setText("");
            txsoluong.setText("");
            txgia.setText("");
            them.setVisible(true);
            xoa.setVisible(true);
            ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
            sua.setIcon(hinhsua);
            change=0;


        }
        
        if (temp == them) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm sản phẩm", "Thêm", dialogButton);
            if(dialogResult == 0)
            {
                try {
                if(txsoluong.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Xin nhập số lượng sách");
                    return;
                }
                if(txgia.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Xin nhập giá sách");
                    return;
                }
                SachDTO sp = new SachDTO(); // nho cai nay
                sp.setMasach(txmasp.getText());
                sp.setTensach(txten.getText());
                sp.setMaloai(txloai.getText());
                sp.setMancc(txmancc.getText());
                sp.setManxb(txnxb.getText());
                sp.setMatg(txtg.getText());
                sp.setDongia(Integer.parseInt(txgia.getText()));
                sp.setSoluong(Integer.parseInt(txsoluong.getText()));
                SachBUS bus = new SachBUS();
                if (null == SachBUS.dssp) 
                {
                    bus.docDSSP();
                }
                if (bus.Them(sp)) 
                {
                    Vector row = new Vector();                  
                    row.add(sp.getMasach());
                    row.add(sp.getMatg());
                    row.add(sp.getMaloai());
                    row.add(sp.getManxb());
                    row.add(sp.getMancc());
                    row.add(sp.getTensach());
                    row.add(Chuyentien(String.valueOf(sp.getDongia())));
                    row.add(sp.getSoluong());
                    model.addRow(row);
                    table.setModel(model);
                } 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Số lượng và giá tiền phải là kiểu số");
            }
            }
            

        }
        if (temp == xoa) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa SP", "Xóa", dialogButton);
            if(dialogResult == 0)
            {
                String ma = txmasp.getText();
                SachBUS bus = new SachBUS();
                if (!bus.Xoa(ma)) 
                {
                return;
                } 
                else 
                {
                int i = table.getSelectedRow();
                model.removeRow(i);
                table.setModel(model);
                
                //txmasp.setText("");
                SachBUS sachbus = new SachBUS();        
                txmasp.setText(sachbus.Sachtieptheo());
                txmancc.setText("");
                txtg.setText("");
                txnxb.setText("");
                txloai.setText("");
                txten.setText("");
                txsoluong.setText("");
                txgia.setText("");
//                lbicon.setIcon(null);
                
                }
            }
            
        }

        if(temp == sua)
        {
            if (change == 0) {
                    change = 1;
                    txmasp.setEditable(false);
                    ImageIcon hinhxacnhan = new ImageIcon(getClass().getResource("/HinhAnh/xacnhan.png"));
                    sua.setIcon(hinhxacnhan);
                    them.setVisible(false);
                    xoa.setVisible(false);
                    txten.setText("");
                    //txmasp.setText("");
                    SachBUS sachbus = new SachBUS();        
                    txmasp.setText(sachbus.Sachtieptheo());
                    txnxb.setText("");
                    txmancc.setText("");
                    txloai.setText(""); 
                    txtg.setText("");
                    txsoluong.setText("");
                    txgia.setText("");  
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần sửa trên table rồi ấn xác nhận để sửa");
                } else {
                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        try {
                            
                            if(txsoluong.getText().equals(""))
                            {
                                JOptionPane.showMessageDialog(null,"Không được để trống số lượng");
                                return ;
                            }
                            else
                            {
                                String pattern = "^[0-9]{1,}$";
                                if(!Pattern.matches(pattern, txsoluong.getText()))
                                {
                                    JOptionPane.showMessageDialog(null,"Chỉ được nhập số");
                                    return ;
                                }
                            }
                            
                            if(txgia.getText().equals(""))
                            {
                                JOptionPane.showMessageDialog(null, "Không được để trống đơn giá");
                                return;
                            }
                            else
                            {
                                String pattern = "^[0-9]{1,}$";
                                if(!Pattern.matches(pattern, txgia.getText()))
                                {
                                    JOptionPane.showMessageDialog(null,"Chỉ được nhập số");
                                    return ;
                                }
                            }
                            
                            if(txten.getText().equals(""))
                            {
                                JOptionPane.showMessageDialog(null,"Không được để trống tên sách");
                                return;
                            }                           
                                                       
                            SachDTO sp = new SachDTO();
                            sp.setMasach(txmasp.getText());
                            sp.setTensach(txten.getText());
                            sp.setMaloai(txloai.getText());
                            sp.setMancc(txmancc.getText());
                            sp.setManxb(txnxb.getText());
                            sp.setMatg(txtg.getText());
                            sp.setDongia(Integer.parseInt(txgia.getText()));
                            sp.setSoluong(Integer.parseInt(txsoluong.getText()));
                           
                            SachBUS bus = new SachBUS();
                            if (!bus.Sua(sp)) {
                                return;
                            } else {
                                Vector row = new Vector();                  
                                row.add(sp.getMasach());
                                row.add(sp.getMatg());
                                row.add(sp.getMaloai());
                                row.add(sp.getManxb());
                                row.add(sp.getMancc());
                                row.add(sp.getTensach());
                                row.add(Chuyentien(String.valueOf(sp.getDongia())));
                                row.add(sp.getSoluong());
                   
                               
                                model.removeRow(i); // dòng chọn
                                model.insertRow(i, row);
                                table.setModel(model);
                                
                                txten.setText("");
                                //txmasp.setText("");
                                SachBUS sachbus = new SachBUS();        
                                txmasp.setText(sachbus.Sachtieptheo());
                                txnxb.setText("");
                                txmancc.setText("");
                                txloai.setText(""); 
                                txtg.setText("");
                                txsoluong.setText("");
                                txgia.setText("");  
                                                               
                                change = 0;
                                them.setVisible(true);
                                xoa.setVisible(true);

                                ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
                                sua.setIcon(hinhsua);
                                change = 0;
                            }
                        } catch (NullPointerException ex) {
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng");
                    }

                }
        }
        if (temp == timkiem) {
            try {
                
                int giatu;
                int giaden;
                int sltu;
                int slden;

                if ("".equals(txgiatu.getText()) || "Giá từ...".equals(txgiatu.getText())) {
                    giatu = 0;
                } else {
                    giatu = Integer.valueOf(txgiatu.getText());
                }

                if ("".equals(txgiaden.getText()) || "Giá đến...".equals(txgiaden.getText())) {
                    giaden = 100000000;
                } else {
                    giaden = Integer.valueOf(txgiaden.getText());
                }

                if ("".equals(txsltu.getText()) || "Số Lượng từ...".equals(txsltu.getText())) {
                    sltu = 0;
                } else {
                    sltu = Integer.valueOf(txsltu.getText());
                }

                if ("".equals(txslden.getText()) || "Số Lượng đến...".equals(txslden.getText()) ) {
                    slden = 1000;
                } else {
                    slden = Integer.valueOf(txslden.getText());
                }

                SachBUS bus = new SachBUS();
                if (SachBUS.dssp == null) {
                    bus.docDSSP();
                }
                ArrayList<SachDTO> dstk = new ArrayList<>();
                dstk = bus.Timkiemnangcao(giatu, giaden, sltu, slden);

                model.setRowCount(0);
                table.setModel(model);
                for (SachDTO sp : dstk) {
//                    header.add("Mã SP");
//        header.add("Mã Tác giả");
//        header.add("Mã Loại");
//        header.add("Mã NXB");
//        header.add("Mã NCC");
//        header.add("Tên");
//        header.add("Giá");
//        header.add("Số lượng");
                    Vector row = new Vector();
                    row.add(sp.getMasach());
                    row.add(sp.getMatg());
                    row.add(sp.getMaloai());
                    row.add(sp.getManxb());
                    row.add(sp.getMancc());                   
                    row.add(sp.getTensach());
                    row.add(Chuyentien(String.valueOf(sp.getDongia())));
                    row.add(sp.getSoluong());
                    model.addRow(row);
                    table.setModel(model);
                }

            } catch (NumberFormatException x) {
                JOptionPane.showMessageDialog(null, "Chỉ nhập số khi tìm kiếm");
            }
        }
    }
//    public static void main(String[] args) {
//        SachGUI a=new SachGUI();
//        JFrame f=new JFrame();
//        f.setSize(1500,1000);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(a);
//        f.setVisible(true);
//    }
}

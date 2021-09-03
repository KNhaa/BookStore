/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

/**
 *
 * @author DELL
 */
//import static AdminGUI.NhanVienGUI.txtentk;
import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
//import GUI.DuyetGUI.DuyetKHGUI;
// GUI.DuyetGUI.DuyetSPGUI;
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
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TaiKhoanGUI extends JPanel {

    DefaultTableModel model;
    public static JTextField txmapbh, txmakh, txmasp;
    JTextField txngaybd, txtgbaohanh, txtimkiem, txngaytu, txngayden, txtentk, txvaitro, txtrangthai, txpass;
    JLabel lbinfotk, lbtimkiem, lbicon, lbanh, lbtop, lbexit, lbtentk, lbvaitro, lbtrangthai, lbpass;
    JButton khoa, huykhoa, exit, them, reset;
    JTable table;
    JComboBox cb;
    int choice = 0;
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
    Font fonttxt = new Font("Segoe UI", Font.PLAIN, 20);
    Font fonttknc = new Font("Segoe UI", Font.PLAIN, 15);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    // ArrayList<BaoHanhDTO> printList = new ArrayList<BaoHanhDTO>();
    int change = 0;

    public TaiKhoanGUI() {

        //this.setSize(1350, 945);
        this.setSize(950, 700);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));

        lbinfotk = new JLabel("Tài khoản");
        lbinfotk.setBounds(30, 80, 200, 60);
        lbinfotk.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //lbinfokh.setForeground(new Color(30, 215, 96));
        lbinfotk.setForeground(new Color(31,73,91));
        
        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 1350, 65);
        //lbtop.setBackground(new Color(18, 18, 18));
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);

        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(70, 18, 250, 32);
        txtimkiem.setBorder(border);

        //String choose[] = {"Tên Tài Khoản", "Mật Khẩu"};
        String choose[] = {"Tên Tài Khoản", "Vai Trò", "Trạng thái"};
        cb = new JComboBox(choose);
        cb.setBounds(340, 18, 130, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);
        cb.setBackground(new Color(255, 255, 255));
        lbexit = new JLabel();
        lbexit.setBackground(new Color(33, 33, 33));
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

        TaiKhoanBUS bustk = new TaiKhoanBUS();
        if (TaiKhoanBUS.dstk == null) {
            bustk.docDSTaiKhoan();
        }

        khoa = new JButton("Khóa");
        khoa.setBounds(30, 400, 130, 50);
        //khoa.setBackground(new Color(30, 210, 96));
        khoa.setBackground(new Color(31,73,91));
        khoa.setForeground(new Color(235, 235, 235));
        khoa.setFont(font);
        khoa.setBorder(bordernull);
        khoa.setFocusPainted(false);
        khoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn khóa tài khoản người dùng", "Khóa", dialogButton);
                if (dialogResult == 0) {
                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        if (String.valueOf(table.getValueAt(i, 1)).equals(0)) {
                            JOptionPane.showMessageDialog(null, "Tài khoản này đã khóa rồi hãy chọn cái khác");

                        } else {
                            TaiKhoanDTO tk = new TaiKhoanDTO();
                            tk.setTentaikhoan(String.valueOf(table.getValueAt(i, 0)));
                            tk.setVaitro(bustk.returnVT(tk.getTentaikhoan()));
                            tk.setTrangthai(0);
                            tk.setMatkhau(bustk.returnMK(tk.getTentaikhoan()));
                            TaiKhoanBUS tkbus = new TaiKhoanBUS();
                            tkbus.Sua(tk);

                            model.setValueAt("0", i, 2);
                            table.setModel(model);
                            JOptionPane.showMessageDialog(null, "Khóa tài khoản thành công!");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Chọn dòng để khóa tài khoản");
                    }
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
                khoa.setBounds(30, 400, 130, 47);
                //khoa.setBackground(Color.RED);
                khoa.setBackground( new Color(134, 174, 195));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                khoa.setBounds(30, 400, 130, 50);
                //khoa.setBackground(new Color(30, 210, 96));
                khoa.setBackground(new Color(31,73,91));
            }

        });
        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        them = new JButton();
        //them.setBounds(770, 340, 130, 50);
        them.setBounds(400, 400, 130, 50);
        //them.setBackground(new Color(33, 33, 33));
        them.setBackground(new Color(237,241,255));
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

        huykhoa = new JButton("Hủy khóa");
        huykhoa.setBounds(200, 400, 130, 50);
        //huykhoa.setBackground(new Color(30, 210, 96));
        huykhoa.setBackground(new Color(31,73,91));
        huykhoa.setFont(font);
        huykhoa.setForeground(new Color(235, 235, 235));
        huykhoa.setBorder(bordernull);
        huykhoa.setFocusPainted(false);
        huykhoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy khóa tài khoản người dùng", "Hủy khóa", dialogButton);
                if (dialogResult == 0) {
                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        if (String.valueOf(table.getValueAt(i, 1)).equals("1")) {
                            JOptionPane.showMessageDialog(null, "Tài khoản này chưa được khóa");
                        } else {
                            TaiKhoanDTO tk = new TaiKhoanDTO();
                            tk.setTentaikhoan(String.valueOf(table.getValueAt(i, 0)));
                            tk.setMatkhau(bustk.returnMK(tk.getTentaikhoan()));
                            tk.setVaitro(bustk.returnVT(tk.getTentaikhoan()));
                            tk.setTrangthai(1);

                            TaiKhoanBUS bus = new TaiKhoanBUS();
                            bus.Sua(tk);

                            model.setValueAt("1", i, 2);
                            table.setModel(model);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Chọn dòng để hủy khóa tài khoản");
                    }
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
                huykhoa.setBounds(200, 400, 130, 47);
                //huykhoa.setBackground(Color.RED);
                huykhoa.setBackground( new Color(134, 174, 195));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                huykhoa.setBounds(200, 400, 130, 50);
                //huykhoa.setBackground(new Color(30, 210, 96));
                huykhoa.setBackground(new Color(31,73,91));
            }

        });

        lbtentk = new JLabel("Tên TK :", JLabel.LEFT);
        lbtentk.setBounds(30, 155, 155, 50);
        lbtentk.setFont(font1);
        //lbmakh.setForeground(new Color(255, 255, 255));
        //lbtentk.setForeground(new Color(173, 216, 230));
        lbtentk.setForeground(new Color(33, 33, 33));
        txtentk = new JTextField(18);
        txtentk.setFont(font);
        txtentk.setBounds(230, 155, 200, 40);
        txtentk.setBorder(border);
        txtentk.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtentk.setBounds(230, 155, 200, 40);
                txtentk.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtentk.setBorder(bordernull);
                if (txtentk.getText().equals("")) {
                    txtentk.setBounds(230, 155, 200, 40);
                } else {
                    txtentk.setBounds(230, 155, 200, 40);
                }
            }
        });
        lbvaitro = new JLabel("Vai Trò :", JLabel.LEFT);
        //lbvaitro.setBounds(700, 165, 155, 50);
        lbvaitro.setBounds(550, 165, 155, 50);
        lbvaitro.setFont(font1);
        lbvaitro.setForeground(new Color(33, 33, 33));
      
        String choosevaitro[] = {"---", "Admin", "User"};
        JComboBox cbvaitro = new JComboBox(choosevaitro);
        cbvaitro.setBounds(700, 165, 120, 40);
        cbvaitro.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cbvaitro.setBorder(border);
        cbvaitro.setBackground(new Color(255, 255, 255));

        lbtrangthai = new JLabel("Trạng Thái :", JLabel.LEFT);
        lbtrangthai.setBounds(30, 250, 175, 50);
        lbtrangthai.setFont(font1);
        //lbmakh.setForeground(new Color(255, 255, 255));
        //lbtrangthai.setForeground(new Color(173, 216, 230));
        lbtrangthai.setForeground(new Color(33, 33, 33));
        txtrangthai = new JTextField(18);
        txtrangthai.setFont(font);
        txtrangthai.setBounds(230, 250, 200, 40);
        txtrangthai.setBorder(border);
        txtrangthai.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtrangthai.setBounds(230, 250, 200, 40);
                txtrangthai.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtrangthai.setBorder(bordernull);
                if (txtrangthai.getText().equals("")) {
                    txtrangthai.setBounds(230, 250, 200, 30);
                } else {
                    txtrangthai.setBounds(230, 250, 200, 40);
                }
            }
        });
        lbpass = new JLabel("Mật Khẩu :", JLabel.LEFT);
        lbpass.setBounds(550, 250, 175, 50);
        lbpass.setFont(font1);
        //lbpass.setForeground(new Color(173, 216, 230));
        lbpass.setForeground(new Color(33, 33, 33));
        txpass = new JTextField(18);
        txpass.setFont(font);
        //txpass.setBounds(850, 250, 200, 40);
        txpass.setBounds(700, 250, 200, 40);
        txpass.setBorder(border);


        Vector header = new Vector();
        header.add("Tên tài khoản");
        header.add("Vai trò");
        header.add("Trạng thái");
        header.add("Mật khẩu");
        model = new DefaultTableModel(header, 0);
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        //table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(30);

        JScrollPane bangsp = new JScrollPane(table);
        bangsp.setBounds(30, 490, 900, 200);

        TaiKhoanBUS tkbus = new TaiKhoanBUS();
        tkbus.docDSTaiKhoan();
        for (TaiKhoanDTO tk : TaiKhoanBUS.dstk) {
            Vector row = new Vector();
            row.add(tk.getTentaikhoan());
            //row.add(user.getPass());
            row.add(tk.getVaitro());
            row.add(tk.getTrangthai());
            row.add(tk.getMatkhau());
            model.addRow(row);
        }
        table.setModel(model);
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent evt) {
//              
//            }
//        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int i = table.getSelectedRow();
                String code = (table.getValueAt(i, 0).toString());
                TaiKhoanBUS bus = new TaiKhoanBUS();
                TaiKhoanDTO tk = bus.getInfoRow(code);
                txtentk.setText(tk.getTentaikhoan());              
                if (tk.getVaitro().equals("Admin")) {
                    cbvaitro.setSelectedIndex(1);
                } else {
                    cbvaitro.setSelectedIndex(2);
                }
                txtrangthai.setText(String.valueOf(tk.getTrangthai()));
                txpass.setText(String.valueOf(tk.getMatkhau()));
                txtrangthai.setBounds(230, 250, 200, 40);
                           
            }
        });

        them.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm tài khoản", "Thêm", dialogButton);
                if (dialogResult == 0) 
                {

                    if (txtentk.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Tên TK không được để trống");
                        return ;
                    } 
                    else 
                    {
                        String pattern = "^[^!@#$?<>.*:;,/\\-+=()]{1,}$";
                        if (!Pattern.matches(pattern, txtentk.getText())) 
                        {
                            JOptionPane.showMessageDialog(null, "Tên tài khoản không hợp lệ");
                            return ;
                        } 
                    }
                    
                    if (txpass.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Xin nhập mật khẩu!");
                        return ;
                    } 
                    else {
                        // String pattern ="^[\\d!@#$%^&*()\"{}<>~,+-_=?.\':;|]{1,}";
                        String pattern = "^[^!@#$?<>.*:;,/\\-+=()]{1,}$";
                        if (!Pattern.matches(pattern, txpass.getText())) 
                        {
                            JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ");
                            return ;
                        }
                    }
                    if (txtrangthai.getText().equals("")) 
                    {
                        JOptionPane.showMessageDialog(null, "Không được để trống trạng thái");
                        return;
                    } else 
                    {
                        String pattern = "^[0]{1,1}$";
                        if (!Pattern.matches(pattern, txtrangthai.getText().toString())) 
                        {
                            JOptionPane.showMessageDialog(null, "Trạng thái chỉ được nhập 0");
                            return;
                        }
                    }

                    if (cbvaitro.getSelectedItem().toString().equals("---")) 
                    {
                        JOptionPane.showMessageDialog(null, "Vai trò không được để trống");
                        return;
                    }

                    TaiKhoanDTO tk = new TaiKhoanDTO();
                    
                    tk.setTentaikhoan(txtentk.getText());                   
                    tk.setVaitro(cbvaitro.getSelectedItem().toString());
                    tk.setTrangthai(Integer.parseInt(txtrangthai.getText()));
                    tk.setMatkhau(txpass.getText());
                    
                    TaiKhoanBUS bus = new TaiKhoanBUS();
                   
                    if (!bus.Them(tk)) { //sai la dung lai luon
                        //JOptionPane.showMessageDialog(null,"Thêm không thành công!");
                        return;
                    }
                    Vector row = new Vector();
                    row.add(tk.getTentaikhoan());
                    row.add(tk.getVaitro());
                    row.add(tk.getTrangthai());
                    row.add(tk.getMatkhau());
                    model.addRow(row);
                    table.setModel(model);
                    txtentk.setText("");                  
                    cbvaitro.setSelectedIndex(0);
                    txtrangthai.setText("");
                    txpass.setText("");
                   
                }
                }                    
        });
        
        ImageIcon hinhreset = new ImageIcon(getClass().getResource("/HinhAnh/reset.png"));
        ImageIcon hinhreset1 = new ImageIcon(getClass().getResource("/HinhAnh/reset2.png"));
        reset = new JButton();
        //reset.setBounds(1140, 340, 125, 50);
        //reset.setBounds(610, 400, 125, 60);
        reset.setBounds(610, 400, 130, 50);       
        //reset.setBackground(new Color(33, 33, 33));
        reset.setBackground(new Color(237,241,255));
        reset.setBorder(bordernull);
        reset.setIcon(hinhreset);
        reset.setFocusPainted(false);
        reset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtentk.setText("");
                txtentk.setEditable(true);
                //txvaitro.setText("");
                cbvaitro.setSelectedIndex(0);
                txtrangthai.setText("");
                txpass.setText("");             
                them.setVisible(true);

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

        this.add(lbtentk);
        this.add(txtentk);
        this.add(lbvaitro);
        this.add(cb);
        this.add(cbvaitro);
        this.add(lbtrangthai);
        this.add(txtrangthai);
        this.add(lbpass);
        this.add(txpass);
        this.add(lbinfotk);
        this.add(lbtop);

        this.add(bangsp);
        this.add(khoa);
        this.add(huykhoa);
        this.add(them);
        this.add(reset);

        // this.add(resetpass);
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

    }

//    public static void main(String[] args) {
//        TaiKhoanGUI a = new TaiKhoanGUI();
//        //a.setVisible(true);
//        JFrame f = new JFrame();
//        //f.setSize(1500, 800);
//        f.setSize(950, 700);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(a);
//        f.setVisible(true);
//    }
}

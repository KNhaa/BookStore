/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import BUS.UserBUS;
//import DTO.UserDTO;
import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author acer
 */
public class LoginFrame extends JFrame {

    JLabel lblogin, lbtaikhoan, lbmatkhau, lbthoat, hinhtaikhoan, hinhmatkhau, dangnhap;
    JTextField taikhoan;
    JPasswordField matkhau;
    JPanel pn1;
    JLabel background;

    public LoginFrame() {
        ImageIcon img = new ImageIcon("src/HinhAnh/employee.png");
        this.setIconImage(img.getImage());
        this.setUndecorated(true);
        this.setSize(480, 480);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void ShowBang() {

        Border border = BorderFactory.createLineBorder(new Color(218, 222, 229), 1);

        ImageIcon imgbg = new ImageIcon(getClass().getResource("/HinhAnh/bg1.jpg"));
        background = new JLabel();
        background.setIcon(imgbg);
        background.setBounds(0, 0, 480, 480);

        //ImageIcon imglogin = new ImageIcon(getClass().getResource("/HinhAnh/login.png"));
        lblogin = new JLabel();
        lblogin.setBounds(135, 70, 220, 60);
        //lblogin.setIcon(imglogin);
        lblogin.setOpaque(false);
        lblogin.setText("ĐĂNG NHẬP");
        lblogin.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lblogin.setForeground(Color.white);

        pn1 = new JPanel();
        pn1.setBounds(0, 0, 480, 480);
        pn1.setBackground(new Color(54, 33, 89));
        pn1.setLayout(null);
        pn1.setBorder(border);
        pn1.add(background);

        lbthoat = new JLabel("X");
        lbthoat.setFont(new Font("Segoe UI", Font.BOLD, 27));
        lbthoat.setForeground(new Color(218, 222, 229));
        lbthoat.setCursor(new Cursor(HAND_CURSOR));
        lbthoat.setBounds(440, 0, 50, 50);
        lbthoat.addMouseListener(new MouseListener() {

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
                lbthoat.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbthoat.setForeground(new Color(218, 222, 229));
            }
        });

        taikhoan = new JTextField(18);
        taikhoan.setBounds(120, 200, 280, 40);
        taikhoan.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        taikhoan.setOpaque(false);
        taikhoan.setText("Tên tài khoản");
        taikhoan.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        taikhoan.setForeground(Color.white);
        taikhoan.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (taikhoan.getText().equals("Tên tài khoản")) {
                    taikhoan.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (taikhoan.getText().equals("")) {
                    taikhoan.setText("Tên tài khoản");
                }
            }
        });
        taikhoan.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    matkhau.requestFocus();//sau khi ấn ENTER ở textfield taikhoan thì sẽ nhảy xuống mật khẩu
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        ImageIcon imgtk = new ImageIcon(getClass().getResource("/HinhAnh/hinhtaikhoan.png"));
        hinhtaikhoan = new JLabel();
        hinhtaikhoan.setIcon(imgtk);
        hinhtaikhoan.setBounds(65, 205, 40, 40);
        hinhtaikhoan.setOpaque(false);

        matkhau = new JPasswordField(18);
        matkhau.setBounds(120, 280, 280, 40);
        matkhau.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        matkhau.setText("Password");
        matkhau.setFont(new Font("Segoe UI", Font.PLAIN, 27));
        matkhau.setForeground(Color.white);
        matkhau.setOpaque(false);
        matkhau.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (matkhau.getText().equals("Password")) {
                    matkhau.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (matkhau.getText().equals("")) {
                    matkhau.setText("Password");
                }
            }

        });
        matkhau.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
//                {
//                    String passtext = new String(matkhau.getPassword());
//                    if (taikhoan.getText().equals("") && passtext.equals("")) 
//                    {
//                        JOptionPane.showMessageDialog(null, "Không được để trống thông tin đăng nhập");
//                    } else if (taikhoan.getText().equals("manager") && passtext.equals("manager")) 
//                        {
//                        AdminFrame manager = new AdminFrame();
//                        manager.ShowBang();
//                        setVisible(false);
//                        } 
//                }
            }

//            else 
//            {
//               
//            
//             UserBUS bususer = new UserBUS();
//                bususer.docDSuser();
//                UserDTO user = new UserDTO();
//                user = bususer.Tim(taikhoan.getText());
//                if(user == null) JOptionPane.showMessageDialog(null, "Tên tài khoản không tồn tại");
//                else if(user.getTrangthai().equals("Khóa")) JOptionPane.showMessageDialog(null, "Tài khoản bị khóa vui lòng liên hệ cho quản lý");
//                else if (taikhoan.getText().equals(user.getId()) && passtext.equals(user.getPass()))
//                {
//                    GiaoDienStaff staff = new GiaoDienStaff();
//                    staff.ShowBang(taikhoan.getText());
//                    setVisible(false);
//                }
//                else JOptionPane.showMessageDialog(null, "Mật khẩu sai");
//            }
//                }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        ImageIcon imgmk = new ImageIcon(getClass().getResource("/HinhAnh/hinhmatkhau.png"));
        hinhmatkhau = new JLabel();
        hinhmatkhau.setIcon(imgmk);
        hinhmatkhau.setBounds(65, 285, 40, 40);
        hinhmatkhau.setOpaque(false);

        ImageIcon imgdangnhap = new ImageIcon(getClass().getResource("/HinhAnh/vo.png"));
        ImageIcon imgdangnhap2 = new ImageIcon(getClass().getResource("/HinhAnh/vo2.png"));
        dangnhap = new JLabel();
        dangnhap.setBounds(210, 370, 60, 60);
        dangnhap.setIcon(imgdangnhap2);
        dangnhap.setOpaque(false);
        dangnhap.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TaiKhoanBUS tkbus = new TaiKhoanBUS();
                tkbus.docDSTaiKhoan();
                String password = new String(matkhau.getPassword());
                if (taikhoan.getText().equals("Tên tài khoản") || password.equals("Password")) 
                {
                    JOptionPane.showMessageDialog(null, "Không được để trống thông tin đăng nhập");
                } 
                else 
                {                    
                    TaiKhoanDTO tk = new TaiKhoanDTO();
                    tk = tkbus.timTaikhoan(taikhoan.getText(), password);

                    //String vaitro = tkbus.timTaiKhoan(taikhoan.getText(), password);
                    if (tk == null)//if(vaitro==null)
                    {
                        JOptionPane.showMessageDialog(null, "Đăng nhập không thành công");
                        return;
                    } 
                    else 
                    {
                        //TaiKhoanDTO tk = tkbus.timTaikhoan(taikhoan.getText(), password); // kiem tra tai khoan bi khoa             
                        if (tk.getTrangthai() == 0) 
                        {
                            JOptionPane.showMessageDialog(null, "Tài khoản đã bị khóa");
                            return;
                        }
                        
                        if ("Admin".equals(tk.getVaitro()))//if(vaitro.equals("Admin"))
                        {                                              
                            AdminFrame employee = new AdminFrame();
                            employee.ShowBang();
                            setVisible(false);
                        } 
                        else 
                        {
                            if (tk.getVaitro().equals("User"))//if(vaitro.equals("User"))
                            {
                                NhanVienBUS nvbus = new NhanVienBUS();
                                nvbus.readDSNV();
                                NhanVienDTO nv = nvbus.timNhanVien(taikhoan.getText());
                                if (nv == null) // tồn tại tài khoản đó nhưng không thuộc về nhân viên nào
                                {
                                    JOptionPane.showMessageDialog(null, "Tài khoản chưa được sử dụng");
                                } else 
                                {
                                    EmployeeFrame employee = new EmployeeFrame();
                                    employee.ShowBang(nv.getManv());
                                    setVisible(false);
                                }
                            }
                        }
                    }
                }
            }
//                    String vaitro = tkbus.timTaiKhoanVT(taikhoan.getText(), password);                   
//                    if(vaitro.equals("Admin"))
//                    {
//                        AdminFrame employee = new AdminFrame();
//                        employee.ShowBang();
//                        setVisible(false);
//                    }
//                    else
//                    {
//                        if(vaitro.equals("User"))
//                        {
//                            NhanVienBUS nvbus = new NhanVienBUS();
//                            nvbus.readDSNV();
//                            NhanVienDTO nv = nvbus.timNhanVien(taikhoan.getText());
//                            if (nv == null) // tồn tại tài khoản đó nhưng không thuộc về nhân viên nào
//                            {
//                                JOptionPane.showMessageDialog(null, "Tài khoản chưa được sử dụng");
//                            } else {
//                                EmployeeFrame employee = new EmployeeFrame();
//                                employee.ShowBang(nv.getManv());
//                                setVisible(false);
//                            }
//                        }
//                    }
//                    }
                    
                    

            
            

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dangnhap.setIcon(imgdangnhap);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dangnhap.setIcon(imgdangnhap2);
            }
        });

        background.add(lbthoat);
        background.add(lblogin);
        background.add(taikhoan);
        background.add(matkhau);
        background.add(hinhtaikhoan);
        background.add(hinhmatkhau);
        background.add(dangnhap);

        this.add(pn1);
        this.repaint();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //UIManager.setLookAndFeel( "com.seaglasslookandfeel.SeaGlassLookAndFeel" );
        LoginFrame test = new LoginFrame();
        test.ShowBang();
    }

}

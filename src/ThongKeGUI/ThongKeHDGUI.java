/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKeGUI;

import BUS.ThongKeHDBUS;
import DTO.ThongKeHDDTO;
import javax.swing.*;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author acer
 */
public class ThongKeHDGUI extends JPanel {

    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border bordertt = BorderFactory.createLineBorder(new Color(235, 235, 235), 1);
    Border bordertk = BorderFactory.createLineBorder(new Color(30, 30, 30), 1);
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font font = new Font("Segoe UI", Font.BOLD, 22);
    TitledBorder ttcontent2 = new TitledBorder("Thống kê doanh thu");
    JTable table;
    DefaultTableModel model;
    JLabel timkiemnc;
    JComboBox cbtheo;
    int choicetheo;
    JComboBox cbthang;
    int choicethang;
    JComboBox cbmua;
    int choicemua;
    JComboBox cbnam;
    int choicenam;
    JButton timkiem;
    JTextField txtimkiem;
    JLabel hienthi;
    JComboBox cbhienthi;
    int choicehienthi;

    public ThongKeHDGUI() {

        this.setSize(930, 400);
        this.setBackground(new Color(33, 33, 33));
        this.setBorder(ttcontent2);
        this.setLayout(null);
        ttcontent2.setBorder(bordertt);
        ttcontent2.setTitleJustification(TitledBorder.LEFT);
        ttcontent2.setTitlePosition(TitledBorder.TOP);
        ttcontent2.setTitleColor(new Color(255, 255, 255));
        ttcontent2.setTitleFont(fontt);

        txtimkiem = new JTextField("Tìm kiếm...");
        txtimkiem.setFont(font);
        txtimkiem.setForeground(Color.GRAY);
        txtimkiem.setBounds(30, 40, 250, 32);
        txtimkiem.setBorder(border);
        txtimkiem.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtimkiem.getText().equals("Tìm kiếm...")) {
                    txtimkiem.setText("");
                    txtimkiem.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtimkiem.getText().isEmpty()) {
                    txtimkiem.setForeground(Color.GRAY);
                    txtimkiem.setText("Tìm kiếm...");
                }
            }
        });

        String choosetheo[] = {"Theo Mã SP", "Theo Tên SP", "Theo Thu Nhập", "Theo SL Bán"};
        cbtheo = new JComboBox(choosetheo);
        cbtheo.setBounds(300, 40, 150, 32);
        cbtheo.setFont(font);
        cbtheo.setBorder(border);
        cbtheo.setBackground(new Color(255, 255, 255));

        timkiemnc = new JLabel("Tìm kiếm NC");
        timkiemnc.setBounds(500, 40, 150, 32);
        timkiemnc.setFont(font);
        timkiemnc.setForeground(new Color(255, 255, 255));

        String choosemua[] = {"Quý", "1", "2", "3", "4"};
        cbmua = new JComboBox(choosemua);
        //cbmua.setBounds(700, 40, 100, 32);
        cbmua.setBounds(500, 80, 80, 32);       
        cbmua.setFont(font);
        cbmua.setBorder(border);
        cbmua.setBackground(new Color(255, 255, 255));

        String choosethang[] = {"Tháng ", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12"};
        cbthang = new JComboBox(choosethang);
        //cbthang.setBounds(850, 40, 120, 32);
        cbthang.setBounds(610, 80, 100, 32);
        cbthang.setFont(font);
        cbthang.setBorder(border);
        cbthang.setBackground(new Color(255, 255, 255));

        String choosenam[] = {"2018", "2019", "2020"};
        cbnam = new JComboBox(choosenam);
        //cbnam.setBounds(1020, 40, 100, 32);
        cbnam.setBounds(730, 80, 100, 32);
        cbnam.setFont(font);
        cbnam.setBorder(border);
        cbnam.setBackground(new Color(255, 255, 255));

        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));
        timkiem = new JButton();
        //timkiem.setBounds(1150, 40, 32, 32);
        timkiem.setBounds(855, 80, 32, 32);
        timkiem.setBackground(new Color(33, 33, 33));
        timkiem.setIcon(hinhtimkiem);
        timkiem.setFont(new Font("Segoe UI", Font.BOLD, 20));
        timkiem.setFocusPainted(false);
        timkiem.setCursor(new Cursor(HAND_CURSOR));
        timkiem.setBorder(bordernull);

        hienthi = new JLabel("Hiển thị");
        hienthi.setBounds(30, 80, 100, 32);
        hienthi.setFont(font);
        hienthi.setForeground(new Color(255, 255, 255));

        String choosehienthi[] = {"Tất cả SP", "SP chưa bán", "SP đã bán"};
        cbhienthi = new JComboBox(choosehienthi);
        cbhienthi.setBounds(150, 80, 200, 32);
        cbhienthi.setFont(font);
        cbhienthi.setBorder(border);
        cbhienthi.setBackground(new Color(255, 255, 255));

        this.add(timkiemnc);
        this.add(txtimkiem);
        this.add(cbtheo);
        this.add(cbnam);
        this.add(cbthang);
        this.add(cbmua);
        this.add(timkiem);
        this.add(hienthi);
        this.add(cbhienthi);

        Vector header = new Vector();
        header.add("Mã SP");
        header.add("Tên");
        header.add("Tổng thu nhập");
        header.add("Tổng lượng bán");
        model = new DefaultTableModel(header, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 3:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(40);

        //table.setAutoCreateRowSorter(true);
        JScrollPane bangsp = new JScrollPane(table);
        bangsp.setBounds(10, 120, 900, 260);

        this.add(bangsp);

        this.repaint();
        this.revalidate();
        setEvent();
    }

    public void setEvent() {
        ThongKeHDBUS bustksp = new ThongKeHDBUS();
        if (ThongKeHDBUS.dstkhd == null) {
            bustksp.docDSTKHD();
        }
        int S=0;
        int T=0;
        for (ThongKeHDDTO tksp : ThongKeHDBUS.dstkhd) {
            Vector row = new Vector();
            row.add(tksp.getMasach());
            row.add(tksp.getTensach());
            row.add(Chuyentien(String.valueOf(tksp.getTongthunhap())));
            row.add(tksp.getTongluongban());
            model.addRow(row);
             S=S+tksp.getTongthunhap();
              T=T+tksp.getTongthunhap();
        }
        System.out.println("Tổng tiền là"+S);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(S)));
                 Vector row3 = new Vector();
            row3.add("Tổng thu nhập");
            row3.add("-----------------------");     
            
            row3.add(Chuyentien(String.valueOf(S)));
             row3.add(T);     
            model.addRow(row3);
        table.setModel(model);
        //Hiển thị SP
        cbhienthi.addActionListener((ActionEvent e) -> {
            choicehienthi = cbhienthi.getSelectedIndex();
            if (choicehienthi == 0) {
                model.setRowCount(0);
                table.setModel(model);
                int s=0;
                int t=0;
                for (ThongKeHDDTO tkhd : ThongKeHDBUS.dstkhd) {

                    Vector row = new Vector();
                    row.add(tkhd.getMasach());
                    row.add(tkhd.getTensach());
                    row.add(Chuyentien(String.valueOf(tkhd.getTongthunhap())));
                    row.add(tkhd.getTongluongban());
                    model.addRow(row);
            s=s+tkhd.getTongthunhap();
            t=t+tkhd.getTongluongban();
                }
                 System.out.println("Tổng tiền là"+s);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(s)));
                 Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("--------------");     
            
            row2.add(Chuyentien(String.valueOf(s)));
             row2.add(t);     
            model.addRow(row2);
                table.setModel(model);
            }
            if (choicehienthi == 1) {
                model.setRowCount(0);
                table.setModel(model);
                int s=0;
                int t=0;
                for (ThongKeHDDTO tkhd : ThongKeHDBUS.dstkhd) {
                    if (tkhd.getTongluongban() == 0) {
                        Vector row = new Vector();
                        row.add(tkhd.getMasach());
                        row.add(tkhd.getTensach());
                        row.add(Chuyentien(String.valueOf(tkhd.getTongthunhap())));
                        row.add(tkhd.getTongluongban());
                        model.addRow(row);
                         s=s+tkhd.getTongthunhap();
                         t=t+tkhd.getTongthunhap();
                    }
                }
                 System.out.println("Tổng tiền là"+s);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(s)));
                 Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("---------------------");     
            
            row2.add(Chuyentien(String.valueOf(s)));
             row2.add(t);     
            model.addRow(row2);
            table.setModel(model);
               
            }
            if (choicehienthi == 2) {
                model.setRowCount(0);
                table.setModel(model);
                int s=0;
                int t=0;
                for (ThongKeHDDTO tkhd : ThongKeHDBUS.dstkhd) {
                    if (tkhd.getTongluongban() != 0) {
                        Vector row = new Vector();
                        row.add(tkhd.getMasach());
                        row.add(tkhd.getTensach());
                        row.add(Chuyentien(String.valueOf(tkhd.getTongthunhap())));
                        row.add(tkhd.getTongluongban());
                        model.addRow(row);
                        s=s+tkhd.getTongthunhap();
                        t=t+tkhd.getTongthunhap();
                    }
                }
                System.out.println("Tổng tiền là"+s);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(s)));
                 Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("------------------");     
            
            row2.add(Chuyentien(String.valueOf(s)));
             row2.add(t);     
            model.addRow(row2);
            table.setModel(model);
               
            }
        });
        //Tìm kiếm nâng cao Start (Cái này chua nhất )

        //Lọc đầu vào tìm kiếm
        cbthang.addActionListener((ActionEvent e) -> {
            choicethang = cbthang.getSelectedIndex();
            if (choicethang > 0) {
                cbmua.setEnabled(false);
            } else {
                cbmua.setEnabled(true);
            }
        });

        cbmua.addActionListener((ActionEvent e) -> {
            choicemua = cbmua.getSelectedIndex();
            if (choicemua > 0) {
                cbthang.setEnabled(false);
            } else {
                cbthang.setEnabled(true);
            }
        });

        //Tìm kiếm thường
        cbtheo.addActionListener((ActionEvent e) -> {
            choicetheo = cbtheo.getSelectedIndex();
        });

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        txtimkiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtimkiem.getText().equals("Tìm kiếm...")) {
                } else {
                    try {
                        String text = txtimkiem.getText();
                        if (choicetheo == 2) {
                            if (text.trim().length() == 0) {
                                rowSorter.setRowFilter(null);
                            } else {
                                rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choicetheo));
                            }
                        }
                        if (choicetheo == 3) {
                            if (text.trim().length() == 0) {
                                rowSorter.setRowFilter(null);
                            } else {
                                rowSorter.setRowFilter(RowFilter.regexFilter("^" + text + "$", choicetheo));
                            }
                        }
                        if (choicetheo != 2 && choicetheo != 3) {
                            if (text.trim().length() == 0) {
                                rowSorter.setRowFilter(null);
                            } else {
                                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, choicetheo));
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Khi tìm kiếm theo giá buộc phải nhập số");
                    }
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtimkiem.getText().equals("Tìm kiếm...")) {
                } else {
                    try {
                        String text = txtimkiem.getText();
                        if (choicetheo == 2) {
                            if (text.trim().length() == 0) {
                                rowSorter.setRowFilter(null);
                            } else {
                                rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choicetheo));
                            }
                        }
                        if (choicetheo == 3) {
                            if (text.trim().length() == 0) {
                                rowSorter.setRowFilter(null);
                            } else {
                                rowSorter.setRowFilter(RowFilter.regexFilter("^" + text + "$", choicetheo));
                            }
                        }
                        if (choicetheo != 2 && choicetheo != 3) {
                            if (text.trim().length() == 0) {
                                rowSorter.setRowFilter(null);
                            } else {
                                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, choicetheo));
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Khi tìm kiếm theo giá buộc phải nhập số");
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        cbnam.addActionListener((ActionEvent e) -> {
                choicenam = cbnam.getSelectedIndex();
            });
        timkiem.addActionListener((ActionEvent e) -> {
            try {
                
                if(choicethang != 0) 
                {
                    //System.out.println("Không làm việc");
                    theothang();
                }
                else if(choicemua != 0)
                {
                    theoquy();
                }
                else
                {
                    theonam();
                }
                
                
            } catch (ParseException ex) {
                Logger.getLogger(ThongKeHDGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void theonam() throws ParseException {
        
        ThongKeHDBUS bustkhd = new ThongKeHDBUS();
        bustkhd.docDSTKHDtheonam(String.valueOf(cbnam.getItemAt(choicenam)));
        
        model.setRowCount(0);
        table.setModel(model);
        
        int s=0;
        int t=0;
        for (ThongKeHDDTO tkhd : ThongKeHDBUS.dstkhdtheonam) {
            if (tkhd.getTongluongban() != 0) {
                Vector row = new Vector();
                row.add(tkhd.getMasach());
                row.add(tkhd.getTensach());
                row.add(Chuyentien(String.valueOf(tkhd.getTongthunhap())));
                row.add(tkhd.getTongluongban());
                model.addRow(row);
                 s=s+tkhd.getTongthunhap();
                  t=t+tkhd.getTongluongban();
            }
        }
        System.out.println("Tổng tiền là"+s);
            System.out.println("Tổng sl là"+t);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(s)));
                 Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("-------------------");     
            
            row2.add(Chuyentien(String.valueOf(s)));
             row2.add(t);     
            model.addRow(row2);
        table.setModel(model);
    }
    
    public void theothang() throws ParseException {
        cbthang.addActionListener((ActionEvent e) -> {
            choicethang = cbthang.getSelectedIndex();
        });
        
        ThongKeHDBUS bustkhd = new ThongKeHDBUS();
        bustkhd.docDSTKHDtheothangnam(String.valueOf(cbthang.getItemAt(choicethang)), String.valueOf(cbnam.getItemAt(choicenam)));
        model.setRowCount(0);
        table.setModel(model);
           int s=0;
           int t=0;
        for (ThongKeHDDTO tkhd : ThongKeHDBUS.dstkhdtheothangnam) {
            if (tkhd.getTongluongban() != 0) {
                System.out.println(tkhd.getMasach());
                Vector row = new Vector();
                row.add(tkhd.getMasach());
                row.add(tkhd.getTensach());
                row.add(Chuyentien(String.valueOf(tkhd.getTongthunhap())));
                row.add(tkhd.getTongluongban());
                model.addRow(row);
                 s=s+tkhd.getTongthunhap();
                  t=t+tkhd.getTongluongban();
            }
            else
            {
//                System.out.println(tkhd.getMasp());
//                System.out.println(tkhd.getTongluongban());
            }
                
        }
        System.out.println("Tổng tiền là"+s);
        System.out.println("Tổng sl là"+t);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(s)));
                 Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("------------");     
            
            row2.add(Chuyentien(String.valueOf(s)));
             row2.add(t);     
            model.addRow(row2);
        table.setModel(model);
    }
    
    public void theoquy() throws ParseException {
        cbmua.addActionListener((ActionEvent e) -> {
            choicemua = cbmua.getSelectedIndex();
        });
        
        ThongKeHDBUS bustkhd = new ThongKeHDBUS();
        bustkhd.docDSTKHDtheoquynam(String.valueOf(cbmua.getItemAt(choicemua)), String.valueOf(cbnam.getItemAt(choicenam)));
        model.setRowCount(0);
        table.setModel(model);
        int s=0;
        int t=0;
        for (ThongKeHDDTO tkhd : ThongKeHDBUS.dstkhdtheoquynam) {
            if (tkhd.getTongluongban() != 0) {
                Vector row = new Vector();
                row.add(tkhd.getMasach());
                row.add(tkhd.getTensach());
                row.add(Chuyentien(String.valueOf(tkhd.getTongthunhap())));
                row.add(tkhd.getTongluongban());
                model.addRow(row);
                 s=s+tkhd.getTongthunhap();
                 t=t+tkhd.getTongluongban();
            }
        }
         System.out.println("Tổng tiền là"+s);
         System.out.println("Tổng sl là"+t);
                System.out.println("Tổng tiền là 1"+Chuyentien(String.valueOf(s)));
                 Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("------------");     
            
            row2.add(Chuyentien(String.valueOf(s)));
             row2.add(t);     
            model.addRow(row2);
        table.setModel(model);
    }

    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }
public static void main(String[] args) {
        ThongKeHDGUI a=new ThongKeHDGUI();
            //a.setVisible(true);
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }
}

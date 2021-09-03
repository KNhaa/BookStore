/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKeGUI;
import BUS.HoaDonTKBUS;
import BUS.NhanVienTKBUS;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
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
public class ThongKeNVGUI extends JPanel {
    
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border bordertt = BorderFactory.createLineBorder(new Color(235, 235, 235), 1);
    Border bordertk = BorderFactory.createLineBorder(new Color(30, 30, 30), 1);
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font font = new Font("Segoe UI", Font.BOLD, 22);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
     Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    DatePicker dPicker1,dPicker2;
    TitledBorder ttcontent2 = new TitledBorder("Thống kê nhân viên");
    JLabel chonnv,lbngaybd, lbngaykt ;
    JTextField txngaybd ,txngaykt  ;
    JComboBox cbnv;
    int choicenv;
    JTable table;
    DefaultTableModel model;
    
    public ThongKeNVGUI() {

        this.setSize(930, 400);
        this.setBackground(new Color(33, 33, 33));
        this.setBorder(ttcontent2);
        this.setLayout(null);
        ttcontent2.setBorder(bordertt);
        ttcontent2.setTitleJustification(TitledBorder.LEFT);
        ttcontent2.setTitlePosition(TitledBorder.TOP);
        ttcontent2.setTitleColor(new Color(255, 255, 255));
        ttcontent2.setTitleFont(fontt);        
        chonnv = new JLabel("Chọn nhân viên bán");
        chonnv.setBounds(50, 40, 250, 32);
        chonnv.setFont(font);
        chonnv.setForeground(new Color(255, 255, 255));    
        ArrayList <String> choosenv = new ArrayList<>();        
        NhanVienTKBUS busnv = new NhanVienTKBUS();
        if(NhanVienTKBUS.dsnv == null) busnv.readDSNVTKe();
        for(NhanVienDTO nv : NhanVienTKBUS.dsnv)
        {
            choosenv.add(nv.getManv());
        }      
        String [] choose = choosenv.toArray(new String[choosenv.size()]);
        cbnv = new JComboBox(choose);
        //cbnv.setBounds(300, 40, 100, 32);
        cbnv.setBounds(100, 80, 100, 32);
        cbnv.setFont(font);
        cbnv.setBorder(border);
        cbnv.setBackground(new Color(255, 255, 255));
        
        this.add(chonnv);
        this.add(cbnv);
        
        Vector header = new Vector();
       // header.add("Mã NV");
        header.add("Họ và tên NV");
        header.add("Mã HĐ bán");
        header.add("Thu nhập HĐ");
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
        //table.getTableHeader().setBackground(new Color(30, 210, 96));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(40);

        //table.setAutoCreateRowSorter(true);
        JScrollPane bangnv = new JScrollPane(table);
        bangnv.setBounds(10, 120, 900, 270);

        this.add(bangnv);

        this.repaint();
        this.revalidate();
        setEvent();
    }

    public void setEvent() {
        NhanVienTKBUS busnv = new NhanVienTKBUS();
        if(NhanVienTKBUS.dsnv == null) busnv.readDSNVTKe();
        HoaDonTKBUS bushd = new HoaDonTKBUS();
        if(HoaDonTKBUS.dshd == null) bushd.docDSHD();
        
        cbnv.addActionListener((ActionEvent e) -> {
            model.setRowCount(0);
            table.setModel(model);
            for (HoaDonDTO hd : bushd.Thongkenv(String.valueOf(cbnv.getSelectedItem()))) 
            {
            Vector row = new Vector();
            //row.add(hd.getManv());
            row.add(busnv.Timtennv(hd.getManv()));
            row.add(hd.getMahd());
            row.add(Chuyentien(String.valueOf(hd.getThuctra())));
            model.addRow(row);
        }
            Vector row1 = new Vector();
            row1.add("--------------------------");
            row1.add("--------------------------");
            row1.add("--------------------------");
            row1.add("--------------------------");
            model.addRow(row1);
            Vector row2 = new Vector();
            row2.add("Tổng thu nhập");
            row2.add("");          
            row2.add(Chuyentien(String.valueOf(bushd.Tonghoadontheonv(String.valueOf(cbnv.getSelectedItem())))));
            model.addRow(row2);
            table.setModel(model);
        });
        
//        for (HoaDonDTO hd : bushd.Thongkenv("1"))
//        {
//            Vector row = new Vector();
//            //row.add(hd.getManv());
//            row.add(busnv.Timtennv(hd.getManv()));
//            row.add(hd.getMahd());
//            row.add(Chuyentien(String.valueOf(hd.getThuctra())));
//            model.addRow(row);
//        }
//        Vector row1 = new Vector();
//            row1.add("--------------------------");
//            row1.add("--------------------------");
//            row1.add("--------------------------");
//            row1.add("--------------------------");
//            model.addRow(row1);
//            Vector row2 = new Vector();
//            row2.add("Tổng thu nhập");
//            row2.add("");
//           // row2.add("");
//            //row2.add(Chuyentien(String.valueOf(bushd.Tonghoadontheonv("1"))));
//             row2.add(Chuyentien(String.valueOf(bushd.Tonghoadontheonv(""))));
//            model.addRow(row2);
//            table.setModel(model);
//            table.setModel(model);
        lbngaybd = new JLabel("Từ ngày: ", JLabel.LEFT);
        //lbngaybd.setBounds(440, 35, 140, 50);
        lbngaybd.setBounds(300, 35, 140, 50);
        lbngaybd.setFont(font1);
        lbngaybd.setForeground(new Color(255, 255, 255));
        txngaybd = new JTextField(18);
        txngaybd.setFont(font);
        //txngaybd.setBounds(550, 40, 100, 30);
        txngaybd.setBounds(300, 80, 100, 30);      
        txngaybd.setBorder(border);
       
        txngaybd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txngaybd.setBounds(550, 40, 100, 40);
                txngaybd.setBorder(borderinput);
            }
            @Override
            public void focusLost(FocusEvent e) {
                txngaybd.setBorder(bordernull);
                if (txngaybd.getText().equals("")) {
                    txngaybd.setBounds(550, 40, 100, 30);
                } else {
                    txngaybd.setBounds(550, 40, 100, 40);
                }
            }
        });
        lbngaykt = new JLabel("Đến ngày: ", JLabel.LEFT);
        //lbngaykt.setBounds(730, 35, 140, 50);
        lbngaykt.setBounds(550, 35, 140, 50);
        lbngaykt.setFont(font1);
        lbngaykt.setForeground(new Color(255, 255, 255));
        txngaykt = new JTextField(18);
        txngaykt.setFont(font);
        //txngaykt.setBounds(870, 40, 100, 30);
        txngaykt.setBounds(550, 80, 100, 30);
        txngaykt.setBorder(border);
       
        txngaykt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txngaykt.setBounds(950, 40, 100, 40);
                txngaykt.setBorder(borderinput);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txngaykt.setBorder(bordernull);
                if (txngaykt.getText().equals("")) {
                    txngaykt.setBounds(850, 40, 100, 30);
                } else {
                    txngaykt.setBounds(850, 40, 100, 40);
                }
            }
        });
        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setColor(DatePickerSettings.DateArea.TextClearLabel, new Color(30, 210, 96));
        pickerSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(255, 255, 255));
        pickerSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, new Color(30, 210, 96));
        pickerSettings.setColor(DatePickerSettings.DateArea.TextTodayLabel, new Color(249, 6, 59));
        
        pickerSettings.setSizeDatePanelMinimumHeight(300);
        pickerSettings.setSizeDatePanelMinimumWidth(300);
        pickerSettings.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(pickerSettings);
        //dPicker1.setBounds(660, 40, 30, 30);
        dPicker1.setBounds(420, 80, 30, 30);
        dPicker1.setBackground(new Color(31, 31, 31));
        dPicker1.setCursor(new Cursor(HAND_CURSOR));
        dPicker1.addDateChangeListener((dce) -> {
            txngaybd.setText(dPicker1.getDateStringOrEmptyString());
        });
        DatePickerSettings pickerSettings0 = new DatePickerSettings();
        pickerSettings0.setColor(DatePickerSettings.DateArea.TextClearLabel, new Color(30, 210, 96));
        pickerSettings0.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(255, 255, 255));
        pickerSettings0.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, new Color(30, 210, 96));
        pickerSettings0.setColor(DatePickerSettings.DateArea.TextTodayLabel, new Color(249, 6, 59));
        
        pickerSettings0.setSizeDatePanelMinimumHeight(300);
        pickerSettings0.setSizeDatePanelMinimumWidth(300);
        pickerSettings0.setVisibleDateTextField(false);
        dPicker2 = new DatePicker(pickerSettings0);
        //dPicker2.setBounds(990, 40, 30, 30);
        dPicker2.setBounds(670, 80, 30, 30);
        dPicker2.setBackground(new Color(31, 31, 31));
        dPicker2.setCursor(new Cursor(HAND_CURSOR));
        dPicker2.addDateChangeListener((dce) -> {
            txngaykt.setText(dPicker2.getDateStringOrEmptyString());
        });
        this.add(lbngaybd);
        this.add(txngaybd);
         this.add(lbngaykt);
        this.add(txngaykt);
       // this.add(lbngaykt);
        //this.add(txngaykt);
        this.add(dPicker1);
        this.add(dPicker2);
    }

    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }
     public static void main(String[] args) {
        ThongKeNVGUI a=new ThongKeNVGUI();
            //a.setVisible(true);
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }
}

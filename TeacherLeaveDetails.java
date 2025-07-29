package UniversityManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetails extends JFrame {

    Choice cempid;
    JTable table;
    JButton search, print, update,add, cancel;

    public TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search By Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(180, 20, 150, 20);
        cempid.setBackground(Color.white);
        add(cempid);

        try {
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1100,500);
        add(jsp);

        search = new JButton("search");
        search.setBounds(20,60, 80, 20);
        search.addActionListener(this::actionPerformed);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,60, 80, 20);
        print.addActionListener(this::actionPerformed);
        add(print);


        cancel = new JButton("Cancel");
        cancel.setBounds(220,60, 80, 20);
        cancel.addActionListener(this::actionPerformed);
        add(cancel);

        setSize(1100, 600);
        setLocation(100,70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search){
            String query = "select * from teacherleave where empid = '"+cempid.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}

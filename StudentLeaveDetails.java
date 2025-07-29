package UniversityManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame {

    Choice crollno;
    JTable table;
    JButton search, print, update,add, cancel;

    public StudentLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        crollno.setBackground(Color.white);
        add(crollno);

        try {
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
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
            String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
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
        new StudentLeaveDetails();
    }
}

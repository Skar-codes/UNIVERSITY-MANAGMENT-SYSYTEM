package UniversityManagmentSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame {

    Choice cempid,ctime;
    JDateChooser dcdate;
    JButton submit, cancel;

    public TeacherLeave(){
        setSize(500, 550);
        setLocation(400, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(130, 20, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblrollno = new JLabel("Search By Employee ID");
        lblrollno.setBounds(20, 80, 150, 20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblrollno);

        cempid = new Choice();
        cempid.setBounds(40, 110, 150, 20);
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

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(20, 140, 200, 20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(40, 170,150, 20);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(20, 200, 200, 20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(40, 230,150, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this::actionPerformed);
        submit.setFont(new Font("serif",Font.BOLD,14));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,350,100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this::actionPerformed);
        cancel.setFont(new Font("serif",Font.BOLD,14));
        add(cancel);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String empid = cempid.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave values('"+empid+"', '"+date+"', '"+duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new TeacherLeave();
    }
}

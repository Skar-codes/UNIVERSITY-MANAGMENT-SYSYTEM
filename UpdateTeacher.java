package UniversityManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateTeacher extends JFrame {
    TextField tfaddress, tfphoneno, tfemail, tfdepartment, tfeducation;
    JLabel lebelEmpid;
    JButton submit, cancel;
    Choice cempid;


    public UpdateTeacher(){

        setSize(900, 650);
        setLocation(170, 10);

        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 35);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);

        JLabel lblsrollno = new JLabel("Select Employee ID");
        lblsrollno.setBounds(50, 70, 200, 20);
        lblsrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsrollno);

        cempid = new Choice();
        cempid.setBounds(250, 70, 200, 20);
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

        JLabel lblname = new JLabel("Name ");
        lblname.setBounds(50, 130, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        JLabel lebelname = new JLabel();
        lebelname.setBounds(170,130, 170, 30);
        lebelname.setFont(new Font("serif",Font.BOLD,16));
        add(lebelname);

        JLabel lblfname = new JLabel("Father's Name ");
        lblfname.setBounds(440, 130, 200, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        JLabel lebelfname = new JLabel();
        lebelfname.setBounds(640,130, 170, 30);
        lebelfname.setFont(new Font("serif",Font.BOLD,16));
        add(lebelfname);

        JLabel lblrollno = new JLabel("Emp ID");
        lblrollno.setBounds(50, 180, 100, 30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        lebelEmpid = new JLabel();
        lebelEmpid.setBounds(170, 180, 100, 30);
        lebelEmpid.setFont(new Font("serif",Font.BOLD,16));
        add(lebelEmpid);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(440, 180, 150, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        JLabel lebeldob = new JLabel();
        lebeldob.setBounds(640, 180,170, 30);
        lebeldob.setFont(new Font("serif",Font.BOLD,16));
        add(lebeldob);

        JLabel lbladdress = new JLabel("Address ");
        lbladdress.setBounds(50, 230, 100, 30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new TextField();
        tfaddress.setBounds(170, 230, 170, 30);
        add(tfaddress);

        JLabel lblphoneno = new JLabel("Phone No ");
        lblphoneno.setBounds(440, 230, 150, 30);
        lblphoneno.setFont(new Font("serif",Font.BOLD,20));
        add(lblphoneno);

        tfphoneno = new TextField();
        tfphoneno.setBounds(640,230, 170, 30);
        add(tfphoneno);

        JLabel lblemail = new JLabel("Email ");
        lblemail.setBounds(50, 280, 100, 30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new TextField();
        tfemail.setBounds(170, 280, 170, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%) ");
        lblx.setBounds(440, 280, 150, 30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        JLabel lebelx = new JLabel();
        lebelx.setBounds(640,280, 170, 30);
        lebelx.setFont(new Font("serif",Font.BOLD,16));
        add(lebelx);

        JLabel lblxii = new JLabel("Class XII(%) ");
        lblxii.setBounds(50, 330, 150, 30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        JLabel lebelxii = new JLabel();
        lebelxii.setBounds(220, 330, 120, 30);
        lebelxii.setFont(new Font("serif",Font.BOLD,16));
        add(lebelxii);

        JLabel lbladharno = new JLabel("Aadhar No ");
        lbladharno.setBounds(440, 330, 150, 30);
        lbladharno.setFont(new Font("serif",Font.BOLD,20));
        add(lbladharno);

        JLabel lebelaadhar = new JLabel();
        lebelaadhar.setBounds(640,330, 170, 30);
        lebelaadhar.setFont(new Font("serif",Font.BOLD,16));
        add(lebelaadhar);

        JLabel lblcourse = new JLabel("Education ");
        lblcourse.setBounds(50, 380, 100, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);

        tfeducation = new TextField();
        tfeducation.setBounds(170, 380, 170, 30);
        add(tfeducation);

        JLabel lblbranch = new JLabel("Department ");
        lblbranch.setBounds(440, 380, 150, 30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        tfdepartment = new TextField();
        tfdepartment.setBounds(640,380, 170, 30);
        add(tfdepartment);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lebelname.setText(rs.getString("name"));
                lebelfname.setText(rs.getString("fname"));
                lebeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphoneno.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                lebelx.setText(rs.getString("class_x"));
                lebelxii.setText(rs.getString("class_xii"));
                lebelaadhar.setText(rs.getString("aadhar"));
                lebelEmpid.setText(rs.getString("empid"));
                tfeducation.setText(rs.getString("qualification"));
                tfdepartment.setText(rs.getString("department"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empid = '"+cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        lebelname.setText(rs.getString("name"));
                        lebelfname.setText(rs.getString("fname"));
                        lebeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphoneno.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        lebelx.setText(rs.getString("class_x"));
                        lebelxii.setText(rs.getString("class_xii"));
                        lebelaadhar.setText(rs.getString("aadhar"));
                        lebelEmpid.setText(rs.getString("empid"));
                        tfeducation.setText(rs.getString("qualification"));
                        tfdepartment.setText(rs.getString("department"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(150,470,150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this::actionPerformed);
        submit.setFont(new Font("serif",Font.BOLD,14));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(550,470,150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this::actionPerformed);
        cancel.setFont(new Font("serif",Font.BOLD,14));
        add(cancel);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){

            String empid = lebelEmpid.getText();
            String address = tfaddress.getText();
            String phone = tfphoneno.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String department =tfdepartment.getText();

            try {
                String query = "update teacher set address = '"+address+"',phone = '"+phone+"',email = '"+email+"',qualification = '"+education+"',department = '"+department+"' where empid = '"+empid+"'";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details update Succesfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}

package UniversityManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class AddStudent extends JFrame {
    TextField tfname, tffname, tfaddress, tfphoneno, tfemail, tfx, tfxii, tfadharno;
    JLabel lebelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

   public AddStudent(){

       setSize(900, 650);
       setLocation(170, 10);

       setLayout(null);

       JLabel heading = new JLabel("New Student Details");
       heading.setBounds(300, 20, 500, 30);
       heading.setFont(new Font("serif",Font.BOLD,30));
       add(heading);

       JLabel lblname = new JLabel("Name ");
       lblname.setBounds(50, 130, 100, 30);
       lblname.setFont(new Font("serif",Font.BOLD,20));
       add(lblname);

       tfname = new TextField();
       tfname.setBounds(170,130, 170, 30);
       add(tfname);

       JLabel lblfname = new JLabel("Father's Name ");
       lblfname.setBounds(440, 130, 200, 30);
       lblfname.setFont(new Font("serif",Font.BOLD,20));
       add(lblfname);

       tffname = new TextField();
       tffname.setBounds(640,130, 170, 30);
       add(tffname);

       JLabel lblrollno = new JLabel("Roll No ");
       lblrollno.setBounds(50, 180, 100, 30);
       lblrollno.setFont(new Font("serif",Font.BOLD,20));
       add(lblrollno);

       lebelrollno = new JLabel("1533"+first4);
       lebelrollno.setBounds(170, 180, 100, 30);
       lebelrollno.setFont(new Font("serif",Font.BOLD,20));
       add(lebelrollno);

       JLabel lbldob = new JLabel("Date of Birth");
       lbldob.setBounds(440, 180, 150, 30);
       lbldob.setFont(new Font("serif",Font.BOLD,20));
       add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(640, 180,170, 30);
        add(dcdob);

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

       tfx = new TextField();
       tfx.setBounds(640,280, 170, 30);
       add(tfx);

       JLabel lblxii = new JLabel("Class XII(%) ");
       lblxii.setBounds(50, 330, 150, 30);
       lblxii.setFont(new Font("serif",Font.BOLD,20));
       add(lblxii);

       tfxii = new TextField();
       tfxii.setBounds(220, 330, 120, 30);
       add(tfxii);

       JLabel lbladharno = new JLabel("Aadhar No ");
       lbladharno.setBounds(440, 330, 150, 30);
       lbladharno.setFont(new Font("serif",Font.BOLD,20));
       add(lbladharno);

       tfadharno = new TextField();
       tfadharno.setBounds(640,330, 170, 30);
       add(tfadharno);

       JLabel lblcourse = new JLabel("Course ");
       lblcourse.setBounds(50, 380, 150, 30);
       lblcourse.setFont(new Font("serif",Font.BOLD,20));
       add(lblcourse);

       String course[] = {"B.Tech","BBA","BCA","MCA","BA","MA","Bsc","Msc","MBA","MCom","BCom"};
       cbcourse = new JComboBox<>(course);
       cbcourse.setBounds(170, 380, 170, 30);
        add(cbcourse);

       JLabel lblbranch = new JLabel("Branch ");
       lblbranch.setBounds(440, 380, 150, 30);
       lblbranch.setFont(new Font("serif",Font.BOLD,20));
       add(lblbranch);

       String branch[] = {"Computer Science","IT","civil","Mechanical","Electical","ECE","Physics","Chemistry","Bengali","English","Geography","History","Biology","Mathematics"};
       cbbranch = new JComboBox<>(branch);
       cbbranch.setBounds(640,380, 170, 30);
       add(cbbranch);

       submit = new JButton("Submit");
       submit.setBounds(150,500,150, 30);
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.addActionListener(this::actionPerformed);
       submit.setFont(new Font("serif",Font.BOLD,14));
       add(submit);

       cancel = new JButton("Cancel");
       cancel.setBounds(550,500,150, 30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this::actionPerformed);
       cancel.setFont(new Font("serif",Font.BOLD,14));
       add(cancel);



       setVisible(true);
   }

    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == submit){
           String name = tfname.getText();
           String fname = tffname.getText();
           String rollno = lebelrollno.getText();
           String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
           String address = tfaddress.getText();
           String phone = tfphoneno.getText();
           String email = tfemail.getText();
           String x = tfx.getText();
           String xii = tfxii.getText();
           String aadhar = tfadharno.getText();
           String course = (String) cbcourse.getSelectedItem();
           String branch =(String) cbbranch.getSelectedItem();

           try {
               String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";

               Conn c = new Conn();
               c.s.executeUpdate(query);

               JOptionPane.showMessageDialog(null,"Student Details Inserted Succesfully");
               setVisible(false);
           }catch (Exception e){
                e.printStackTrace();
           }
       }else {
           setVisible(false);
       }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}

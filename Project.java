package UniversityManagmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame {

    public Project(){
        setSize(1920,1080);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1320, 1070, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newinformation = new JMenu("New Information");
        mb.add(newinformation);
        newinformation.setForeground(Color.BLUE);

        JMenuItem facultyitem = new JMenuItem("New Faculty Information");
        facultyitem.addActionListener(this::actionPerformed);
        facultyitem.setBackground(Color.WHITE);
        newinformation.add(facultyitem);

        JMenuItem studentitem = new JMenuItem("New Student Information");
        studentitem.addActionListener(this::actionPerformed);
        facultyitem.setBackground(Color.WHITE);
        newinformation.add(studentitem);

        JMenu details = new JMenu("View Details");
        mb.add(details);
        details.setForeground(Color.RED);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.addActionListener(this::actionPerformed);
        facultydetails.setBackground(Color.WHITE);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.addActionListener(this::actionPerformed);
        studentdetails.setBackground(Color.WHITE);
        details.add(studentdetails);

        JMenu leave = new JMenu("Apply Leave");
        mb.add(leave);
        leave.setForeground(Color.BLUE);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.addActionListener(this::actionPerformed);
        facultyleave.setBackground(Color.WHITE);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.addActionListener(this::actionPerformed);
        studentleave.setBackground(Color.WHITE);
        leave.add(studentleave);

        JMenu leavedetails = new JMenu("Leave Details");
        mb.add(leavedetails);
        leavedetails.setForeground(Color.RED);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.addActionListener(this::actionPerformed);
        facultyleavedetails.setBackground(Color.WHITE);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.addActionListener(this::actionPerformed);
        studentleavedetails.setBackground(Color.WHITE);
        leavedetails.add(studentleavedetails);

        JMenu examination = new JMenu("Examination");
        mb.add(examination);
        examination.setForeground(Color.BLUE);

        JMenuItem examinationdetails = new JMenuItem("Examination Result");
        examinationdetails.setBackground(Color.WHITE);
        examination.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.addActionListener(this::actionPerformed);
        entermarks.setBackground(Color.WHITE);
        examination.add(entermarks);

        JMenu updateinfo = new JMenu("Update Details");
        mb.add(updateinfo);
        updateinfo.setForeground(Color.RED);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this::actionPerformed);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this::actionPerformed);
        updateinfo.add(updatestudentinfo);

        JMenu fee = new JMenu("Fee Details");
        mb.add(fee);
        fee.setForeground(Color.BLUE);

        JMenuItem feestructure = new JMenuItem("Fees Structure");
        feestructure.setBackground(Color.WHITE);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        fee.add(feeform);

        JMenu utility = new JMenu("Utility");
        mb.add(utility);
        utility.setForeground(Color.RED);

        JMenuItem notepad = new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this::actionPerformed);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this::actionPerformed);
        utility.add(calc);

        JMenu exit = new JMenu("Exit");
        mb.add(exit);
        exit.setForeground(Color.BLUE);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this::actionPerformed);
        exit.add(ex);



        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("Exit")){
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception a){

            }
        }else if (msg.equals("NotePad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception a){

            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        }
        else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        }
        else if (msg.equals("View Student Details")) {
            new StudentDetails();
        }
        else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        }
        else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        }
        else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}

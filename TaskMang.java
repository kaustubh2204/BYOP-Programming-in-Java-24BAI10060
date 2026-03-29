import java.util.*;
import java.io.*;
import java.time.LocalDate;
import javax.swing.*;
import java.wing.table.DefaultTableModel;
public class TaskMang extends JFrame
{
  private static String FILE_NAME="tasks.dat";
  private static List<Tasks> tasks;
  private DefaultTableModel tableModel;
  private JTable tasktable;
  private JTextField titleField, subjectField, dateField;
  
  public TaskMang()
  {
    tasks=loadTasks();
    initializeUI();
  }
  private void initializeUI()
  {
    setTitle("Student Task Tracker");
    setSize(700,500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(10,10));
    JPanel input=new JPanel(new GridLayout(2,4,5,5);
    input.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    titleField=new JTextField();
    subjectField=new JTextField();
    dateField=new JTextField(LocalDate.now().toString());
    input.add(new Jlabel("Task Title:"));
    input.add(new JLabel("Subject:"));
    input.add(new JLabel("Due Date(YYYY-MM-DD):"));
    input.add(new Jlabel(""));
    input.add(titleField);
    input.add(subjectField);
    input.add(dateFiled);
    
  }
  public static void main(String[] args)
  {
    System.out.println("Hello World");
  }
}

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import javax.swing.*;
import java.wing.table.DefaultTableModel;
public class TaskMang extends JFrame
{
  private static String FILE_NAME="C:\Users\kstbh\OneDrive\Desktop\tasks.dat";
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
    JButton addButton=new JButton("Add Task");
    addButton.addActionListener(e->addTask);
    input.add(addButton);

    String[] col={"Status","Title","Subject","Due Date"};
    tableModel= new DefaultTableModel(col,0);
    taskTable=new JTable(tableModel);
    refreshTable();

    JPanel actionPanel=new JPanel();
    JButton completeButton=new JButton("Mark Selected as Complete");
    JButton saveButton=new JButton("Save and Exit");
    completeButton.addActionListener(e->markComplete());
    saveButton.addActionListener(e->{saveTasks(); System.exit(0);});
    actionPanel.add(completeButton);
    actionPanel.add(saveButton);
    add(input, BorderLayout.NORTH);
    add(new JScrollPane(taskTable), BorderLayout.CENTER);
    add(actionPanel, BorderLayout.SOUTH);
    setLocationRelativeTo(null);
  }
  private void addTask()
  {
    try{
      String title=titleField.getText();
      String subject=subjectField.getText();
      LocalDate date=LocalDate.parse(dateField.getText());
      if(title.isEmpty()||subject.isEmpty())
      {
        throw new Exception();
      }
      tasks.add(new Task(title, subject, date));
      refreshTable();
      clearFields();
    }catch(Exception e)
      {
        JOptionPane.showMessageDialog(this,"Please enetr valid details and YYYY-MM-DD format.");
      }
  }
  private void markComplete()
  {
    int selectedRow=taskTable.getSelectedRow();
    if(selectedRow!=-1)
    {
      tasks.get(selectedRow).markAsComplete();
      refreshTable();
    }
    else
    {
      JOptionPane.showMessageDialog(this, "Please select a task from the table first.");
    }
  }
  private void refreshTable()
  {
    table.Model.setRowCount(0);
    for(Task t:tasks)
      {
        Object[] row={
          t.isCompleted()?"[Done]":"[Pending]".
          t.getTitle(),
          t.getSubject(),
          t.getDueDate(),
        };
        tableModel.addRow(row);
      }
  }
  private void clearFields()
  {
    titleField.setText("");
    subjectField.setText("");
    dateField.setText(LocalDate.now().toString());
  }
  private void saveTasks()
  {
    try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
      {
        oos.writeObject(tasks);
      }catch (IOException e)
      {
        JOption.showMessageDialog(this, "Error saving data");
      }
  }
  @SuppressWarnings("unchecked")
  private List<Task> loadTasks()
  {
    File file=new File(FILE_NAME);
    if(!file.exists()) return new ArrayList<>();
    try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(FILE_NAME)))
      {
        return(List<Task>) ois.readObject();
      }catch(Exception e)
      {
        return new ArrayList<>();
      }
  }
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(()->new TaskMang().setVisible(true));
  }
}

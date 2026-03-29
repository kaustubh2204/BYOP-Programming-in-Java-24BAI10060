import java.io.Serializable;
import java.time.LocalData;
public class Task implements Serializable
  {
    private String title;
    private String subject;
    private LocalDate dueDate;
    private boolean isCompleted;
    public Task(String title, String subject,LocalDate dueDate)
    {
      this.title=title;
      this.subject=subject;
      this.dueDate=dueDate;
      this.isCompleted=false;
    }
    public String getTitle()
    {
      return title;
    }
    public String getSubject()
    {
      return subject;
    }
    public LocalDate getDueDate()
    {
      return dueDate;
    }
    public boolean isCompleted()
    {
      return isCompleted;
    }
    public void markAsCompleted()
      {
      this.isCompleted=true;
      }
    @Override
    public String toString()
    {
      String status=isCompleted ? "[Done]" : "[Pending]";
      return String.format("%s %s |Subject: %s | Due: %s", status, title, subject, dueDate);
    }
  }

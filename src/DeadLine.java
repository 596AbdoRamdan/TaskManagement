
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeadLine extends SimpleTask{
    LocalDate deadLine = LocalDate.now();
    public void setDeadline(int index,String endDate)
    {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index!");
            return;
        }

        if(valid(endDate)) {
            deadLine = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if(deadLine.isBefore(dates.get(index)))
            {
                System.out.println("Task\t\""+tasks.get(index) +" \" ended in " + dates.get(index));
                setComplete(index);
            }
        }
        }
    }


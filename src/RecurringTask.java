

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class RecurringTask extends SimpleTask implements inter {
    LocalDate endDate = LocalDate.now();
    String repeatedTask;
        public void repeat(int i,String end)
        {
            repeat(i,LocalDate.now().toString(),end);
        }
        public void repeat(int index,String start, String end) {
            if (index < 0 || index >= tasks.size()) {
                System.out.println("Invalid task index!");
                return;
            }
            repeatedTask = tasks.get(index);

            if(valid(start) && valid(end))
            {
                endDate = LocalDate.parse(end,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                date    = LocalDate.parse(start,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                while (!endDate.isBefore(date )) {  // Loop until date is beyond end date
                    System.out.println(date + "\t"+ repeatedTask);
                    date = date.plusDays(1);  // Move to the next day
                }


            }

    }
     public void pr()
    {
        System.out.println("A7A");
    }
}

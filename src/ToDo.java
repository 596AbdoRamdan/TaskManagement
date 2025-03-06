
import java.util.ArrayList;
public class ToDo {
    public static void main(String[] args) {
        SimpleTask c = new SimpleTask();
        SimpleTask c2 = new RecurringTask();
       c.add("task1", "desc1");
       c.print();
       c.update(0,"tas","des");
    }

    }



//        SimpleTask c2 = new RecurringTask();
//        SimpleTask c3 = new DeadLine();
//        int x = 0;
//        ArrayList<String> arr = new ArrayList<>();
//        int countSimple = 0 ;
//        int countRecurring = 0 ;
//        int countDeadline = 0 ;
//        SimpleTask c = new SimpleTask();
//        while(x<3) {
//            arr.add(c.toString());
//            arr.add(c2.toString());
//            arr.add(c3.toString());
//           x++;
//        }
////            arr.add(c);
////        for (SimpleTask i : arr)
////        {
////            System.out.println(i.getClass());
//////        }
//            //class RecurringTask - class DeadLine
//        for (int i = 0; i <arr.size() ; i++) {
//            if (arr.get(i).equals("SimpleTask"))
//            {
//                countSimple++;
//            } else if (arr.get(i).equals("RecurringTask"))
//            {
//                countRecurring++;
//            } else if (arr.get(i).equals("DeadLine"))
//            {
//                countDeadline++;
//            }
//        }
//        System.out.println("Simple:\t"+ countSimple);
//        System.out.println("Recurring:\t"+ countRecurring);
//        System.out.println("DeadLine:\t"+ countDeadline);
//    }


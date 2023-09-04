package exceptions;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);        //    [1,2,3]

        System.out.println(list);

        try {
            System.out.println(list.get(3));
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }


        System.out.println("finished");
        // next: casting
    }
}

//Throwable
//    Error
//    Exception
//        RuntimeException
//        ...  "checked exception"


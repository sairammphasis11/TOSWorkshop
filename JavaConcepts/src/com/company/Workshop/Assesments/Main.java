package com.company.Workshop.Assesments;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {

      public static void main(String args[]) {

        ArrayList<String> result = new ArrayList<String>();

        // Add elements to the collection.
        result.add("B");
        result.add("C");
        result.add("D");
        result.add("X");
        result.add("Y");
        result.add(1,"E");
        //result.add(1, "A2");

        System.out.println("Original contents of result: " + result);

        // Remove elements from the collection.
          result.remove("D");
          result.remove(1);


          System.out.println("Contents of result after deletion: "
                + result);

        // Remove first and last elements.
          result.remove(0);
          result.remove(result.size()-1);


        System.out.println("result after deleting first and last: "
                + result);

        // Get and set a value.
        String val = result.get(2);
        result.set(2, val + " Changed");

        System.out.println("result after change: " + result);
    }
}

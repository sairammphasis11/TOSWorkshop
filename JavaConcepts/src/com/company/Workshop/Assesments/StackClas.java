package com.company.Workshop.Assesments;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Vector;

public class StackClas {
    public static void main(String args[]) {
        // Create a collection.
        LinkedList<String> adq = new LinkedList<String>();
        // Use the collection like a stack.
        adq.add("A");
        adq.add("B");
        adq.add("D");
        adq.add("E");
        adq.add("F");

        System.out.print("Popping the stack: ");

        while(adq.peekLast()!= null)
            System.out.print(adq.pollLast()+ " ");

        System.out.println();
    }
}

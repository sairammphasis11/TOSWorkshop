package com.company.Workshop.Assesments;

import java.util.Iterator;
import java.util.Vector;

public class Asses4 {
    public static void main(String args[]) {

        // initial size of 3 and increment of 2
        Vector<Integer> v = new Vector<Integer>(3, 2);

        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " +
                v.capacity());

        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);

        System.out.println("Capacity after four additions: " +
                v.capacity());
        v.add(5);
        System.out.println("Current capacity: " +
                v.capacity());
        v.add(6);
        v.add(7);

        System.out.println("Current capacity: " +
                v.capacity());
        v.add(9);
        v.add(10);

        System.out.println("Current capacity: " +
                v.capacity());
        v.add(11);
        v.add(12);


        System.out.println("First element: " + v.firstElement());
        System.out.println("Last element: " + v.lastElement());

        if(v.contains(3))
            System.out.println("Collection contains 3.");

        // traverse through the elements in the collection.
        Iterator vE = v.iterator();

        System.out.println("\nElements in collection:");
        while(vE.hasNext())
            System.out.print(vE.next() + " ");
        System.out.println();
    }
}

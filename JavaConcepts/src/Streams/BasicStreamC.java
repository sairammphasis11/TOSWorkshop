package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//creating Streams class and implemented streams classes
public class BasicStreamC {
    public static void main(String[] args) {
        List<Integer> nmbr = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list = new ArrayList();
       // nmbr.stream().filter(el -> getEven(el)).forEach(System.out::println);
       //nmbr.stream().filter(el -> getEven(el)).map(el->el*el).forEach(el->list.add(el));
        nmbr.stream().filter(el -> getEven(el)).map(el->el*el).
                reduce(0,(total,el)->Integer.sum(total,el));
        list=nmbr.stream().filter(el->getEven(el))
                .map(el->el*2)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
    public static boolean getEven(Integer el){

        return el%2==0;
    }


}

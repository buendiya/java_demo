package snippet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ListFilterDemo {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        lines = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        lines.forEach(System.out::println);                //output : spring, node

    }

}

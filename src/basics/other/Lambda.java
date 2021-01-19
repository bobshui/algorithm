package basics.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        //lambda表达式，基础
        Lambda1 add = (int a, int b) -> {
            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b + "}");
            return a + b;
        };
        add.add(8, 2);
        Lambda1 add2 = (int a, int b) -> a + b;
        add2.add(8, 2);

        //lambda表达式，集合操作
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5);
        list.forEach(System.out::println);
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });

        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
    }
}


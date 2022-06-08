package lzf.Zix.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListExample {
    public static void main(String[] args) {
        //赋值
        List<String> list = Arrays.asList("a","b");
        List<String> list1 = new ArrayList<String>(){{
            this.add("a");
            this.add("b");
        }};
        //方法 1
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list0.add(2);
        list0.forEach(System.out::println);
        //方法 2
        List<Integer> list3 = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        list1.forEach(System.out::println);
        //方法 3
        List<Integer> list2 = Stream.of(1, 2).collect(Collectors.toList());
        list2.forEach(System.out::println);
    }
}

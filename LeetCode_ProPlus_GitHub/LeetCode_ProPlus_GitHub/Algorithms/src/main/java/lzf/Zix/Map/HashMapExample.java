package lzf.Zix.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map <Integer,String> coursesMap = new HashMap<>();
        coursesMap.put(1, "C");
        coursesMap.put(2, "C++");
        coursesMap.put(3, "Java");
        coursesMap.put(4, "Spring Framework");
        coursesMap.put(5, "Hibernate ORM framework");
        // 1. 使用 Iterator 遍历 HashMap EntrySet
        Iterator<Map.Entry< Integer, String >> iterator = coursesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry< Integer, String > entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // 2. 使用 Iterator 遍历 HashMap KeySet
        Iterator < Integer > iterator1 = coursesMap.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer key = iterator1.next();
            System.out.println(key);
            System.out.println(coursesMap.get(key));
        }

        // 3. 使用 For-each 循环遍历 HashMap
        for (Map.Entry < Integer, String > entry: coursesMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // 4. 使用 Lambda 表达式遍历 HashMap
        coursesMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        // 5. 使用 Stream API 遍历 HashMap
        coursesMap.entrySet().stream().forEach((entry) -> {
                System.out.println(entry.getKey());
        System.out.println(entry.getValue());
        });

    }
}

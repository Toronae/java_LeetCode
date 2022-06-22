package lzf.Zix.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
//        如果要实现自动排序TreeMap或treeset是必不可少的
//        本例子采用set集合进行演示
        Set<Customers> set = new TreeSet<>(new Customers.CCompartor());
        Set<Customers> set1 = new TreeSet<>(new Comparator<Customers>() {
            @Override
            public int compare(Customers o1, Customers o2) {
                if(o1.age == o2.age){
                    return o1.name.compareTo(o2.name);
                }else{
                    return o1.age - o2.age;
                }
            }
        });
        set1.add(new Customers("zhangsi",20));
        set1.add(new Customers("zhangsan",20));
        set1.add(new Customers("mike",10));
        set1.add(new Customers("join",17));
        for(Customers customers : set){
            System.out.println(customers);
        }
    }
    static class Customers {
        String name;
        int age;

        public Customers(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Customers{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }


        static class CCompartor implements Comparator<Customers> {
            @Override
            public int compare(Customers o1, Customers o2) {
                if(o1.age == o2.age){
                    return o1.name.compareTo(o2.name);
                }else{
                    return o1.age - o2.age;
                }
            }
        }
    }


}

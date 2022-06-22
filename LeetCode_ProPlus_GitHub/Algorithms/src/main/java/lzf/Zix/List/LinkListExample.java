package lzf.Zix.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 双向列表
 */
public class LinkListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //add往后添加元素
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("10");
        list.add("20");

        System.out.println("The list is:" + list);
        //addFirst 往头部添加
        list.addFirst("First");
        list.addFirst("At");
        // addLast 往尾部添加元素
        list.addLast("hello");
        System.out.println("The new List is:" + list);
        // 移除队首元素
        list.poll();
        System.out.println("The new List is:" + list);
        //    注意队首下标为0
        //    输出：
        //    The list is:[Geeks, for, Geeks, 10, 20]
        //    The new List is:[At, First, Geeks, for, Geeks, 10, 20]
        // LinkedList实现栈的效果
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++){
            stack.push(i);
        }
        System.out.println(stack.top());
        // LinkedList实现队列的效果
        Queue queue = new Queue();
        for (int i = 0; i < 10; i++){
            queue.put(Integer.toString(i));
        }
        while (!queue.isEmpty()){
            System.out.println(queue.get());
        }
        //将LinkedList转换成ArrayList
        ArrayList<String> arrayList = new ArrayList<String>(list);
        for (String s : arrayList) {
            System.out.println("s = " + s);
        }
        //在链表后添加一个元素

        //删除列表的首位元素
        list.removeFirst();
        //根据范围删除列表元素
        list.subList(0,1).clear();
        //删除链表的特定元素
        list.remove("hello");
        //确认链表是否存在特定元素
        list.contains("hello");
        // 遍历
        // for循环
        for(int i = 0; i < list.size(); ++i){
            System.out.print(list.get(i) + " ");
        }
        // foreach循环
        for (Object x: list) {
            System.out.print(x+" ");
        }
        //迭代器遍历--正向输出
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()){  // 1：boolean hasNext()判断集合中是否有元素，如果有元素可以迭代，就返回true。
            System.out.print(it.next()+" ");// 2： E next()返回迭代的下一个元素
        }
        //迭代器遍历--反向输出
        ListIterator<Integer> rit = list.listIterator(list.size());
        while (rit.hasPrevious()){
            System.out.print(rit.previous() +" ");
        }

        //   peek()：获取第一个元素，但是不移除；
        //   peekFirst()：获取第一个元素，但是不移除；
        //   peekLast()：获取最后一个元素，但是不移除；
        //   get(int index)：按照下边获取元素；
        //   getFirst()：获取第一个元素；
        //   getLast()：获取最后一个元素
        //   boolean offer(E e)：在链表尾部插入一个元素；
        //   boolean offerFirst(E e)：与addFirst一样，实际上它就是addFirst；
        //   boolean offerLast(E e)：与addLast一样，实际上它就是addLast；
        //   contains(Object obj):判断链表中是否包含某个元素，返回值为true或false；
        //   element():获得链表的第一个元素但不删除
        //   set(int position,Object obj):将链表中第position个元素修改为obj;
        //   subList(int start,int end):取中间元素，但顾头不顾尾；
        //   remove()；移除链表中第一个元素；
        //   boolean remove(Object o)：移除链表中指定的元素；
        //   remove(int index)：移除链表中指定位置的元素；
        //   removeFirst()：移除链表中第一个元素，与remove类似；
        //   removeLast()：移除链表中最后一个元素；
        //   boolean removeFirstOccurrence(Object o)：移除链表中第一次出现所在位置的元素；
        //   boolean removeLastOccurrence(Object o)：移除链表中最后一次出现所在位置的元素；
        //   pop()：与removeFirst一样，实际上它就是removeFirst；
        //   poll()：查询并移除第一个元素；

}

}
class Stack {
    private LinkedList list = new LinkedList();
    public void push(Object v) {
        list.addFirst(v);
    }
    public Object top() {
        return list.getFirst();
    }
    public Object pop() {
        return list.removeFirst();
    }
}
class Queue {
    private LinkedList list = new LinkedList();
    public void put(Object v) {
        list.addFirst(v);
    }
    public Object get() {
        return list.removeLast();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}



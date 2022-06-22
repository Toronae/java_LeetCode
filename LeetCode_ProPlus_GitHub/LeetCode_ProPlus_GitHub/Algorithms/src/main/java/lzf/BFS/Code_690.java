package lzf.BFS;

import java.util.*;

public class Code_690 {
    public static void main(String[] args) {
        Employee employees1 = new Employee();
        employees1.setId(1);
        employees1.setImportance(5);
        List<Integer> sub = new ArrayList<>();
        sub.add(2);
        sub.add(3);
        employees1.setSubordinates(new ArrayList<>(sub));
        Employee employees2 = new Employee();
        employees2.setId(2);
        employees2.setImportance(3);
        employees2.setSubordinates(new ArrayList<>());
        Employee employees3 = new Employee();
        employees3.setId(3);
        employees3.setImportance(3);
        employees3.setSubordinates(new ArrayList<>());
        List<Employee> employees = new ArrayList<>();
        employees.add(employees1);
        employees.add(employees2);
        employees.add(employees3);
        int id = 1;
        System.out.println(new Code_690().getImportance(employees,id));
    }

    // bfs

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee employee = map.get(curId);
            total += employee.importance;
            List<Integer> subordinates = employee.subordinates;
            for (int subId : subordinates) {
                queue.offer(subId);
            }
        }
        return total;
    }

    static class Employee {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getImportance() {
            return importance;
        }

        public void setImportance(int importance) {
            this.importance = importance;
        }

        public List<Integer> getSubordinates() {
            return subordinates;
        }

        public void setSubordinates(List<Integer> subordinates) {
            this.subordinates = subordinates;
        }

        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public Employee() {
        }
    }

    //dfs

    /*
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }
    */
}

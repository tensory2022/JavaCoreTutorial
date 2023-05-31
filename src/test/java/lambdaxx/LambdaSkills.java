package lambdaxx;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaSkills {

    class Employee{
        int id;
        String name;
        int age;
        int salary;

        Employee(int id, String name, int age, int salary){
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }

    Employee e1 = new Employee(1001, "Tim", 26, 20000);
    Employee e2 = new Employee(1002, "Danny", 32, 25000);
    Employee e3 = new Employee(1003, "Alice", 29, 17000);
    Employee e4 = new Employee(1004, "Bob", 22, 18000);
    Employee e5 = new Employee(1005, "Maria", 31, 32000);

    /**
     * 1. Traversal
     */
    @Test
    public void testTraversal(){
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5);
        System.out.println("//old: for loop");
        for(Employee employee: employees){
            System.out.println(employee);
        }

        System.out.println("//new: forEach()");
        employees.forEach(System.out::println);
    }

    /**
     * 2. filter: get employees whose ages are over 30.
     */
    @Test
    public void testFilter(){
        System.out.println("old filter:");
        List<Employee> employees1 = Arrays.asList(e1, e2, e3, e4, e5);
        List<Employee> resultList = new ArrayList<>();
        for(Employee employee: employees1){
            if (employee.age > 30){
                resultList.add(employee);
            }
        }
        // show resultList1
        resultList.forEach(System.out::println);

        System.out.println("new filter:");
        List<Employee> employees2 = Arrays.asList(e1, e2, e3, e4, e5);
        List<Employee> resultList2 = employees2.stream()
                .filter(employee -> employee.age>30)
                .collect(Collectors.toList());
        // show resultList2
        resultList2.forEach(System.out::println);
    }

    /**
     * 3. group by: classify employees by name's length into groups.
     */
    @Test
    public void testGroup(){
        System.out.println("old group by:");
        List<Employee> employees1 = Arrays.asList(e1, e2, e3, e4, e5);
        HashMap<Integer, List<Employee>> map1 = new HashMap<>();
        for(Employee employee: employees1){
            int length = employee.name.length();
            map1.computeIfAbsent(length, e->new ArrayList<>());
            map1.get(length).add(employee);
        }

        System.out.println("new group by:");
        List<Employee> employees2 = Arrays.asList(e1, e2, e3, e4, e5);
        Map<Integer, List<Employee>> map2 =
                employees2.stream()
                        .collect(
                                Collectors.
                                groupingBy(
                                        employee -> employee.name.length()
                                )
                        );
    }

    /**
     * 4. Use lambda to create a Comparator
     */
    @Test
    public void testComparator(){
        Comparator<Employee> oldComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.salary - o1.salary;
            }
        };
        List<Employee> employees1 = Arrays.asList(e1, e2, e3, e4, e5);
        employees1.sort(oldComparator);

        /**
         * It's very easy to create a comparator using lambda.
         */
        Comparator<Employee> newComparator =
                (e1, e2)->e2.salary - e1.salary;
        List<Employee> employees2 = Arrays.asList(e1, e2, e3, e4, e5);
        employees2.sort(newComparator);
    }

    /**
     * 5. Use lambda to create multi-thread.
     */
    @Test
    public void testThread(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1: Hello world!");
            }
        });
        thread1.start();

        Thread thread2 = new Thread(
                ()-> System.out.println("Thread 2: Hello world!")
        );
        thread2.start();
    }
}
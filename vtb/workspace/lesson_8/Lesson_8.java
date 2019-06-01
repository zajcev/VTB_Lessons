package vtb.workspace.lesson_8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mikhail Zaitsev
 */
public class Lesson_8 {
    public static void main(String[] args) {
        String[] words = {"one", "two", "three", "one", "two", "four", "one", "five", "two", "four"}; // Доделать

        Worker[] workers = {new Worker("bob", 25, 5000),
                new Worker("carl", 20, 35000),
                new Worker("john", 30, 7500),
                new Worker("james", 33, 80000),
                new Worker("bill", 45, 60000),
                new Worker("rodrigo", 50, 50000),
                new Worker("pavel", 31, 30000)
        };
        averageSalary(workers);
        olderWorkers(workers,2);
    }

    private static void averageSalary(Worker[] workers) {
        double averageSalary = Arrays.stream(workers)
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Worker::getSalary)
                .average()
                .getAsDouble();
        System.out.println((int)averageSalary);
    }

    private static void olderWorkers(Worker[] workers, int number) {
        String names = Arrays.stream(workers)
                .sorted(Comparator.comparingInt(a -> a.age))
                .map(worker -> worker.name)
                .skip(workers.length - number)
                .limit(number)
                .collect(Collectors.joining(","));
        System.out.println(number+" самых старших сотрудника зовут: "+names);

    }

}

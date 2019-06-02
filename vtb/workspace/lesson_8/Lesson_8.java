package vtb.workspace.lesson_8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.*;

/**
 * @author Mikhail Zaitsev
 */
public class Lesson_8 {
    public static void main(String[] args) {
        String[] words = {"one", "two", "three", "one", "two", "four", "five", "two", "four","four","four","four","four","four","four"};

        Worker[] workers = {new Worker("bob", 25, 5000),
                            new Worker("carl", 20, 35000),
                            new Worker("john", 30, 7500),
                            new Worker("james", 33, 80000),
                            new Worker("bill", 45, 60000),
                            new Worker("rodrigo", 50, 50000),
                            new Worker("pavel", 31, 30000)
        };

        oftenMeet(words);
        averageSalary(workers);
        olderWorkers(workers,3);
    }

    private static void averageSalary(Worker[] workers) {
        double averageSalary = Arrays.stream(workers)
                .mapToInt(Worker::getSalary)
                .average()
                .getAsDouble();
        System.out.println("Средняя зарплата "+(int)averageSalary);
    }

    private static void olderWorkers(Worker[] workers, int countOfWorkers) {
        String names = Arrays.stream(workers)
                .sorted((a1,a2)-> a2.age - a1.age)
                .map(worker -> worker.name)
                .limit(countOfWorkers)
                .collect(Collectors.joining(","));
        System.out.println(countOfWorkers+" самых старших сотрудника зовут: "+names);

    }

    private static void oftenMeet(String[] words){
        String map = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())) // (word -> word, количество добавлений)
                .entrySet()
                .stream()
                .max(Comparator.comparing(Entry::getValue))
                .map(Entry::getKey)
                .get();
        System.out.println("Самое часто встречающееся слово " + map);
    }
}

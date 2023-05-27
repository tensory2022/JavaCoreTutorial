package streamxx;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Stream - Simple Tutorial
 */
public class StreamAPIDemo {

    /**
     * How to create a stream? —— .stream()
     */
    @Test
    public void testCreateAndReturnStream() {
        List<String> list =
                Arrays.asList("This", "is", "stream", "demo");
        /**
         * List -> Stream
         */
        Stream<String> stream = list.stream();

        /**
         * to do: write stream operations here
         */

        /**
         * Stream -> List / Set
         */
        List<String> restoredList = stream.collect(Collectors.toList());
        System.out.println(restoredList);
    }

    /**
     * .map(): is a one-to-one transformation.
     */
    @Test
    public void stringToInteger() {
        List<String> list = Arrays.asList("10", "20", "30", "40");
        Stream<String> stream = list.stream();
        Stream<Integer> integerStream = stream.map(e->Integer.parseInt(e));
        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println(integers);
    }

    /**
     * .flatMap(): map() + removing the nested structure.
     */
    @Test
    public void linesToList() {
        List<String> lines = Arrays.asList(
                "Iron Man, Spider Man, The Avengers",
                "Hotel Transylvania, Tom & Jerry",
                "Rain Man, A Beautiful Mind, The King's Speech"
        );
        Stream<String > linesStream = lines.stream();
        List<String> list = linesStream
                .flatMap(line -> Arrays.stream(line.split(", ")))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * .filter()
     * .sorted()
     * .distinct()
     * .limit()
     */
    @Test
    public void testFilterNumbers() {
        List<String> list = Arrays.asList("50", "100", "10", "40", "300", "300", "20", "100", "1000");
        List<Integer> resultList = list.stream()
                .map(Integer::parseInt)
                .filter(e -> e>30)
                .sorted(Comparator.comparingInt(e-> -1*e))
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(resultList);
    }

    /**
     * How to close a Stream? Stream to non-Stream.
     */
    @Test
    public void testCloseStream(){
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        // .collect()
        List<Integer> list = numbers.stream().filter(e -> e >= 30).collect(Collectors.toList());
        System.out.println(list);
        // .min()
        Optional<Integer> minValue = numbers.stream().filter(e -> e >= 30).min(Comparator.comparingInt(e -> e));
        System.out.println(minValue);
        // .count()
        long cnt = numbers.stream().filter(e -> e >= 30).count();
        System.out.println(cnt);
        // .anyMatch()
        boolean flag = numbers.stream().anyMatch(e -> e >= 30);
        System.out.println(flag);
    }

    /**
     * You cannot reuse a closed Stream object.
     */
    @Test
    public void testReuseStream(){
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        Stream<Integer> stream = list.stream().filter(e -> e<=30);
        List<Integer> restoredList = stream.collect(Collectors.toList());
        /**
         * After calling .collect(), the stream is closed().
         * We try to do map() operations on a closed stream.
         */
        Stream<Integer> integerStream = stream.map(e -> e * 100);
    }
}
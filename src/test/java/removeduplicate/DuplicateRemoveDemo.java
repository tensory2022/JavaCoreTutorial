package removeduplicate;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateRemoveDemo {

    List<String> names = Arrays.asList(
            "hello", "world", "hello", "java", "easy", "java"
    );

    @Test
    public void remove1() {
        List<String> list = new ArrayList<>(names);
        List<String> resultList = new ArrayList<>();
        for (String value : list) {
            if (!resultList.contains(value))
                resultList.add(value);
        }
        System.out.print(resultList);
    }

    @Test
    public void remove2() {
        /**
         * [1,2,3,2,5] --> indexOf(2)=1, lastIndexOf(2)=3   Not equal == duplicated
         * [1,2,3,4,5] --> indexOf(2)=1, lastIndexOf(2)=1   Equal == isolated
         */
        List<String> list = new ArrayList<>(names);
        List<String> resultList = new ArrayList<>(list);


        for (String value : list) {
            int firstIndex = resultList.indexOf(value);
            int lastIndex= resultList.lastIndexOf(value);
            if (firstIndex != lastIndex) {
                resultList.remove(lastIndex);
            }
        }
        System.out.print(resultList);
    }

    @Test
    public void remove3() {
        List<String> list = new ArrayList<>(names);
        HashSet<String> set = new HashSet<>(list);
        List<String> resultList = new ArrayList<>(set);
        System.out.println(resultList);
    }

    @Test
    public void remove4() {
        List<String> list = new ArrayList<>(names);
        LinkedHashSet<String> set = new LinkedHashSet<>(list);
        List<String> resultList = new ArrayList<>(set);
        System.out.println(resultList);
    }

    @Test
    public void remove5() {
        List<String> list = new ArrayList<>(names);
        List<String> result = list.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }
}

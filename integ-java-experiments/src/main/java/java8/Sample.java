package java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample {

    public static void main(String[] args) {
        System.out.println("Hello.");

        List<String> strings = new ArrayList<>();
        Map<String,String> stringMap = new HashMap<>();

        String[] strArray = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN"};

        int counter = 1;
        for(String aString : strArray) {
            strings.add(aString);
            stringMap.put(counter++ +"", aString);
        }

        List<String> filteredList = strings.stream().filter(str -> str.startsWith("T")).collect(Collectors.toList());
        System.out.println(filteredList);

        strings.stream().forEach(str -> System.out.print(str + ", "));

        System.out.println();

        System.out.println("The constructed map is " + stringMap);

        System.out.println("Are all strings non-zero length? " + strings.stream().allMatch(str -> str.length() > 0));
        System.out.println("Are all strings non-zero length? " + strings.stream().allMatch(str -> !str.isEmpty()));
        System.out.println("Are all strings non-zero length? " + strings.stream().allMatch(new MyPredicate()));
        System.out.println("Are all strings non-zero length? " + strings.stream().allMatch(((Predicate<String>)(String::isEmpty)).negate()));

        System.out.println("Total Strings : " + strings.stream().count());

        System.out.println("Random String : " + strings.stream().findAny());

        int[] squareArray = IntStream.range(0,5).parallel().map(x -> x * 2).toArray();

        Arrays.stream(squareArray).forEach(x -> System.out.print(x + " "));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares =
                numbers.stream()
                    .filter(n -> {
                        System.out.println("Filtering " + n);
                        return n % 2 == 0;
                    })
                    .map(n -> {
                        System.out.println("Mapping " + n);
                        return n * n;
                    })
                    .limit(2)
                    .collect(Collectors.toList());
        System.out.println("Two Even Squares " + twoEvenSquares);

        System.out.println(numbers.stream().reduce(1, Integer::max));
        System.out.println(numbers.stream().reduce(1, (a,b)->(a * b)));

    }

    static class MyPredicate implements Predicate<String> {

        @Override
        public boolean test(String s) {
            return s.length() > 0;
        }
    }

}

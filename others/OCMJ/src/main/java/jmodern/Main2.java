package jmodern;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class Main2 {
    
    public static void main(String[] args) {
        List<String> students = range(0,100)
                .mapToObj(i -> randomString(new Random(), 'A', 'Z', 10))
                .collect(Collectors.toList());
        
        Map<Character, List<String>> directory = 
                students.stream().sorted().collect(Collectors.groupingBy(name -> name.charAt(0)));
        
        directory.forEach(
                (letter, names) -> System.out.println(
                        letter + "\n\t" + names.stream().collect(joining("\n\t"))));
    }
    
    public static String randomString(Random r, char from, char to, int length) {
        return r.ints(from, to + 1)
                .limit(length)
                .mapToObj(x -> Character.toString((char)x))
                .collect(joining());
    }
    
    
}

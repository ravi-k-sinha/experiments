package jmodern;

import com.google.common.base.Strings;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(triple("Hello World!"));
        System.out.println("My name is " + System.getProperty("jmodern.name"));
        
        System.out.println(useFooBar(3, 4, (x, y) -> x * y));
    }
    
    static int useFooBar(int x, int y, FooBar fb) {
        return fb.bar(x) ? fb.foo(x, y) : -1;
    }
    
    static String triple(String str) {
        return Strings.repeat(str, 3);
    }
    
    /**
    * ## The Random String Generator
    *
    * This method doesn't do much, except for generating a random string. It:
    *
    *  * Generates a random string at a given length, `length`
    *  * Uses only characters in the range given by `from` and `to`.
    *
    * Example:
    *
    * ```java
    * randomString(new Random(), 'a', 'z', 10);
    * ```
    *
    * @param r      the random number generator
    * @param from   the first character in the character range, inclusive
    * @param to     the last character in the character range, inclusive
    * @param length the length of the generated string
    * @return the generated string of length `length`
    */
   public static String randomString(Random r, char from, char to, int length) {
       return null;
   }
}
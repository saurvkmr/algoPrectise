import java.util.Arrays;

/**
 * Can be done in multiple ways
 * 1. Sort the string chars and then if two positions have same element
 * 2. Using map keeping char and count of appearance
 * 3. Brute force with complexity N^2
 */
public class UniqueCharInStringChecker {
    public static void main(String[] args) {
        var uc = new UniqueCharInStringChecker();
        System.out.println(uc.validateForUniqueCharsInString("saurav"));
        System.out.println(uc.validateForUniqueCharsInString("aaaaaa"));
        System.out.println(uc.validateForUniqueCharsInString("abc"));
    }

    boolean validateForUniqueCharsInString(String input) {
        var chars = new int[52];
        input
                .chars()
                .forEach(it -> chars[it - 97] += 1);
        return Arrays
                .stream(chars)
                .filter(it -> it > 1)
                .count() > 0;
    }
}

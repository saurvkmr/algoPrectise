import java.util.HashMap;
import java.util.Map;

class StringPermutationChecker {
    public static void main(String[] args) {
        if (validateIfPermutation("aa", "aa")
                && validateIfPermutation("aac", "aca"))
            System.out.println("Passed");
        System.out.println(validateIfPermutation("aac", "acaa"));
        System.out.println(validateIfPermutation("aac", "abaa"));
        System.out.println(validateIfPermutation("aaca", "acca"));
    }

    public static boolean validateIfPermutation(String first, String another) {
        if (first.length() != another.length()) return false;
        var firstCharMap = createCharMap(first);
        var anotherCharMap = createCharMap(another);
        return firstCharMap
                .entrySet()
                .stream()
                .allMatch(e -> e.getValue()
                        .equals(anotherCharMap.get(e.getKey())));
    }

    public static Map<Character, Integer> createCharMap(String str) {
        var charMap = new HashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            int count = charMap.getOrDefault(c, 0);
            charMap.put(c, ++count);
        }
        return charMap;
    }
}

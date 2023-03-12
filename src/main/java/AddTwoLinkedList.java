import java.util.stream.IntStream;

public class AddTwoLinkedList {
    public static void main(String[] args) {
        var firstList = new MyLinkedList<Integer>();
        var secondList = new MyLinkedList<Integer>();
        between(100, 200).forEach(num -> firstList.add(num));
        between(350, 450).forEach(num -> secondList.add(num));
        sumTwoLinkedList(firstList, secondList);
    }

    private static void sumTwoLinkedList(MyLinkedList first, MyLinkedList second) {
        System.out.println(sumByIterating(first) + sumByIterating(second));
    }

    private static int sumByIterating(MyLinkedList linkedList) {
        int len = 0, sum = 0;
        while (len < linkedList.size()) {
            sum += (Integer) linkedList.getItemAtIndex(len++);
        }
        return sum;
    }

    private static IntStream between(int start, int end) {
        return IntStream.rangeClosed(start, end);
    }
}

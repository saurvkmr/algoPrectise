public class TestMyLinkedList {
    public static void main(String[] args) {
        var linkedList = new MyLinkedList<String>("Kumar");
        linkedList.add("Saurav").add("Geeta").add("Harry").add("Alison").addAll("Java", "Kotlin", "Go", "Python");
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList);
    }
}

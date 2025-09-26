package collectionframework;
import collectionframework.CustomArrayList;
import collectionframework.CustomStack;
import java.util.Arrays;
class Test
{
    private static void testCustomStack(){
    CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop());       // 30
        System.out.println("Popped: " + stack.pop());       // 20
        System.out.println("Is empty? " + stack.empty()); // false
        System.out.println("Popped: " + stack.pop());       // 10
        System.out.println("Is empty? " + stack.empty()); // true
    }
    private static void testCustomArrayList(){
        CustomArrayList<String> list = new CustomArrayList<>();

        // Test add(E)
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After add: " + list); // [A, B, C]

        // Test add(index, E)
        list.add(1, "X");
        System.out.println("After add at index 1: " + list); // [A, X, B, C]

        // Test get
        System.out.println("Element at 2: " + list.get(2)); // B

        // Test set
        String old = list.set(2, "Y");
        System.out.println("Replaced " + old + " with Y: " + list); // [A, X, Y, C]

        // Test remove
        String removed = list.remove(1);
        System.out.println("Removed " + removed + ": " + list); // [A, Y, C]

        // Test size and isEmpty
        System.out.println("Size: " + list.size()); // 3
        System.out.println("Is empty? " + list.isEmpty()); // false

        // Test clear
        list.clear();
        System.out.println("After clear: " + list); // []
        System.out.println("Size after clear: " + list.size()); // 0
        System.out.println("Is empty after clear? " + list.isEmpty()); // true

        // Test constructor with Collection
        CustomArrayList<Integer> numbers = new CustomArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("From collection: " + numbers); // [1, 2, 3, 4, 5]

        // Test adding more elements to trigger grow
        for (int i = 6; i <= 15; i++)
        {
            numbers.add(i);
        }
        System.out.println("After adding more elements: " + numbers);
        System.out.println("Final size: " + numbers.size()); // 15
    }
    public static void main(String[] args)
    {
        testCustomArrayList();
        testCustomStack();
    }
}
package collectionframework;

import collectionframework.CustomArrayList;
import collectionframework.CustomStack;
import collectionframework.CustomLinkedList;
import collectionframework.CustomHashMap;
import collectionframework.CustomHashSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Test {
    private static void testCustomStack() {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Is empty? " + stack.empty()); // false
        System.out.println("Popped: " + stack.pop()); // 10
        System.out.println("Is empty? " + stack.empty()); // true
    }

    private static void testCustomArrayList() {
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
        for (int i = 6; i <= 15; i++) {
            numbers.add(i);
        }
        System.out.println("After adding more elements: " + numbers);
        System.out.println("Final size: " + numbers.size()); // 15
    }

    private static void testCustomLinkedList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        System.out.println("=== Adding Elements ===");
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        System.out.println("List: " + list);

        System.out.println("\n=== Add at Index ===");
        list.add(2, 99);
        System.out.println("After adding 99 at index 2: " + list);

        System.out.println("\n=== Get Methods ===");
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("\n=== Contains / Index Methods ===");
        System.out.println("Contains 99? " + list.contains(99));
        System.out.println("Index of 3: " + list.indexOf(3));
        System.out.println("Last index of 3: " + list.lastIndexOf(3));

        System.out.println("\n=== Removing Elements ===");
        System.out.println("Removed First: " + list.removeFirst());
        System.out.println("After removeFirst: " + list);
        System.out.println("Removed Last: " + list.removeLast());
        System.out.println("After removeLast: " + list);
        System.out.println("Removed at index 1: " + list.remove(1));
        System.out.println("After remove(1): " + list);

        System.out.println("\n=== Adding Again ===");
        list.addFirst(10);
        list.addLast(20);
        list.add(1, 15);
        System.out.println("After adding again: " + list);

        System.out.println("\n=== Convert to Array ===");
        Object[] array = list.toArray();
        System.out.print("Array elements: ");
        for (Object o : array)
            System.out.print(o + " ");
        System.out.println();

        System.out.println("\n=== Size and Clear ===");
        System.out.println("List size: " + list.size());
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty? " + list.isEmpty());
    }

    private static void testCustomHashMap() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Test put and get
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println("Value for A: " + map.get("A")); // Expected 1
        System.out.println("Value for B: " + map.get("B")); // Expected 2
        System.out.println("Value for Z (nonexistent): " + map.get("Z")); // Expected null

        // Test getOrDefault
        System.out.println("Value for Z with default: " + map.getOrDefault("Z", -1)); // Expected -1

        // Test containsKey and containsValue
        System.out.println("Contains key B: " + map.containsKey("B")); // Expected true
        System.out.println("Contains key X: " + map.containsKey("X")); // Expected false
        System.out.println("Contains value 2: " + map.containsValue(2)); // Expected true
        System.out.println("Contains value 10: " + map.containsValue(10)); // Expected false

        // Test replace
        System.out.println("Replace value for B: " + map.replace("B", 20)); // Expected old value 2
        System.out.println("Replace successful? " + map.replace("C", 3, 30)); // Expected true
        System.out.println("Replace unsuccessful? " + map.replace("C", 3, 300)); // Expected false

        // Test values() list
        System.out.println("All values: " + map.values()); // Expected [1, 20, 30] in some order

        // Test resizing by adding more elements
        for (int i = 0; i < 20; i++) {
            map.put("Key" + i, i);
        }
        System.out.println("Size after adding 20 elements: " + map.size());

        // Test clear
        map.clear();
        System.out.println("Size after clear: " + map.size()); // Expected 0
        System.out.println("Is map empty? " + map.isEmpty()); // Expected true
    }

    private static void testCustomHashSet() {
        CustomHashSet<String> set1 = new CustomHashSet<>();

        // Add individual elements
        System.out.println("Adding elements to set1:");
        set1.add("Apple");
        set1.add("Banana");
        set1.add("Orange");
        System.out.println("Size of set1: " + set1.size());

        // Try adding duplicate
        System.out.println("\nTrying to add duplicate 'Apple': " + set1.add("Apple"));

        // Check if elements exist
        System.out.println("\nChecking contains:");
        System.out.println("Contains 'Apple': " + set1.contains("Apple"));
        System.out.println("Contains 'Grape': " + set1.contains("Grape"));

        // Create a set from collection
        List<String> fruits = Arrays.asList("Mango", "Pineapple", "Apple");
        CustomHashSet<String> set2 = new CustomHashSet<>(fruits);
        System.out.println("\nset2 size after creation from list: " + set2.size());

        // Remove an element
        System.out.println("\nRemoving 'Mango' from set2: " + set2.remove("Mango"));
        System.out.println("set2 size after removal: " + set2.size());

        // Clear the set
        set2.clear();
        System.out.println("\nset2 is empty after clear: " + set2.isEmpty());
    }

    public static void main(String[] args) {
        testCustomArrayList();
        testCustomStack();
        testCustomLinkedList();
        testCustomHashMap();
        testCustomHashSet();
    }
}
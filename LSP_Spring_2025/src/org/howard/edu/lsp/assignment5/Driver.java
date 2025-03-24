package org.howard.edu.lsp.assignment5;
/**
 * Driver class for testing IntegerSet class.
 */
public class Driver {
    public static void main(String[] args) {
        // ====== Testing add(), toString(), smallest(), largest() ======
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());

        // ====== Testing another set and union() ======
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        // ====== Testing intersect() ======
        IntegerSet set3 = new IntegerSet();
        set3.add(2);
        set3.add(3);
        set3.add(6);
        System.out.println("\nValue of Set1 before intersect: " + set1.toString());
        System.out.println("Value of Set3: " + set3.toString());
        set1.intersect(set3);
        System.out.println("Result of intersect between Set1 and Set3: " + set1.toString());

        // ====== Testing diff() ======
        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        System.out.println("\nValue of Set1 before diff: " + set1.toString());
        System.out.println("Value of Set4: " + set4.toString());
        set1.diff(set4);
        System.out.println("Result of diff between Set1 and Set4: " + set1.toString());

        // ====== Testing complement() ======
        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        set5.add(3);
        System.out.println("\nSet1 before complement: " + set1.toString());
        System.out.println("Set5: " + set5.toString());
        set1.complement(set5);
        System.out.println("Result of complement of Set1 with Set5: " + set1.toString());

        // ====== Testing contains() ======
        System.out.println("\nTesting contains()");
        System.out.println("Set1: " + set1.toString());
        System.out.println("Does Set1 contain 2? " + set1.contains(2));
        System.out.println("Does Set1 contain 3? " + set1.contains(3));

        // ====== Testing equals() ======
        IntegerSet set6 = new IntegerSet();
        set6.add(1);
        set6.add(2);
        IntegerSet set7 = new IntegerSet();
        set7.add(2);
        set7.add(1);
        System.out.println("\nTesting equals()");
        System.out.println("Set6: " + set6.toString());
        System.out.println("Set7: " + set7.toString());
        System.out.println("Set6 equals Set7? " + set6.equals(set7));

        // ====== Testing remove() ======
        System.out.println("\nTesting remove()");
        System.out.println("Set6 before remove(1): " + set6.toString());
        set6.remove(1);
        System.out.println("Set6 after remove(1): " + set6.toString());

        // ====== Testing isEmpty() ======
        System.out.println("\nTesting isEmpty()");
        System.out.println("Is Set6 empty? " + set6.isEmpty());
        set6.clear();
        System.out.println("Set6 after clear(): " + set6.toString());
        System.out.println("Is Set6 empty now? " + set6.isEmpty());

        // ====== Testing length() ======
        IntegerSet set8 = new IntegerSet();
        set8.add(10);
        set8.add(20);
        System.out.println("\nTesting length()");
        System.out.println("Set8: " + set8.toString());
        System.out.println("Length of Set8: " + set8.length());
    }
}

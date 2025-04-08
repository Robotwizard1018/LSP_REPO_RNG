package org.howard.edu.lsp.assignment6;

import java.util.*;

/**
 * IntegerSet represents a set of integers using an ArrayList internally.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor
     */
    public IntegerSet() {
    }

    /**
     * Constructor with pre-initialized list of integers
     * @param set an already initialized ArrayList of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set. 5 pts.
     */
    public void clear() {
        this.set.clear();
    }

    /**
     * Returns the length of the set. 5 pts.
     * @return number of elements in the set
     */
    public int length() {
        return this.set.size();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
     * This overrides the equals method from the Object class. 10 pts.
     * @param o another object to compare
     * @return true if sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) {
            return false;
        }
        IntegerSet other = (IntegerSet) o;

        if (this.set.size() != other.set.size()) return false;

        for (int i = 0; i < this.set.size(); i++) {
            if (!other.set.contains(this.set.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the set contains the value, otherwise false. 5 pts.
     * @param value the value to check
     * @return true if the set contains the value
     */
    public boolean contains(int value) {
        return this.set.contains(value);
    }
    
    
    /**
     * Returns the largest item in the set. 5 pts.
     * Throws NoSuchElementException if the set is empty.
     *
     * @return the largest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int largest() {
        if (this.set.isEmpty()) {
            throw new NoSuchElementException("Set is empty. Cannot determine the largest value.");
        }
        return Collections.max(this.set);
    }

    /**
     * Returns the smallest item in the set. 5 pts.
     * Throws NoSuchElementException if the set is empty.
     *
     * @return the smallest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int smallest() {
        if (this.set.isEmpty()) {
            throw new NoSuchElementException("Set is empty. Cannot determine the smallest value.");
        }
        return Collections.min(this.set);
    }

    /**
     * Adds an item to the set or does nothing if already there. 5 pts.
     * @param item the item to add
     */
    public void add(int item) {
        if (!this.set.contains(item)) {
            this.set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not there. 5 pts.
     * @param item the item to remove
     */
    public void remove(int item) {
        this.set.remove((Integer) item);
    }

    /**
     * Set union. Adds all elements from intSetb to this set. 11 pts.
     * @param intSetb another IntegerSet
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    /**
     * Set intersection, all elements in both sets are retained. 12 pts.
     * @param intSetb another IntegerSet
     */
    public void intersect(IntegerSet intSetb) {
        this.set.retainAll(intSetb.set);
    }

    /**
     * Set difference, i.e., elements in this set not in intSetb. 12 pts.
     * @param intSetb another IntegerSet
     */
    public void diff(IntegerSet intSetb) {
        this.set.removeAll(intSetb.set);
    }

    /**
     * Set complement, replaces this set with elements not in this set but in intSetb. 11 pts.
     * @param intSetb another IntegerSet
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                temp.add(num);
            }
        }
        this.set = temp;
    }

    /**
     * Returns true if the set is empty, false otherwise. 5 pts.
     * @return true if empty
     */
    boolean isEmpty() {
        return this.set.isEmpty();
    }

    /**
     * Return String representation of your set.
     * This overrides the toString method from the Object class. 5 pts.
     * @return string version of the set
     */
    @Override
    public String toString() {
        return this.set.toString();
    }
}
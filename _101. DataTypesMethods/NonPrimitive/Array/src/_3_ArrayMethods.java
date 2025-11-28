// File: _2_ArrayMethods.java
// Topic: Array Utility Methods (java.util.Arrays)
// 🧠 Only METHODS with Meaning + Syntax + Example + Output

import java.util.Arrays;

public class _3_ArrayMethods {

    public static void main(String[] args) {

        // =====================================================
        // 🧩 1️⃣ Arrays.toString()
        // =====================================================
        // Meaning: Converts the entire array into a readable String format.
        // Syntax:
        //     String s = Arrays.toString(array);
        //
        // Example:
        int[] arr = {10, 20, 30};
        System.out.println(Arrays.toString(arr));
        // Output:
        // [10, 20, 30]


        // =====================================================
        // 🧩 2️⃣ Arrays.sort()
        // =====================================================
        // Meaning: Sorts the array in ascending order (in-place).
        // Syntax:
        //     Arrays.sort(array);
        //
        // Example:
        int[] nums = {5, 1, 4, 2};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        // Output:
        // [1, 2, 4, 5]


        // =====================================================
        // 🧩 3️⃣ Arrays.fill()
        // =====================================================
        // Meaning: Fills the entire array with a single specified value.
        // Syntax:
        //     Arrays.fill(array, value);
        //
        // Example:
        int[] fill = new int[4];
        Arrays.fill(fill, 9);
        System.out.println(Arrays.toString(fill));
        // Output:
        // [9, 9, 9, 9]


        // =====================================================
        // 🧩 4️⃣ Arrays.copyOf()
        // =====================================================
        // Meaning: Creates a new array by copying elements from the original array.
        //          If new length is larger → remaining values are default.
        // Syntax:
        //     type[] newArr = Arrays.copyOf(oldArr, newLength);
        //
        // Example:
        int[] small = {1, 2};
        int[] big = Arrays.copyOf(small, 5);
        System.out.println(Arrays.toString(big));
        // Output:
        // [1, 2, 0, 0, 0]


        // =====================================================
        // 🧩 5️⃣ Arrays.copyOfRange()
        // =====================================================
        // Meaning: Copies a portion of the array from index 'from' (inclusive)
        //          to index 'to' (exclusive).
        // Syntax:
        //     type[] part = Arrays.copyOfRange(array, from, to);
        //
        // Example:
        int[] rangeSource = {10, 20, 30, 40};
        int[] part = Arrays.copyOfRange(rangeSource, 1, 3);
        System.out.println(Arrays.toString(part));
        // Output:
        // [20, 30]


        // =====================================================
        // 🧩 6️⃣ Arrays.equals()
        // =====================================================
        // Meaning: Compares two one-dimensional arrays element by element.
        // Syntax:
        //     boolean result = Arrays.equals(arr1, arr2);
        //
        // Example:
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println(Arrays.equals(a, b));
        // Output:
        // true


        // =====================================================
        // 🧩 7️⃣ Arrays.binarySearch()
        // =====================================================
        // Meaning: Searches for an element in a SORTED array.
        //          Returns index if found, else negative value.
        // Syntax:
        //     int index = Arrays.binarySearch(array, key);
        //
        // Example:
        int[] searchArr = {10, 30, 40, 99}; // already sorted
        int idx = Arrays.binarySearch(searchArr, 40);
        System.out.println(idx);
        // Output:
        // 2


        // =====================================================
        // 🧩 8️⃣ Arrays.deepToString() (2D Array)
        // =====================================================
        // Meaning: Converts multi-dimensional array into readable String format.
        // Syntax:
        //     String s = Arrays.deepToString(2DArray);
        //
        // Example:
        int[][] mat = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(mat));
        // Output:
        // [[1, 2], [3, 4]]
    }
}

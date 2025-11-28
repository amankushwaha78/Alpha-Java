// File: _1_ArrayBasics_Explained.java
// Topic: All Array Methods & Concepts (Clean Explanation + Example + Output)

public class _1_ArrayBasics {

    public static void main(String[] args) {

        // =====================================================
        // 1) DECLARATION & INITIALIZATION
        // =====================================================

        // ➤ (1) Single-dimensional array declaration
        // Meaning: How to declare an array variable
        // Syntax:
        //     type[] arr;
        // Example:
        int[] numbers;
        int nums[]; // also valid

        // ➤ (2) Array instantiation
        // Meaning: Allocate memory for array
        // Syntax:
        //     arr = new type[size];
        numbers = new int[5]; // default values 0
        System.out.println(numbers.length); // Output: 5

        // ➤ (3) Array initialization with values
        int[] vals = {10, 20, 30, 40};
        System.out.println(vals[2]); // Output: 30


        // =====================================================
        // 2) ACCESS & ITERATION
        // =====================================================

        // ➤ (4) Access element
        // Syntax:
        //     arr[index]
        System.out.println(vals[0]); // Output: 10

        // ➤ (5) Loop iteration
        for (int i = 0; i < vals.length; i++) {
            System.out.print(vals[i] + " "); // Output: 10 20 30 40
        }

        System.out.println();

        // ➤ (6) Enhanced for-loop
        for (int v : vals) {
            System.out.print(v + " "); // Output: 10 20 30 40
        }


        // =====================================================
        // 3) MULTI-DIMENSIONAL ARRAYS
        // =====================================================

        // ➤ (7) 2D Array declaration
        int[][] matrix = new int[2][3]; // 2 rows, 3 columns

        // ➤ (8) 2D Array initialization
        int[][] grid = {{1,2,3}, {4,5,6}};
        System.out.println(grid[1][2]); // Output: 6

        // ➤ (9) 2D Array iteration
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " "); // Output: 1 2 3 4 5 6
            }
        }

        // ... Continue with SORT, COPY, FILL, SEARCH etc.
    }
}

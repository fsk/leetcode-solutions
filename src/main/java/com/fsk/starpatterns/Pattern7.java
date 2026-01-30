package com.fsk.starpatterns;

public class Pattern7 {

    public static void printPattern(int n) {
        int i, j;

        // Printing the upper part
        for (i = 1; i <= n; i++) {
            // Inner loop to print spaces.
            for (j = 1; j < i; j++) {
                System.out.print(" ");  // Space before stars begin
            }
            // Inner loop to print value of j.
            for (j = i; j <= n; j++) {
                if (j == i || j == n || i == 1)
                    System.out.print("* ");  // Print stars at the edges and first row
                else
                    System.out.print("  ");  // Print spaces inside the diamond
            }

            // Printing new line for each row
            System.out.println();
        }

        // Printing the lower part
        for (i = n - 1; i >= 1; i--) {
            // Inner loop to print spaces.
            for (j = 1; j < i; j++) {
                System.out.print(" ");  // Space before stars begin
            }
            // Inner loop to print value of j.
            for (j = i; j <= n; j++) {
                if (j == i || j == n || i == 1)
                    System.out.print("* ");  // Print stars at the edges and first row
                else
                    System.out.print("  ");  // Print spaces inside the diamond
            }
            // Printing new line for each row
            System.out.println();
        }
    }

    // Driver Function
    public static void main(String args[]) {
        int n = 5;
        printPattern(n);
    }

}

import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to check: ");
        String input = sc.nextLine().trim();

        boolean iterativeResult = isPalindromeIterative(input);
        boolean recursiveResult = isPalindromeRecursive(input);
        boolean arrayResult = isPalindromeArrayReversal(input);

        System.out.println("Iterative: " + (iterativeResult ? "Palindrome" : "Not Palindrome") +
                " | Recursive: " + (recursiveResult ? "Palindrome" : "Not Palindrome") +
                " | Array Reversal: " + (arrayResult ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
